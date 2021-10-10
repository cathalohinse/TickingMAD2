package org.wit.tickingmad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import timber.log.Timber
import timber.log.Timber.i
import org.wit.tickingmad.databinding.ActivityTickingmadBinding

class TickingmadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTickingmadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTickingmadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_tickingmad)
        Timber.plant(Timber.DebugTree())
        i("Tickingmad Activity started..")
        binding.btnAdd.setOnClickListener() {
            val tickTitle = binding.tickTitle.text.toString()
            if (tickTitle.isNotEmpty()) {
                i("add Button Pressed: $tickTitle")
            }
            else {
                Snackbar
                    .make(it,"Please Enter a title", Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }
}