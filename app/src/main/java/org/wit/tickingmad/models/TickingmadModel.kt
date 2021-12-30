package org.wit.tickingmad.models

import android.net.Uri
import android.os.Parcelable
import com.google.firebase.database.Exclude
import kotlinx.parcelize.Parcelize

@Parcelize
data class TickingmadModel(var uid: String? = "",
                           var id: Long = 0,
                           var _id: String = "N/A",
                           var email: String = "joe@bloggs.com",
                           var title: String = "",
                          var description: String = "",
                           var county: String = "",
                           var favourite: Boolean = true,
                          var image: Uri = Uri.EMPTY,
                          var lat : Double = 0.0,
                          var lng: Double = 0.0,
                          var zoom: Float = 0f) : Parcelable

@Parcelize
data class Location(var lat: Double = 0.0,
                    var lng: Double = 0.0,
                    var zoom: Float = 0f) : Parcelable

/*{
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "uid" to uid,
            "id" to id,
            "_id" to _id,
            "email" to email,
            "title" to title,
            "description" to description,
            "county" to county,
            "favourite" to favourite,
            "image" to image,
            "lat" to lat,
            "lng" to lng,
            "zoom" to zoom
        )
    }
}*/