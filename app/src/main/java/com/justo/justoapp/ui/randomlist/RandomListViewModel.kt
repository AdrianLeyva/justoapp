package com.justo.justoapp.ui.randomlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.justo.justoapp.data.remote.repositories.RandomUserRepository
import com.justo.justoapp.model.PageInfo
import com.justo.justoapp.model.RandomUser
import kotlinx.coroutines.launch

/**
 * @author adrianleyvasanchez
 * @since 7/24/21
 */
class RandomListViewModel : ViewModel() {

    private val _randomUserList = MutableLiveData<List<RandomUser>>()
    val randomUserList: LiveData<List<RandomUser>>
        get() = _randomUserList

    fun fetchRandomUsers() = viewModelScope.launch {
        val mockPageInfo = PageInfo("fea8be3e64777240", 10, 1)
        RandomUserRepository.fetchAll(
            mockPageInfo,
            onSuccess = { list, pageInfo ->
                _randomUserList.value = list
            }, onError = {

            })
    }
}