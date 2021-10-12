package org.wit.tickingmad.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TickingmadModel(var id: Long = 0,
                           var title: String = "",
                           var description: String = "") : Parcelable