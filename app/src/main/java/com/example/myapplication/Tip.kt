package com.example.myapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Tip(val tip: Double, val totalAmount: Double) : Parcelable
