package org.wit.tickingmad.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso
import org.wit.tickingmad.databinding.CardTickingmadBinding
import org.wit.tickingmad.models.TickingmadModel

interface TickingmadListener {
    fun onTickingmadClick(tickingmad: TickingmadModel)
}

class TickingmadAdapter constructor(private var tickingmads: List<TickingmadModel>, private val listener: TickingmadListener) :
//class TickingmadAdapter constructor(private var tickingmads: List<TickingmadModel>) :
    RecyclerView.Adapter<TickingmadAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = CardTickingmadBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val tickingmad = tickingmads[holder.adapterPosition]
        holder.bind(tickingmad, listener)
        //holder.bind(tickingmad)
    }

    override fun getItemCount(): Int = tickingmads.size

    class MainHolder(private val binding : CardTickingmadBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(tickingmad: TickingmadModel, listener: TickingmadListener) {
        //fun bind(tickingmad: TickingmadModel) {
            binding.tickTitle.text = tickingmad.title
            binding.tickDescription.text = tickingmad.description
            binding.tickCounty.text = tickingmad.county

            if(tickingmad.favourite) {
                //binding.tickFavourite.text = "Favourite"
                //binding.tickFavourite.visibility = View.VISIBLE
                binding.itemFavourite.visibility = View.VISIBLE
            }
            else {
                //binding.tickFavourite.text = ""
                //binding.tickFavourite.visibility = View.GONE
                binding.itemFavourite.visibility = View.GONE
            }

            //binding.tickEmail.text = auth.currentUser?.email.toString()
            binding.tickEmail.text = tickingmad.email
            Picasso.get().load(tickingmad.image).resize(200,200).into(binding.tickImage)
            binding.root.setOnClickListener { listener.onTickingmadClick(tickingmad)}
        }
    }
}