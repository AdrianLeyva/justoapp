package com.justo.justoapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author adrianleyvasanchez
 * @since 7/25/21
 */
@Parcelize
data class Street(
    val number: Long,
    val name: String
) : Parcelable
