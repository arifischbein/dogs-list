package com.example.dogslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _viewStateLD: MutableLiveData<BaseViewState> = MutableLiveData()
    val viewStateLD: LiveData<BaseViewState> get() = _viewStateLD
    private val _dogDataLD: MutableLiveData<List<String>> = MutableLiveData()
    val dogDataLD: LiveData<List<String>> get() = _dogDataLD

    fun searchByName(query: String) {
        viewModelScope.launch {
            _viewStateLD.value = BaseViewState.Loading
            val response = RetrofitInstance.api.getDogsByBreads("$query/images")
            if (response.isSuccessful) {
                _dogDataLD.value = response.body()?.images ?: emptyList()
                _viewStateLD.value = BaseViewState.Ready
            } else {
                _viewStateLD.value =
                    BaseViewState.Failure(Exception("Ocurrió un problema para cargar la información"))
            }
        }
    }
}
