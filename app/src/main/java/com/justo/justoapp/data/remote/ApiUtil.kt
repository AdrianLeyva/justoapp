package com.justo.justoapp.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author adrianleyvasanchez
 * @since 7/24/21
 */
object ApiUtil {

    const val KEY_PAGE = "page"
    const val KEY_RESULTS = "results"
    const val KEY_SEED = "seed"

    fun buildRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}