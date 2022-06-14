package com.genesis.presenter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.genesis.extensions.loadingImage
import com.genesis.meals.R
import com.genesis.meals.databinding.FragmentCardDetailsBinding
import com.genesis.presenter.model.HearthstoneUiModel

class InfoCardFragment : Fragment() {

    private var binding: FragmentCardDetailsBinding? = null

    private var hearthstone: HearthstoneUiModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { bundle ->
            hearthstone = bundle.getParcelable("hearthstone")
        }
        setupUI()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun setupUI() {
        binding?.run {
            with(hearthstone) {
                textValueName.text = this?.name ?: getString(R.string.no_information)
                textValueEffect.text = this?.flavor ?: getString(R.string.no_information)
                textValueRarity.text = this?.rarity ?: getString(R.string.no_information)
                textValueSet.text = this?.cardSet ?: getString(R.string.no_information)
                textValueAttack.text = this?.attack ?: getString(R.string.no_information)
                textValueCost.text = this?.cost ?: getString(R.string.no_information)
                textValueDescription.text = this?.text ?: getString(R.string.no_information)
                textValueFaction.text = this?.faction ?: getString(R.string.no_information)
                textValueHealth.text = this?.health ?: getString(R.string.no_information)
                textValueType.text = this?.type ?: getString(R.string.no_information)
                imageIcon.loadingImage(this?.img)
            }
        }
    }

}