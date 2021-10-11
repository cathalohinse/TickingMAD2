package org.wit.tickingmad.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.wit.tickingmad.R
import org.wit.tickingmad.databinding.ActivityTickingmadListBinding
import org.wit.tickingmad.databinding.CardPlacemarkBinding
//import org.wit.tickingmad.databinding.CardTickingmadBinding
import org.wit.tickingmad.main.MainApp
import org.wit.tickingmad.models.TickingmadModel

class TickingmadListActivity : AppCompatActivity() {

    lateinit var app: MainApp
    private lateinit var binding: ActivityTickingmadListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTickingmadListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.title = title
        setSupportActionBar(binding.toolbar)

        app = application as MainApp

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = TickingmadAdapter(app.tickingmads)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_add -> {
                val launcherIntent = Intent(this, TickingmadActivity::class.java)
                startActivityForResult(launcherIntent,0)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}

class TickingmadAdapter constructor(private var tickingmads: List<TickingmadModel>) :
    RecyclerView.Adapter<TickingmadAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        //val binding = CardTickingmadBinding
        val binding = CardPlacemarkBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val tickingmad = tickingmads[holder.adapterPosition]
        holder.bind(tickingmad)
    }

    override fun getItemCount(): Int = tickingmads.size

    //class MainHolder(private val binding : CardTickingmadBinding) :
    class MainHolder(private val binding : CardPlacemarkBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(tickingmad: TickingmadModel) {
            binding.tickTitle.text = tickingmad.title
            binding.tickDescription.text = tickingmad.description
        }
    }
}