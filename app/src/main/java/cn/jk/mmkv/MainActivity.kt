package cn.jk.mmkv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val str1 = MMKVUtils.getStr("test1")

        println("===============> test1：  $str1")
    }

    fun onClick1(view: View) {
        MMKVUtils.saveStr("test1", "aaaaaaaaa")
        println("===============> 读写测试 写入：  aaaaaaaaa")
        val str1 = MMKVUtils.getStr("test1")

        println("===============> 读写测试 读取：  $str1")
    }

    fun onClick2(view: View) {
        startActivity(Intent(this, Demo1Activity::class.java))
    }

    fun onClick3(view: View) {

        val map = (0..10000).map { "asdasdas$it" }
        val user = User(1, "aaa", null, map)
        MMKVUtils.saveP("test2", user)
        println("===============> Parcelable读写测试 写入：  $user")
        val res = MMKVUtils.getP("test2")

        println("===============> Parcelable读写测试 读取：  $res")
    }
}