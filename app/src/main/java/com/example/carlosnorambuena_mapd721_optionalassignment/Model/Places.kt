package com.example.carlosnorambuena_mapd721_optionalassignment.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Places(
    var title: String,
    var image: Int
) : Parcelable