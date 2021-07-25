package com.justo.justoapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author adrianleyvasanchez
 * @since 7/24/21
 */
@Parcelize
data class RandomUser(
    val gender: String,
    val name: Name,
    val location: Location,
    val timezone: Timezone,
    val email: String,
    val login: Login,
    val dob: Dob,
    val registered: Register,
    val phone: String,
    val cell: String,
    val id: Id,
    val picture: Picture,
    val nat: String
) : Parcelable