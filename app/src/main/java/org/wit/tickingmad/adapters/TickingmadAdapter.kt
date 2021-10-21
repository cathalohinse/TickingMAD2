package org.wit.tickingmad.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.wit.tickingmad.databinding.CardTickingmadBinding
import org.wit.tickingmad.models.TickingmadModel

interface TickingmadListener {
    fun onTickingmadClick(tickingmad: TickingmadModel)
}

class TickingmadAdapter constructor(private var tickingmads: List<TickingmadModel>, private val listener: TickingmadListener) :
    RecyclerView.Adapter<TickingmadAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = CardTickingmadBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val tickingmad = tickingmads[holder.adapterPosition]
        holder.bind(tickingmad, listener)
    }

    override fun getItemCount(): Int = tickingmads.size

    class MainHolder(private val binding : CardTickingmadBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(tickingmad: TickingmadModel, listener: TickingmadListener) {
            binding.tickTitle.text = tickingmad.title
            binding.tickDescription.text = tickingmad.description
            Picasso.get().load(tickingmad.image).resize(200,200).into(binding.imageIcon)
            binding.root.setOnClickListener { listener.onTickingmadClick(tickingmad)}
        }
    }
}