package org.wit.tickingmad.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import org.wit.tickingmad.R
import org.wit.tickingmad.databinding.ActivityTickingmadListBinding
import org.wit.tickingmad.main.MainApp
import org.wit.tickingmad.adapters.TickingmadAdapter
import org.wit.tickingmad.adapters.TickingmadListener
import org.wit.tickingmad.models.TickingmadModel

class TickingmadListActivity : AppCompatActivity(), TickingmadListener {

    lateinit var app: MainApp
    private lateinit var binding: ActivityTickingmadListBinding
    private lateinit var refreshIntentLauncher : ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTickingmadListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.title = title
        setSupportActionBar(binding.toolbar)

        app = application as MainApp

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        //binding.recyclerView.adapter = TickingmadAdapter(app.tickingmads.findAll(), this)
        loadTickingmads()
        registerRefreshCallback()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_add -> {
                val launcherIntent = Intent(this, TickingmadActivity::class.java)
                refreshIntentLauncher.launch(launcherIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onTickingmadClick(tickingmad: TickingmadModel) {
        val launcherIntent = Intent(this, TickingmadActivity::class.java)
        launcherIntent.putExtra("tick_edit", tickingmad)
        refreshIntentLauncher.launch(launcherIntent)
    }


    private fun registerRefreshCallback() {
        refreshIntentLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            //{ binding.recyclerView.adapter?.notifyDataSetChanged() }
            {loadTickingmads()}
    }

    private fun loadTickingmads() {
        showTickingmads(app.tickingmads.findAll())
    }

    fun showTickingmads (tickingmads: List<TickingmadModel>) {
        binding.recyclerView.adapter = TickingmadAdapter(tickingmads,this)
        binding.recyclerView.adapter?.notifyDataSetChanged()
    }

}

