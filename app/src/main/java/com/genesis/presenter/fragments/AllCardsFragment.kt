package com.genesis.presenter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.genesis.meals.databinding.FragmentAllCardsBinding
import com.genesis.presenter.viewmodel.AllCardsViewModel
import com.genesis.presenter.adapter.HearAdapter
import com.genesis.presenter.model.HearthstoneUiModel
import com.genesis.extensions.showLoading
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class AllCardsFragment : Fragment() {

    private val viewModel: AllCardsViewModel by sharedViewModel()

    private var binding: FragmentAllCardsBinding? = null

    private var classe: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllCardsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.showLoading(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { bundle ->
            classe = bundle.getString("classe")
        }

        viewModel.getCards.observe(viewLifecycleOwner, Observer { list ->
            populateAllCards(list)
        })

        viewModel.loading.observe(viewLifecycleOwner, Observer { isLoading ->
            activity?.showLoading(isLoading)
        })

        classe?.let { viewModel.getAllCards(classe = it) }

    }

    private fun populateAllCards(hearAdapter: List<HearthstoneUiModel>) {
        binding?.rvMeals?.adapter = HearAdapter(hearAdapter)
    }


}