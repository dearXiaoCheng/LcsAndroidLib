package com.lcs.arch.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @ClassName: BaseViewModel
 * @Author: 刘春爽
 * @Date: 21-3-6 下午10:13
 * @Description: BaseViewModel
 */
open class BaseViewModel : ViewModel() {

    enum class UiState {
        LOADING,
        FINISH,
        ERROR,
        DEAD,
    }

    protected val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState>
        get() = _uiState


    override fun onCleared() {
        super.onCleared()

    }
}