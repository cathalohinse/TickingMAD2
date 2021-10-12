package org.wit.tickingmad.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TickingmadModel(var title: String = "", var description: String = "") : Parcelable