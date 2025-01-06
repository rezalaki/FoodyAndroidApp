package com.rezalaki.foody.ui.details

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.rezalaki.foody.R
import com.rezalaki.foody.databinding.FragmentDetailsBinding
import com.rezalaki.foody.ui.base.BaseFragment
import com.rezalaki.foody.util.Constants
import com.rezalaki.foody.util.gone
import com.rezalaki.foody.util.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : BaseFragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DetailsViewModel by viewModels()
    private val args: DetailsFragmentArgs by navArgs()

    private val foodId by lazy {
        args.foodId
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadDetails(foodId)
        viewModel.uiState.observe(viewLifecycleOwner) { ui ->
            when (ui) {
                is DetailsUiState.LoadFailed -> {
                    binding.btnRetry.visible()
                    binding.pbLoading.gone()
                    showErrorMessage(ui.errorMessage)
                }

                DetailsUiState.Loading -> {
                    binding.btnRetry.gone()
                    binding.pbLoading.visible()
                }

                DetailsUiState.NoConnection -> {
                    binding.btnRetry.visible()
                    binding.pbLoading.gone()
                    showNetworkError()
                }

                is DetailsUiState.LoadSuccess -> {
                    binding.btnRetry.gone()
                    binding.pbLoading.gone()
                    ui.data.also { food ->
                        binding.tvToolbarTitle.text = food.title?.take(15)
                        binding.ivBanner.load(food.image){
                            crossfade(true)
                            crossfade(1_000)
                            error(R.drawable.ic_error)
                        }
                        binding.tvLikes.text = food.aggregateLikes?.toInt().toString()
                        binding.tvHealth.text = food.healthScore?.toInt().toString()
                        binding.tvPrice.text = food.pricePerServing?.toInt().toString()

                        binding.tvSummary.text = Html.fromHtml(Html.fromHtml(food.summary).toString()).toString()
                        binding.tvCredits.text = food.creditsText
                    }
                    binding.cardTop.visible()
                    binding.cardSummary.visible()
                }
            }
        }

        binding.ivToolbarBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnRetry.setOnClickListener {
            viewModel.loadDetails(foodId)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}