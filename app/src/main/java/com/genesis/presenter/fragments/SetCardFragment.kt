package com.genesis.presenter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.genesis.extensions.showLoading
import com.genesis.meals.databinding.FragmentHomeHearthstoneBinding
import com.genesis.presenter.adapter.ClassCardsAdapter
import com.genesis.presenter.viewmodel.SetCardViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SetCardFragment : Fragment() {

    private val viewModel: SetCardViewModel by sharedViewModel()

    private var binding: FragmentHomeHearthstoneBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeHearthstoneBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.infoLiveData.observe(viewLifecycleOwner, Observer { list ->
            populateHearthstone(list)
        })

        viewModel.loadingLiveDate.observe(viewLifecycleOwner, Observer { isLoading ->
            activity?.showLoading(isLoading)
        })

        viewModel.getInfo()
    }

    private fun populateHearthstone(hearAdapter: List<String>) {
        //val layoutManager = GridLayoutManager(context, 2)
        //binding?.rvMeals?.layoutManager = layoutManager
        binding?.rvMeals?.adapter = ClassCardsAdapter(hearAdapter)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}