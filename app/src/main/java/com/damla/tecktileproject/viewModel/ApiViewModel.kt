package com.damla.tecktileproject.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.damla.tecktileproject.api.apiRepository
import com.damla.tecktileproject.api.model.user
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiViewModel(application : Application):AndroidViewModel(application) {
    var myResponse : MutableLiveData<String> = MutableLiveData()
    var myResponseLogIn : MutableLiveData<String> = MutableLiveData()

    private  val repository by lazy {apiRepository()}

    fun postSignUp(email : String, password : String, fullName: String, username : String){
        viewModelScope.launch {

            val response = repository.postSignUp(email,password,fullName, username).execute()
            println(response.message())
            println(response.body())
            if(response.code()==200){
                myResponse.value = response.body()
            }
            if(response.code() == 400){
                myResponse.value = response.message()
            }
            if(response.code() == 409){
                myResponse.value = response.message()
            }
        }
    }

    fun putLogIn(email: String, password: String){
        viewModelScope.launch {
            val response= repository.putLogIn(email,password).execute()
            if(response.code()==200){
                myResponseLogIn.value = response.body()
            }
            if(response.code() == 401){
                myResponseLogIn.value = response.message()
            }

        }
    }



}