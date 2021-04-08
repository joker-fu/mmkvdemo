package cn.jk.mmkv

import com.tencent.mmkv.MMKV

/**
 *  author : joker
 *  date : 2021/4/8 19:36
 *  description : 
 */
object MMKVUtils {

    val mmkv = MMKV.defaultMMKV()

    fun saveStr(key: String, value: String): Boolean? {
        return mmkv?.encode(key, value)
    }

    fun getStr(key: String): String? {
        return mmkv?.decodeString(key)
    }

    fun saveP(key: String, value: User): Boolean? {
        return mmkv?.encode(key, value)
    }

    fun getP(key: String): User? {
        return mmkv?.decodeParcelable(key, User::class.java)
    }

}