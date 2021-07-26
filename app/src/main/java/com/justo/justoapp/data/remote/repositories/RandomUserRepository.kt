package com.justo.justoapp.data.remote.repositories

import com.justo.justoapp.data.remote.ApiUtil
import com.justo.justoapp.data.remote.BaseApi
import com.justo.justoapp.data.remote.api.RandomUserService
import com.justo.justoapp.model.PageInfo
import com.justo.justoapp.model.RandomUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

/**
 * @author adrianleyvasanchez
 * @since 7/24/21
 */
object RandomUserRepository {

    fun fetchAll(
        pageInfo: PageInfo,
        callback: (RandomUserRequestState) -> Unit
    ) {
        val retrofit = ApiUtil.buildRetrofit()
        val service = retrofit.create(RandomUserService::class.java)

        service.fetchAll(pageInfo.page, pageInfo.results, pageInfo.seed)
            .enqueue(object : Callback<BaseApi> {
                override fun onResponse(call: Call<BaseApi>, response: Response<BaseApi>) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            Timber.d("results: ${it.results}")
                            callback(RandomUserRequestState.Success(it.results, it.info))
                        }
                    }
                }

                override fun onFailure(call: Call<BaseApi>, t: Throwable) {
                    Timber.d("error: ${t.localizedMessage}")
                    callback(RandomUserRequestState.Error())
                }
            })
    }
}