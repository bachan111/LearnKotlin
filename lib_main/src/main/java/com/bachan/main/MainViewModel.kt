package com.bachan.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bachan.base.mvvm.vm.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
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

    fun getTestString() {
        viewModelScope.launch {

            mRepository.mockRequest()
                .onStart {
                    // 获取数据之前
                    // 可以做loading图之类的
                }
                .catch {
                    // 处理异常 获取数据产生的异常
                }
                .onCompletion {
                    // 获取数据完成时
                }
                .collectLatest {
                    // 拿到想要的数据
                    Log.d("qqq", "getTestString: $it")
                }
        }
    }
}