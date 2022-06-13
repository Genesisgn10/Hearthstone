package com.genesis.presenter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.genesis.extensions.showLoading
import com.genesis.meals.databinding.FragmentHomeMealBinding
import com.genesis.presenter.adapter.ClassCardsAdapter
import com.genesis.presenter.viewmodel.ClassCardViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ClassCardFragment : Fragment() {

    private val viewModel: ClassCardViewModel by sharedViewModel()

    private var binding: FragmentHomeMealBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeMealBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getInfo.observe(viewLifecycleOwner, Observer { list ->
            populateHearthstone(list)
        })

        viewModel.loading.observe(viewLifecycleOwner, Observer { isLoadind ->
            activity?.showLoading(isLoadind)
        })

        //viewModel.get()
        viewModel.getInfo()
    }

    private fun populateHearthstone(hearAdapter: List<String>) {
        val layoutManager = GridLayoutManager(context, 2)
        binding?.rvMeals?.layoutManager = layoutManager
        binding?.rvMeals?.adapter = ClassCardsAdapter(hearAdapter)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}