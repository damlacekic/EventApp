package com.damla.tecktileproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.navArgs
import com.damla.tecktileproject.R
import com.damla.tecktileproject.databinding.FragmentDetailOverviewBinding
import com.damla.tecktileproject.databinding.FragmentLogInBinding

class DetailOverview : Fragment() {
    private lateinit var binding : FragmentDetailOverviewBinding
    private val args by navArgs<DetailOverviewArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailOverviewBinding.inflate(inflater,container,false)
        val eventImage : ImageView = binding.imageViewDetail
        var eventType : String = binding.grandOpeningDetail.text.toString()
        var eventRate : String = binding.textRateDetail.text.toString()
        var eventLocation : String = binding.locationTextViewDetail.text.toString()
        var eventDate1 : String = binding.date1detail.text.toString()
        var eventDate2 : String = binding.date2detail.text.toString()

        eventImage.setImageResource(args.events.vektor)
        eventType = args.events.eventType
        eventRate = args.events.rate
        eventLocation = args.events.location
        eventDate1 = args.events.date1
        eventDate2 = args.events.date2




        return binding.root
    }


}