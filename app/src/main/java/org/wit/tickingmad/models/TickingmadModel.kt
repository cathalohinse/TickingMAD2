package org.wit.tickingmad.models

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TickingmadModel(var id: Long = 0,
                           var _id: String = "N/A",
                           var email: String = "joe@bloggs.com",
                           var title: String = "",
                          var description: String = "",
                           var county: String = "",
                          var image: Uri = Uri.EMPTY,
                          var lat : Double = 0.0,
                          var lng: Double = 0.0,
                          var zoom: Float = 0f) : Parcelable

@Parcelize
data class Location(var lat: Double = 0.0,
                    var lng: Double = 0.0,
                    var zoom: Float = 0f) : Parcelable