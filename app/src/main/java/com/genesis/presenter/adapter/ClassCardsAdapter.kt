package com.genesis.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.genesis.meals.R
import com.genesis.meals.databinding.ItemInfoBinding

class ClassCardsAdapter(
    private val sets: List<String>
) : RecyclerView.Adapter<ClassCardsAdapter.ClassViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassViewHolder {
        val view = ItemInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClassViewHolder(view)
    }

    override fun onBindViewHolder(holder: ClassViewHolder, position: Int) {
        val sets = sets[position]
        with(holder) {
            binding.textTitle.text = sets
            //binding.textDescription.text = hearthstone.description
            binding.imageIcon.setBackgroundResource(R.drawable.ic_generic)
            val bundle = bundleOf("classe" to sets)
            binding.card.setOnClickListener { view ->
                view.findNavController().navigate(R.id.callCards, bundle)
            }
        }

    }

    override fun getItemCount() = sets.size

    inner class ClassViewHolder(val binding: ItemInfoBinding) :
        RecyclerView.ViewHolder(binding.root)
}