package org.wit.tickingmad.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.wit.tickingmad.databinding.CardTickingmadBinding
import org.wit.tickingmad.models.TickingmadModel

class TickingmadAdapter constructor(private var tickingmads: List<TickingmadModel>) :
    RecyclerView.Adapter<TickingmadAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = CardTickingmadBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val tickingmad = tickingmads[holder.adapterPosition]
        holder.bind(tickingmad)
    }

    override fun getItemCount(): Int = tickingmads.size

    class MainHolder(private val binding : CardTickingmadBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(tickingmad: TickingmadModel) {
            binding.tickTitle.text = tickingmad.title
            binding.tickDescription.text = tickingmad.description
        }
    }
}