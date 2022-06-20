package com.genesis.presenter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.genesis.extensions.setVisible
import com.genesis.extensions.showLoading
import com.genesis.hearthstone.databinding.FragmentAllCardsBinding
import com.genesis.presenter.adapter.HearthstoneAdapter
import com.genesis.presenter.model.HearthstoneUiModel
import com.genesis.presenter.viewmodel.AllCardsViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class AllCardsFragment : Fragment() {

    private val viewModel: AllCardsViewModel by sharedViewModel()
    private var binding: FragmentAllCardsBinding? = null
    private var setCard: String? = null

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
            setCard = bundle.getString(CHAVE)
        }
        setupUI()
    }

    private fun setupUI() {
        viewModel.cardsLiveDate.observe(viewLifecycleOwner, Observer { list ->
            binding?.text?.setVisible(list.isEmpty())
            populateAllCards(list)
        })

        viewModel.loading.observe(viewLifecycleOwner, Observer { isLoading ->
            activity?.showLoading(isLoading)
        })

        setCard?.let { viewModel.getAllCards(classe = it) }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun populateAllCards(hearAdapter: List<HearthstoneUiModel>) {
        binding?.rvHearthstone?.adapter = HearthstoneAdapter(hearAdapter)
    }

    companion object {
        val CHAVE = "set"
    }

}