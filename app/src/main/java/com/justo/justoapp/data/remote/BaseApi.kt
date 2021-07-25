package com.justo.justoapp.data.remote

import android.os.Parcelable
import com.justo.justoapp.model.PageInfo
import com.justo.justoapp.model.RandomUser
import kotlinx.android.parcel.Parcelize

/**
 * @author adrianleyvasanchez
 * @since 7/24/21
 */
data class BaseApi(
    val results: ArrayList<RandomUser>,
    val info: PageInfo
)