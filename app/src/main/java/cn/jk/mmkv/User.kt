package cn.jk.mmkv

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 *  author : joker
 *  date : 2021/4/8 19:53
 *  description : 
 */
@Parcelize
data class User(
    val id: Long?,
    val name: String?,
    val sex: String?,
    val authorities: List<String?>? = listOf(),
) : Parcelable