import time
import serial
import re
import binascii

portx = 'COM4'
bps = 38400
timex = 5
serZigbee = serial.Serial(portx,bps,timeout=timex)

portx = 'COM3'                                        #按照自己打开的端口设置，树莓派可改用dev或者USB，stm32等单片机选择适合的串口
bps=115200                                            #SIM7020c使用的串口波特率为115200
timex=5                                               #设置超时重传
ser7020 = serial.Serial(portx,bps,timeout=timex)      #设置ser7020为打开SIM7020c的端口，通过该端口进行NB-Iot的连接与发送数据

def get_msgid(data):
    mo1Regex = re.compile(r'MIPLEXECUTE: 0,\d{3,7}')
    mo1 = mo1Regex.search(data)
    mo2Regex = re.compile(r'\d{3,7}')
    mo2 = mo2Regex.search(mo1.group())
    return mo2.group()

def get_instanceid(data):
    mo1Regex = re.compile(r'\d{3,7},0,5605')
    mo1 = mo1Regex.search(data)
    if mo1 != None :
        return "0"
    mo1Regex = re.compile(r'\d{3,7},1,5605')
    mo1 = mo1Regex.search(data)
    if mo1 != None :
        return "1"
    mo1Regex = re.compile(r'\d{3,7},2,5605')
    mo1 = mo1Regex.search(data)
    if mo1 != None :
        return "2"
    mo1Regex = re.compile(r'\d{3,7},3,5605')
    mo1 = mo1Regex.search(data)
    if mo1 != None :
        return "3"
    

def get_door(data):
    mo1Regex = re.compile(r'open')
    mo1 = mo1Regex.search(data)
    if mo1 != None :
        return True
    else:
        return False

#获取返回的数据
def getbackMsg(ser):
    rec_buff=""
    if ser.inWaiting():
        time.sleep(1)
        rec_buff = ser.read(ser.inWaiting())
    if rec_buff != '':
        print(rec_buff.decode())
        mo1Regex = re.compile(r'MIPLEXECUTE:')
        mo1 = mo1Regex.search(rec_buff.decode())
        strdata = rec_buff.decode()
        if mo1 != None:
            msg_id = get_msgid(strdata)
            instance_id = get_instanceid(strdata)
            print("instancd_id = "+instance_id)
            door = get_door(strdata)
            if(instance_id == '0'):
                if(door == True):
                    serZigbee.write(b'\x3A\x00\x01\x0A\x00\x31\x23')
                else:
                    serZigbee.write(b'\x3A\x00\x01\x0A\x01\x30\x23')
            if(instance_id == '1'):
                if(door == True):
                    serZigbee.write(b'\x3A\x00\x02\x0A\x00\x32\x23')
                else:
                    serZigbee.write(b'\x3A\x00\x02\x0A\x01\x33\x23')
            if(instance_id == '2'):
                if(door == True):
                    serZigbee.write(b'\x3A\x00\x03\x0A\x00\x33\x23')
                else:
                    serZigbee.write(b'\x3A\x00\x03\x0A\x01\x32\x23')
            if(instance_id == '3'):
                if(door == True):
                    serZigbee.write(b'\x3A\x00\x04\x0A\x00\x34\x23')
                else:
                    serZigbee.write(b'\x3A\x00\x04\x0A\x01\x35\x23')
            sendAT("AT+MIPLEXECUTERSP=0,"+msg_id+",2",ser)
        return rec_buff.decode()
    else:
        return ""

#发送AT指令
def sendAT(command,ser):
    ser.write((command+'\r\n').encode())
    time.sleep(1)
    getbackMsg(ser)

#测试网络连接
#其下所代表的AT指令含义可自行查看SIM7020c的文档
def tryNet(ser):
    sendAT('AT',ser)
    sendAT('AT+CPIN?',ser)
    sendAT('AT+CSQ',ser)
    sendAT('AT+CGREG?',ser)
    sendAT('AT+COPS?',ser)
    sendAT('AT+CGCONTRDP',ser)

#正则表达式对返回内容进行分析，获取关键数据
#对observe指令进行分析
def getObserverBack(backmsg):
    mo1Regex = re.compile(r'OBSERVE: 0,\d*')
    mo1 = mo1Regex.search(backmsg)
    print(backmsg)
    mo2Regex = re.compile(r'\d{2,10}')
    mo2 = mo2Regex.search(mo1.group())
    return mo2.group()

#对discover指令进行分析
def getDiscoverBack(backmsg):
    mo1Regex = re.compile(r'DISCOVER: 0,\d*')
    mo1 = mo1Regex.search(backmsg)
    print(backmsg)
    mo2Regex = re.compile(r'\d{2,10}')
    mo2 = mo2Regex.search(mo1.group())
    return mo2.group()

#返回observer指令
def sendObserver(ser):
    time.sleep(10)
    backmsg = getbackMsg(ser)
    msgid = getObserverBack(backmsg)
    command = 'AT+MIPLOBSERVERSP=0,'+msgid+',1'
    sendAT(command,ser)
    return msgid

