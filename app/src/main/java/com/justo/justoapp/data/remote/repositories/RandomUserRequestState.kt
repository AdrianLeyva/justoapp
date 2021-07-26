package com.justo.justoapp.data.remote.repositories

import com.justo.justoapp.model.PageInfo
import com.justo.justoapp.model.RandomUser

/**
 * @author adrianleyvasanchez
 * @since 7/25/21
 */
sealed class RandomUserRequestState {
    data class Success(val results: ArrayList<RandomUser>, val pageInfo: PageInfo) : RandomUserRequestState()
    data class Error(val message: String? = "") : RandomUserRequestState()
}
