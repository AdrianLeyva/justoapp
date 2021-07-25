package com.justo.justoapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author adrianleyvasanchez
 * @since 7/24/21
 */
@Parcelize
data class Timezone(
    val offset: String,
    val description: String
) : Parcelable
