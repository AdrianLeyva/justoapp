package com.justo.justoapp.data.remote.api

import com.justo.justoapp.data.remote.ApiUtil
import com.justo.justoapp.data.remote.BaseApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author adrianleyvasanchez
 * @since 7/24/21
 */
interface RandomUserService {

    @GET("/api")
    fun fetchAll(
            @Query(ApiUtil.KEY_PAGE) page: Int,
            @Query(ApiUtil.KEY_RESULTS) results: Int,
            @Query(ApiUtil.KEY_SEED) seed: String
    ): Call<BaseApi>
}