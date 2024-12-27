package com.rezalaki.foody.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rezalaki.foody.R
import com.rezalaki.foody.databinding.FragmentHomeBinding
import com.rezalaki.foody.ui.base.BaseFragment
import com.rezalaki.foody.util.Constants
import com.rezalaki.foody.util.gone
import com.rezalaki.foody.util.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.uiState.observe(viewLifecycleOwner) { ui ->
            when (ui) {
                is HomeUiState.LoadFailed -> {
                    showErrorMessage(ui.errorMessage)
                    binding.btnRetry.visible()
                    binding.pbLoading.gone()
                }

                HomeUiState.Loading -> {
                    binding.btnRetry.gone()
                    binding.pbLoading.visible()
                }

                HomeUiState.NoConnection -> {
                    showNetworkError()
                    binding.btnRetry.visible()
                    binding.pbLoading.gone()
                }

                is HomeUiState.LoadSuccess -> {
                    binding.btnRetry.gone()
                    binding.pbLoading.gone()
                    binding.rvFoods.apply {
                        layoutManager = LinearLayoutManager(requireContext())
                        adapter = HomeRvAdapter(ui.data.results) { clickedFoodId ->
                            findNavController().navigate(
                                R.id.action_homeFragment_to_detailsFragment3,
                                bundleOf(
                                    Pair(Constants.ID, clickedFoodId)
                                )
                            )
                        }
                    }
                }
            }
        }

        binding.btnRetry.setOnClickListener {
            viewModel.loadFoods()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}