#返回discover指令
def sendDiscover(ser):
    time.sleep(10)
    backmsg = getbackMsg(ser)
    msgid = getDiscoverBack(backmsg)
    command = 'AT+MIPLDISCOVERRSP=0,'+msgid+',1,34,"5700;5701;5601;5602;5603;5604;5605"'
    sendAT(command,ser)
    return msgid



#建立连接
def createEXT(ser):
    sendAT('AT+MIPLCREATE',ser)

    #建立两个温度计的实例
    sendAT('AT+MIPLADDOBJ=0,3303,4,1111,7,3',ser)
    #建立两个湿度计的实例
    sendAT('AT+MIPLADDOBJ=0,3304,4,1111,7,3',ser)
    #建立一个光照实例
    #sendAT('AT+MIPLADDOBJ=0,3301,1,1,7,3',ser)

    ser.write(('AT+MIPLOPEN=0,180'+'\r\n').encode())

#对于zigbee协调器获取的数据进行分析


#上报数据
def sendNotify(ser7020,serZigbee):
    #每一个实例都会返回一个专门的msgid
    msgid_3303_0 = sendObserver(ser7020)
    msgid_3303_1 = sendObserver(ser7020)
    msgid_3303_2 = sendObserver(ser7020)
    msgid_3303_3 = sendObserver(ser7020)
    msgid_3304_0 = sendObserver(ser7020)
    msgid_3304_1 = sendObserver(ser7020)
    msgid_3304_2 = sendObserver(ser7020)
    msgid_3304_3 = sendObserver(ser7020)
    #每个ObjectID对应一个discover订阅命令
    sendDiscover(ser7020)
    sendDiscover(ser7020)
    i=0
    while i<5:
        time.sleep(5)                               #每5秒上传一次数据
        serZigbee.write(b'\x3A\x00\xFF\x01\xC4\x23')        #获取所有节点的传感器数据
        time.sleep(3)
        count = serZigbee.inWaiting()
        if count>0:
            data=serZigbee.read(count)
            if data!=b'':
                data = str(binascii.b2a_hex(data))[2:-1]
        temp0 = str(int(data[8]+data[9],16))
        humidity0 = str(int(data[10]+data[11],16))
        temp1 = str(int(data[16]+data[17],16))
        humidity1 = str(int(data[18]+data[19],16))
        temp2 = str(int(data[24]+data[25],16))
        humidity2 = str(int(data[26]+data[27],16))
        temp3 = str(int(data[32]+data[33],16))
        humidity3 = str(int(data[34]+data[35],16))

        sendAT('AT+MIPLNOTIFY=0,'+msgid_3303_0+',3303,0,5700,4,2,'+temp0+',0,0',ser7020)
        sendAT('AT+MIPLNOTIFY=0,'+msgid_3303_1+',3303,1,5700,4,2,'+temp1+',0,0',ser7020)
        sendAT('AT+MIPLNOTIFY=0,'+msgid_3303_2+',3303,2,5700,4,2,'+temp2+',0,0',ser7020)
        sendAT('AT+MIPLNOTIFY=0,'+msgid_3303_3+',3303,3,5700,4,2,'+temp3+',0,0',ser7020)
        sendAT('AT+MIPLNOTIFY=0,'+msgid_3304_0+',3304,0,5700,4,2,'+humidity0+',0,0',ser7020)
        sendAT('AT+MIPLNOTIFY=0,'+msgid_3304_1+',3304,1,5700,4,2,'+humidity1+',0,0',ser7020)
        sendAT('AT+MIPLNOTIFY=0,'+msgid_3304_2+',3304,2,5700,4,2,'+humidity2+',0,0',ser7020)
        sendAT('AT+MIPLNOTIFY=0,'+msgid_3304_3+',3304,3,5700,4,2,'+humidity3+',0,0',ser7020)
        i+=1

#关闭连接，释放NB-Iot资源
def NBclose(ser):
    sendAT('AT+MIPLCLOSE=0',ser)
    sendAT('AT+MIPLDELETE=0',ser)
    ser.close()

def main():
    if ser7020.isOpen() == True :                   #判断SIM7020c首先打开
        print("Serial Open Success!")
        print("Try to check the net!\n")
        tryNet(ser7020)                             #首先检查NB-Iot的网络连接
        createEXT(ser7020)                          #与Onenet建立网络连接，使用其他的物联网云平台可以自行查看SIM7020c的AT指令
    else:
        print("Serial Open defualt!")
        return
    
    if serZigbee.isOpen() == True :
        time.sleep(5)                              #先等待数据的传送
        sendNotify(ser7020,serZigbee)
    NBclose(ser7020)                                #释放NB-Iot的资源连接
    serZigbee.close()
    print('close the serial')

if __name__ == "__main__":
    main() 

