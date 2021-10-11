package org.wit.tickingmad.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import org.wit.tickingmad.databinding.ActivityTickingmadBinding
import org.wit.tickingmad.main.MainApp
import org.wit.tickingmad.models.TickingmadModel
import timber.log.Timber
import timber.log.Timber.i

class TickingmadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTickingmadBinding
    var tickingmad = TickingmadModel()
    //val tickingmads = ArrayList<TickingmadModel>()
    //var app : MainApp? = null  //incorporating null safety
    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTickingmadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Timber.plant(Timber.DebugTree())
        app = application as MainApp
        i("Tickingmad Activity started...")

        binding.btnAdd.setOnClickListener() {
            tickingmad.title = binding.tickTitle.text.toString()
            tickingmad.description = binding.tickDescription.text.toString()
            if (tickingmad.title.isNotEmpty()) {
                app.tickingmads.add(tickingmad.copy())
                //app!!.tickingmads.add(tickingmad.copy()) //incorporating null safety
                //tickingmads.add(tickingmad.copy())
                //i("add Button Pressed: $tickingmad.title")
                i("add Button Pressed: ${tickingmad}")
                for (i in app.tickingmads.indices)
                //for (i in app!!.tickingmads.indices)  //incorporating null safety
                //for (i in tickingmads.indices)
                {i("Tickingmad[$i]:${this.app.tickingmads[i]}")}
                //{i("Tickingmad[$i]:${this.app!!.tickingmads[i]}")}  //incorporating null safety
                //{i("Tickingmad[$i];${this.tickingmads[i]}")}
            }
            else {
                Snackbar
                    .make(it,"Please Enter a title", Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }
}