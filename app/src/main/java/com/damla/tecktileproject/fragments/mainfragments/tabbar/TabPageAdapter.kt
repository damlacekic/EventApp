package com.damla.tecktileproject.fragments.mainfragments.tabbar

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.damla.tecktileproject.fragments.mainfragments.Explore
import com.damla.tecktileproject.fragments.mainfragments.ForYou
import com.damla.tecktileproject.fragments.mainfragments.Profile
import com.damla.tecktileproject.fragments.mainfragments.Wallet

class TabPageAdapter(fragmentManager : FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager,lifecycle) {

    private var fragment = Fragment()
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> fragment = Explore()
            1 -> fragment = ForYou()
            2 -> fragment = Wallet()
            3 -> fragment = Profile()

        }
        return fragment
    }

}