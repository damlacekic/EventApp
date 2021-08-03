package com.damla.tecktileproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.damla.tecktileproject.R
import com.damla.tecktileproject.databinding.FragmentMainBinding
import com.damla.tecktileproject.databinding.FragmentSignUpBinding
import com.damla.tecktileproject.fragments.mainfragments.tabbar.TabPageAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {
    private lateinit var binding : FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater,container,false)
        val adapter = TabPageAdapter(activity?.supportFragmentManager!!,lifecycle)
        val tabLayout : TabLayout= binding.tabLayout
        val viewPager : ViewPager2 = binding.viewPager
        viewPager.adapter = adapter
        viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback()
        {
            override fun onPageSelected(position: Int) {
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab) {
                    viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }

        })
/*
        TabLayoutMediator(tabLayout,viewPager){tab,position ->
            viewPager.setCurrentItem(position)
            when(position){
                0-> {tab.text = "Explore"
                tab.icon = R.drawable.ic_baseline_celebration_24.toDrawable()}
                1-> tab.text = "For You"
                2 -> tab.text = "Wallet"
                3 -> tab.text = "Profile"
            }

        }.attach()
*/




        return binding.root
    }

    private fun setUpTabBar(){

    }

}