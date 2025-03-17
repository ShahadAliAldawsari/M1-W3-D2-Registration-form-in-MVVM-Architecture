package com.example.m1w3d2registrationforminmvvmarchitecture.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.m1w3d2registrationforminmvvmarchitecture.Model.Repsitory
import com.example.m1w3d2registrationforminmvvmarchitecture.Model.UserData
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel(){
    val userRepo: Repsitory = Repsitory()
    private val _userData = MutableLiveData<UserData>()
    val suerData : LiveData<UserData> = _userData

    fun saveUserData(){
        TODO()
    }

    fun getUserData(){
        viewModelScope.launch{
            val userResult = userRepo.fetchUserData()
        }
    }
}