package com.genesis.presenter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.genesis.extensions.loadingImage
import com.genesis.meals.databinding.FragmentCardDetailsBinding
import com.genesis.presenter.model.HearthstoneUiModel

class InfoCardFragment : Fragment() {

    private lateinit var binding: FragmentCardDetailsBinding

    private var hearthstone: HearthstoneUiModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCardDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { bundle ->
            hearthstone = bundle.getParcelable("hearthstone")
        }
        setupUI()
    }

    private fun setupUI() {
        binding.run {
            with(hearthstone) {
                textValueName.text = this?.name ?: "Não há informação"
                textValueEffect.text = this?.flavor ?: "Não há informação"
                textValueRarity.text = this?.rarity ?: "Não há informação"
                textValueSet.text = this?.cardSet ?: "Não há informação"
                imageIcon.loadingImage(this?.img)
            }
        }
    }


}