package com.bachan.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bachan.base.mvvm.vm.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainViewModel : BaseViewModel<MainRepository>() {
    val msg: MutableLiveData<String> = MutableLiveData()

    override fun initRepository(): MainRepository = MainRepository()
    fun getString() {
        viewModelScope.launch(Dispatchers.IO) {
            mRepository.getString().collectLatest {
                msg.postValue(it)
            }
        }
    }
}