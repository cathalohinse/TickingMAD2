package org.wit.tickingmad.main

import android.app.Application
import org.wit.tickingmad.models.TickingmadMemStore
import org.wit.tickingmad.models.TickingmadModel
import timber.log.Timber
import timber.log.Timber.i

class MainApp : Application() {

    val tickingmads = TickingmadMemStore()

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        i("Tickingmad started")
    }
}