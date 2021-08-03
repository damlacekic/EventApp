package com.damla.tecktileproject.recyclerView

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Event(
    val vektor: Int,
    val eventType : String,
    val date1: String,
    val date2: String,
    val location: String, val rate: String
):Parcelable


