package org.wit.tickingmad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import timber.log.Timber
import timber.log.Timber.i

class TickingmadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tickingmad)
        Timber.plant(Timber.DebugTree())
        i("Tickingmad Activity started..")
    }
}