package com.damla.tecktileproject.fragments

import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.damla.tecktileproject.R
import com.damla.tecktileproject.databinding.FragmentLogInBinding
import com.damla.tecktileproject.viewModel.ApiViewModel


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
        val SDK_INT = Build.VERSION.SDK_INT
        if (SDK_INT > 8) {
            val policy = ThreadPolicy.Builder()
                .permitAll().build()
            StrictMode.setThreadPolicy(policy)
            binding.CreateAcountButton.setOnClickListener {
                findNavController().navigate(R.id.action_logIn2_to_logIn)
            }

            binding.LogInButton.setOnClickListener {
                val eMailLogIn : String = binding.eitTextEmailLogIn.text.toString()
                val passwordLogIn : String = binding.editTextPasswordLogIn.text.toString()


                mLogInViewModel.putLogIn(eMailLogIn,passwordLogIn)
                mLogInViewModel.myResponseLogIn.observe(viewLifecycleOwner, Observer {
                        response ->

                    if (response.equals("OK")){
                        Toast.makeText(context,"Welcome",Toast.LENGTH_LONG).show()
                        if(findNavController().currentDestination?.id == R.id.logIn2){
                            val action = LogInDirections.actionLogIn2ToMainFragment()
                            findNavController().navigate(action)
                        }
                    }
                    if(response.equals("Unauthorized")){
                        Toast.makeText(context,"Your Email or/and Password is not authorized",Toast.LENGTH_LONG).show()

                    }




                })


            }





        }

        return binding.root
    }


}