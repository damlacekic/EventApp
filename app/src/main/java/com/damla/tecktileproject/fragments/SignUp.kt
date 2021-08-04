package com.damla.tecktileproject.fragments

import android.os.Bundle
import android.text.Editable
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.damla.tecktileproject.R
import com.damla.tecktileproject.api.model.user

import com.damla.tecktileproject.databinding.FragmentSignUpBinding
import com.damla.tecktileproject.viewModel.ApiViewModel
import kotlinx.android.synthetic.main.fragment_sign_up.view.*

class SignUp : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    private lateinit var  mSignUpViewModel : ApiViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSignUpBinding.inflate(inflater,container,false)
        mSignUpViewModel = ViewModelProvider(this).get(ApiViewModel::class.java)
        binding.signInButton.setOnClickListener {
            val eMailSignUp : String = binding.eitTextEmail.text.toString()
            val passwordSignUp: String = binding.editTextPassword.text.toString()
            val fullNameSignUp : String = binding.editTextFullName.text.toString()
            val userNameSignUp : String = binding.editTextUserName.text.toString()
            mSignUpViewModel.postSignUp(eMailSignUp,passwordSignUp,fullNameSignUp,userNameSignUp)
            mSignUpViewModel.myResponse.observe(viewLifecycleOwner, Observer { response ->
                if(response.isSuccessful){

                    if(response.code().toString().equals("200")){
                        if(findNavController().currentDestination?.id == R.id.logIn){
                        Toast.makeText(context,"Sign Up is Completed",Toast.LENGTH_LONG).show()
                        findNavController().navigate(R.id.action_logIn_to_mainFragment)
                    }}
                }else {
                    if(response.code().toString().equals("400")){
                        Toast.makeText(context,"Enter all requested data",Toast.LENGTH_LONG).show()
                    }
                    if (response.code().toString().equals("409")){
                        Toast.makeText(context,"There is another user who has the same datas",Toast.LENGTH_LONG).show()
                    }
                    println("Main"+ response.code().toString())
                    println("Main"+ response.message())
                }
            })

        }

        return binding.root
    }


}