package com.justo.justoapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author adrianleyvasanchez
 * @since 7/24/21
 */
@Parcelize
data class Login(
    val uuid: String,
    val username: String,
    val password: String,
    val salt: String,
    val md5: String,
    val sha1: String,
    val sha256: String
) : Parcelable
