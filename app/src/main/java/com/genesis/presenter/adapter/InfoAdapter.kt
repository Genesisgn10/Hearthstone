package com.genesis.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.genesis.meals.R
import com.genesis.meals.databinding.ItemInfoBinding

class InfoAdapter(
    private val sets: List<String>
) : RecyclerView.Adapter<InfoAdapter.SetsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SetsViewHolder {
        val view = ItemInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SetsViewHolder(view)
    }

    override fun onBindViewHolder(holder: SetsViewHolder, position: Int) {
        val sets = sets[position]
        with(holder) {
            binding.textTitle.text = sets.toString()
            //binding.textDescription.text = hearthstone.description
            binding.imageIcon.setBackgroundResource(R.drawable.icon)
            val bundle = bundleOf("classe" to sets.toString())
            binding.card.setOnClickListener { view ->
                view.findNavController().navigate(R.id.callCards, bundle)
            }
        }

    }

    override fun getItemCount() = sets.size

    inner class SetsViewHolder(val binding: ItemInfoBinding) :
        RecyclerView.ViewHolder(binding.root)
}