package org.wit.tickingmad.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import org.wit.tickingmad.R
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

        binding.toolbarAdd.title = title
        setSupportActionBar(binding.toolbarAdd)

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
                for (i in app.tickingmads.indices) {
                    i("Tickingmad[$i]:${this.app.tickingmads[i]}")
                }
                //for (i in app!!.tickingmads.indices)  //incorporating null safety
                //for (i in tickingmads.indices)
                //{i("Tickingmad[$i]:${this.app!!.tickingmads[i]}")}  //incorporating null safety
                //{i("Tickingmad[$i];${this.tickingmads[i]}")}
                setResult(RESULT_OK)
                finish()
            }
            else {
                Snackbar
                    .make(it,"Please Enter a title", Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_tickingmad, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_cancel -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}