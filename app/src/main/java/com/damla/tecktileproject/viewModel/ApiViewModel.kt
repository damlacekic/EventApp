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
    var myResponse : MutableLiveData<Response<ResponseBody>> = MutableLiveData()
    var myResponseLogIn : MutableLiveData<Response<ResponseBody>> = MutableLiveData()

    private  val repository by lazy {apiRepository()}

    fun postSignUp(email : String, password : String, fullName: String, username : String){
        viewModelScope.launch {
            val response = repository.postSignUp(email,password,fullName, username)
            myResponse.value = response
        }
    }

    fun putLogIn(email: String, password: String){
        viewModelScope.launch {
            val response = repository.putLogIn(email,password)
            myResponseLogIn.value = response
        }
    }


/*fun postSignUp(post: user){
    viewModelScope.launch {
        repository.postSignUp(post).enqueue(object : Callback<user>{
            override fun onResponse(call: Call<user>, response: Response<user>) {
                //println(response.code())
                //if(response.code() == 200){
                    myResponse.value = response.body()
                    println(response.body())
                    println(response.message())
                    println("blokta başarı")
                //}

            }

            override fun onFailure(call: Call<user>, t: Throwable) {
                println("---------------------------------------")
                println(t.localizedMessage)
                println(t.message)
                println(t.cause)
                println(t.suppressed)
                println("-------------------------------------")
                println("hataaaa")
            }
        })

    }
}*/
}