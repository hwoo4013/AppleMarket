package com.example.applemarket

import android.os.Parcel
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable
import java.io.Serializable

@Parcelize
data class MyItem (
    val Image: Int,
    val name: String,
    val price: Int,
    val ItemTitle: String,
    val ItemDetail: String,
    val Address: String
    ) : Parcelable