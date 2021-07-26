package com.justo.justoapp.ui.randomlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.justo.justoapp.common.ViewState
import com.justo.justoapp.data.remote.repositories.RandomUserRepository
import com.justo.justoapp.data.remote.repositories.RandomUserRequestState
import com.justo.justoapp.model.PageInfo
import com.justo.justoapp.model.RandomUser
import kotlinx.coroutines.launch

/**
 * @author adrianleyvasanchez
 * @since 7/24/21
 */
class RandomListViewModel : ViewModel() {

    private val mockPageInfo = PageInfo("fea8be3e64777240", 10, 1)

    private val _state = MutableLiveData<ViewState>()
    val state: LiveData<ViewState>
        get() = _state

    private val _randomUserList = MutableLiveData<List<RandomUser>>()
    val randomUserList: LiveData<List<RandomUser>>
        get() = _randomUserList

    fun fetchRandomUsers() = viewModelScope.launch {
        _state.value = ViewState.LOADING
        RandomUserRepository.fetchAll(mockPageInfo, callback = {
            when(it) {
                is RandomUserRequestState.Success -> {
                    _randomUserList.value = it.results
                    _state.value = ViewState.SUCCESS
                }
                is RandomUserRequestState.Error -> {
                    _state.value = ViewState.ERROR
                }
            }
        })
    }
}