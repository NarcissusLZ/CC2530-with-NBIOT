package com.example.smartanimal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.Exception
import kotlin.concurrent.thread

class HumidityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_humidity)

        val humidity_back_buton : Button = findViewById(R.id.humidity_back_button)
        humidity_back_buton.setOnClickListener {
            val intent = Intent(this,ObjectActivity::class.java)
            startActivity(intent)
        }

        val humidity_refresh_button : Button = findViewById(R.id.humidity_refresh_button)
        humidity_refresh_button.setOnClickListener {
            val humidity1 : TextView = findViewById(R.id.humidity1)
            val humidity2 : TextView = findViewById(R.id.humidity2)
            getData(humidity1,"3304_0_5700")
            getData(humidity2,"3304_1_5700")
        }
    }

    private fun getData(textView: TextView,value:String) {
        thread{
            try{
                val client = OkHttpClient()
                //请输入自己的APIkey
                val reBuild = Request.Builder().addHeader("api-key","")
                //还请输入自己所需使用的链接API，以及自己设备的APIkey之类的，我已删除我的
                //具体的API接口，可上onenet的网页查看
                val urlBuilder = "https://api.heclouds.com/devices/(deviceID)/datapoints".toHttpUrlOrNull()!!.newBuilder()
                urlBuilder.addQueryParameter("datastream_id",value)
                reBuild.url(urlBuilder.build())
                val request = reBuild.build()
                val response = client.newCall(request).execute()
                val responseData = response.body?.string()
                Log.d("onenet", responseData!!)
                val pattern = Regex("""\"value\":\d{2,3}""")
                val data:String? = pattern.find(responseData.toString())?.value
                Log.d("onenet",data.toString())
                val pattern2 = Regex("""\d{2,3}""")
                val temp = pattern2.find(data.toString())?.value
                Log.d("temp",temp.toString())
                textView.text = temp.toString()
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}