import time
import serial
import re

#获取返回的数据
def getbackMsg(ser):
    if ser.inWaiting():
        time.sleep(1)
        rec_buff = ser.read(ser.inWaiting())
    if rec_buff != '':
        print(rec_buff.decode())
        return rec_buff.decode()

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
    sendAT('AT+MIPLADDOBJ=0,3303,2,11,7,3',ser)
    #建立两个湿度计的实例
    sendAT('AT+MIPLADDOBJ=0,3304,2,11,7,3',ser)
    #建立一个光照实例
    sendAT('AT+MIPLADDOBJ=0,3301,1,1,7,3',ser)

    ser.write(('AT+MIPLOPEN=0,180'+'\r\n').encode())

#对于zigbee协调器获取的数据进行分析
def TempRe(data):
    mo1Regex = re.compile(r'Temperature:\d*')
    mo1 = mo1Regex.search(data)
    mo2Regex = re.compile(r'\d{2,3}')
    mo2 = mo2Regex.search(mo1.group())
    return mo2.group()

#上报数据
def sendNotify(ser7020,serZigbee):
    #每一个实例都会返回一个专门的msgid
    msgid_3301_0 = sendObserver(ser7020)
    msgid_3303_0 = sendObserver(ser7020)
    msgid_3303_1 = sendObserver(ser7020)
    msgid_3304_0 = sendObserver(ser7020)
    msgid_3304_1 = sendObserver(ser7020)
    #每个ObjectID对应一个discover订阅命令
    sendDiscover(ser7020)
    sendDiscover(ser7020)
    sendDiscover(ser7020)
    i=0
    while i<5:
        time.sleep(5)                               #每5秒上传一次数据
        data = getbackMsg(serZigbee)
        temp = TempRe(data)
        #sendAT('AT+MIPLNOTIFY=0,'+msgid_3301_0+',3301,0,5700,4,2,34,0,0',ser7020)
        sendAT('AT+MIPLNOTIFY=0,'+msgid_3303_0+',3303,0,5700,4,2,'+temp+',0,0',ser7020)
        #sendAT('AT+MIPLNOTIFY=0,'+msgid_3303_1+',3303,1,5700,4,4,34.2,0,0',ser7020)
        #sendAT('AT+MIPLNOTIFY=0,'+msgid_3304_0+',3303,0,5700,4,2,36,0,0',ser7020)
        #sendAT('AT+MIPLNOTIFY=0,'+msgid_3304_1+',3303,1,5700,4,4,34.2,0,0',ser7020)
        i+=1
    
    

#关闭连接，释放NB-Iot资源
def NBclose(ser):
    sendAT('AT+MIPLCLOSE=0',ser)
    sendAT('AT+MIPLDELETE=0',ser)
    ser.close()

def main():
    portx = 'COM4'                                  #按照自己打开的端口设置，树莓派可改用dev或者USB，stm32等单片机选择适合的串口
    bps=115200                                      #SIM7020c使用的串口波特率为115200
    timex=5                                         #设置超时重传
    ser7020 = serial.Serial(portx,bps,timeout=timex)    #设置ser7020为打开SIM7020c的端口，通过该端口进行NB-Iot的连接与发送数据
    if ser7020.isOpen() == True :                   #判断SIM7020c首先打开
        print("Serial Open Success!")
        print("Try to check the net!\n")
        tryNet(ser7020)                             #首先检查NB-Iot的网络连接
        createEXT(ser7020)                          #与Onenet建立网络连接，使用其他的物联网云平台可以自行查看SIM7020c的AT指令
    else:
        print("Serial Open defualt!")
        return
    portx = 'COM3'
    bps = 9600
    timex = 5
    serZigbee = serial.Serial(portx,bps,timeout=timex)
    if serZigbee.isOpen() == True :
        time.sleep(10)                              #先等待数据的传送
        sendNotify(ser7020,serZigbee)
    NBclose(ser7020)                                #释放NB-Iot的资源连接
    serZigbee.close()
    print('close the serial')

if __name__ == "__main__":
    main() 

