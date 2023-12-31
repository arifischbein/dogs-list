package com.example.dogslist

sealed class BaseViewState{
    data object Ready: BaseViewState()
    data object Loading: BaseViewState()
    data class Failure(val exception: Exception): BaseViewState()
}
