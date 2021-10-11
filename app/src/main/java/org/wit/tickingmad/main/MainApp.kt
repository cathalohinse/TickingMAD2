package org.wit.tickingmad.main

import android.app.Application
import org.wit.tickingmad.models.TickingmadModel
import timber.log.Timber
import timber.log.Timber.i

class MainApp : Application() {

    val tickingmads = ArrayList<TickingmadModel>()

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        i("Tickingmad started")
    }
}