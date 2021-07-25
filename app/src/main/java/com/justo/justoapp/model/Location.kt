package com.justo.justoapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author adrianleyvasanchez
 * @since 7/24/21
 */
@Parcelize
data class Location(
    val street: Street,
    val city: String,
    val state: String,
    val postcode: String,
    val coordinates: Coordinates,
    val timezone: Timezone
) : Parcelable