package com.example.m1w3d2registrationforminmvvmarchitecture.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.m1w3d2registrationforminmvvmarchitecture.Model.Repository
import com.example.m1w3d2registrationforminmvvmarchitecture.Model.UserData

@Suppress("UNREACHABLE_CODE")
class HomeViewModel: ViewModel(){
    val userRepo: Repository = Repository()
    private val _userData = MutableLiveData<UserData>()
    val suerData : LiveData<UserData> = _userData

    private fun validUserData(userData: UserData): Boolean{
        return (allFilled(userData) && validUserEmail(userData.email)
                && matchingUserPasswords(userData.password, userData.conPassword))

    }

    private fun allFilled(user: UserData): Boolean{
        return (user.name.isNotBlank() && user.email.isNotBlank()
                && user.password.isNotBlank() && user.conPassword.isNotBlank())
    }

    private fun validUserEmail(email: String): Boolean{
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
        return (email.matches(emailRegex.toRegex()))
    }

    private fun matchingUserPasswords(password: String, conPassword: String): Boolean{
        return (password === conPassword)
    }

    fun saveUserData(userData: UserData):Boolean{
        if (validUserData(userData)) {
            //call a fun from repo
            return true
        }
        else
        {
            return false
        }
    }

}