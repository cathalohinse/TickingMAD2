package org.wit.tickingmad.main

import android.app.Application
import org.wit.tickingmad.models.TickingmadMemStore
import org.wit.tickingmad.models.TickingmadStore
import org.wit.tickingmad.models.TickingmadJSONStore
//import org.wit.tickingmad.models.TickingmadModel
import timber.log.Timber
import timber.log.Timber.i

class MainApp : Application() {

    //val tickingmads = TickingmadMemStore()
    lateinit var tickingmads: TickingmadStore

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        tickingmads = TickingmadJSONStore(applicationContext)
        i("Tickingmad started")
    }
}