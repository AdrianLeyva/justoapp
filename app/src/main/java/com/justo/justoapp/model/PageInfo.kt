package com.justo.justoapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author adrianleyvasanchez
 * @since 7/24/21
 */
@Parcelize
data class PageInfo(
    val seed: String,
    val results: Int,
    val page: Int,
    val version: String? = ""
) : Parcelable