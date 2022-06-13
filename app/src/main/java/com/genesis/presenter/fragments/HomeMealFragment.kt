package com.genesis.presenter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.genesis.meals.databinding.FragmentHomeMealBinding
import com.genesis.presenter.viewmodel.MealViewModel
import com.genesis.presenter.adapter.CategoriesAdapter
import com.genesis.presenter.adapter.InfoAdapter
import com.genesis.presenter.model.CategoryUiModel
import com.genesis.extensions.showLoading
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeMealFragment : Fragment() {

    private val viewModel: MealViewModel by sharedViewModel()

    private lateinit var binding: FragmentHomeMealBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeMealBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.hearthstone.observe(viewLifecycleOwner, Observer { listHearthstone ->
            //populateHearthstone(listHearthstone)
        })

        viewModel.getInfo.observe(viewLifecycleOwner, Observer { list ->
            populateHearthstone(list)
        })

        viewModel.loading.observe(viewLifecycleOwner, Observer { isLoadind ->
            activity?.showLoading(isLoadind)
        })

        //viewModel.get()
        viewModel.getInfo()
    }

    private fun populateMealsCategory(categories: List<CategoryUiModel>) {
        binding.rvMeals.adapter = CategoriesAdapter(categories)
    }

    private fun populateHearthstone(hearAdapter: List<String>) {
        val layoutManager = GridLayoutManager(context, 2)
        binding.rvMeals.layoutManager = layoutManager
        binding.rvMeals.adapter = InfoAdapter(hearAdapter)
    }

}