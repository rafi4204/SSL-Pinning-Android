package com.example.sslpinning.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sslpinning.network.GithubApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val api = GithubApi.retrofitService
    val user = MutableStateFlow(User("", "", "", "", 0, 0, 0))

    fun getUser() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                api.getUserData("rafi4204").apply {
                    this.body()?.let { user.emit(it) }
                }
            } catch (e: Exception) {
            }
        }
    }
}
