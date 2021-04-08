package cn.jk.mmkv

import android.app.Application
import com.tencent.mmkv.MMKV

/**
 *  author : joker
 *  date : 2021/4/8 19:33
 *  description : 
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        MMKV.initialize(this)
    }
}