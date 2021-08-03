package com.damla.tecktileproject.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.damla.tecktileproject.R
import com.damla.tecktileproject.fragments.MainFragmentDirections
import kotlinx.android.synthetic.main.recycler_view_row.view.*

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_row,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.rowImage.setImageResource(R.drawable.fest)
        holder.itemView.grandOpening.text = "Grand Opening"
        holder.itemView.textRate.text = "4.8"
        holder.itemView.locationTextView.text = "Main Stage - Ushuaia"
        holder.itemView.date1.text = "14"
        holder.itemView.date2.text = "FEB"
        val event = Event(R.drawable.fest,holder.itemView.date1.text.toString(),holder.itemView.grandOpening.text.toString(),holder.itemView.date2.text.toString(),holder.itemView.locationTextView.text.toString(),
            holder.itemView.grandOpening.text.toString())

        holder.itemView.rootView.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToDetailOverview(event)
            holder.itemView.findNavController().navigate(action)
        }

     /*   val event = Event(holder.itemView.rowImage.setImageResource(R.drawable.fest),holder.itemView.date1.text.toString(),holder.itemView.date2.text.toString(),holder.itemView.locationTextView.text.toString(),
            holder.itemView.grandOpening.text.toString()
        )
        holder.itemView.rootView.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToDetailOverview(event)
            holder.itemView.findNavController().navigate(action)

        }*/





    }

    override fun getItemCount(): Int {
       return 5
    }
}