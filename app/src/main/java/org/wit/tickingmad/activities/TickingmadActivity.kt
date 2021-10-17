package org.wit.tickingmad.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import org.wit.tickingmad.R
import org.wit.tickingmad.databinding.ActivityTickingmadBinding
import org.wit.tickingmad.helpers.showImagePicker
import org.wit.tickingmad.main.MainApp
import org.wit.tickingmad.models.TickingmadModel
import timber.log.Timber
import timber.log.Timber.i

class TickingmadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTickingmadBinding
    private lateinit var imageIntentLauncher : ActivityResultLauncher<Intent>
    var tickingmad = TickingmadModel()
    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        registerImagePickerCallback()
        super.onCreate(savedInstanceState)
        var edit = false
        binding = ActivityTickingmadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbarAdd.title = title
        setSupportActionBar(binding.toolbarAdd)
        app = application as MainApp

        if (intent.hasExtra("tick_edit")) {
            edit = true
            tickingmad = intent.extras?.getParcelable("tick_edit")!!
            binding.tickTitle.setText(tickingmad.title)
            binding.tickDescription.setText(tickingmad.description)
            binding.btnAdd.setText(R.string.save_tick)
            Picasso.get()
                .load(tickingmad.image)
                .into(binding.tickImage)
            if (tickingmad.image != Uri.EMPTY) {
                binding.chooseImage.setText(R.string.changeImage)
            }
        }

        binding.btnAdd.setOnClickListener() {
            tickingmad.title = binding.tickTitle.text.toString()
            tickingmad.description = binding.tickDescription.text.toString()
            if (tickingmad.title.isEmpty()) {
                Snackbar.make(it,R.string.enter_tickTitle, Snackbar.LENGTH_LONG)
                    .show()
            } else {
                if (edit) {
                    app.tickingmads.update(tickingmad.copy())
                } else {
                    app.tickingmads.create(tickingmad.copy())
                }
            }
            setResult(RESULT_OK)
            finish()
        }

        /*binding.chooseImage.setOnClickListener {
            i("Select image")
        }*/

        binding.chooseImage.setOnClickListener {
            showImagePicker(imageIntentLauncher)
        }

        binding.tickLocation.setOnClickListener {
            i ("Set Location Pressed")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_tickingmad, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_cancel -> { finish() }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun registerImagePickerCallback() {
        imageIntentLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            { result ->
                when(result.resultCode){
                    RESULT_OK -> {
                        if (result.data != null) {
                            i("Got Result ${result.data!!.data}")
                            tickingmad.image = result.data!!.data!!
                            Picasso.get()
                                .load(tickingmad.image)
                                .into(binding.tickImage)
                            binding.chooseImage.setText(R.string.changeImage)
                        } // end of if
                    }
                    RESULT_CANCELED -> { } else -> { }
                }
            }
    }
}