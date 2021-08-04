package com.damla.tecktileproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.damla.tecktileproject.R
import com.damla.tecktileproject.api.SimpleApi
import com.damla.tecktileproject.databinding.FragmentLogInBinding
import com.damla.tecktileproject.databinding.FragmentSignUpBinding
import com.damla.tecktileproject.viewModel.ApiViewModel
import io.reactivex.disposables.CompositeDisposable

class LogIn : Fragment() {

    private lateinit var binding: FragmentLogInBinding
    private lateinit var  mLogInViewModel : ApiViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mLogInViewModel = ViewModelProvider(this).get(ApiViewModel::class.java)
        val binding = FragmentLogInBinding.inflate(inflater,container,false)
        binding.CreateAcountButton.setOnClickListener {
            findNavController().navigate(R.id.action_logIn2_to_logIn)
        }

        binding.LogInButton.setOnClickListener {
            val eMailLogIn : String = binding.eitTextEmailLogIn.text.toString()
            val passwordLogIn : String = binding.editTextPasswordLogIn.text.toString()
            println(eMailLogIn)


            mLogInViewModel.putLogIn(eMailLogIn,passwordLogIn)
            mLogInViewModel.myResponseLogIn.observe(viewLifecycleOwner, Observer {
                response ->


                    if(response.isSuccessful){
                        if(response.code().toString().equals("200")){
                            Toast.makeText(context,"Welcome",Toast.LENGTH_LONG).show()
                            if(findNavController().currentDestination?.id == R.id.logIn2){
                                val action = LogInDirections.actionLogIn2ToMainFragment()
                                findNavController().navigate(action)
                            }
                        }

                    }


                    println("Main" + response.body().toString())
                    println("Main"+ response.code().toString())
                    println("Main"+ response.message())



            })






        }

        return binding.root
    }


}