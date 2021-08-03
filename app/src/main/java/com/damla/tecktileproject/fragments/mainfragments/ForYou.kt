package com.damla.tecktileproject.fragments.mainfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.damla.tecktileproject.databinding.FragmentForYouBinding
import com.damla.tecktileproject.recyclerView.RecyclerViewAdapter

class ForYou : Fragment() {


    private lateinit var binding : FragmentForYouBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentForYouBinding.inflate(inflater,container,false)
        val adapterRecyclerView = RecyclerViewAdapter()
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapterRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)


        return binding.root
    }

}