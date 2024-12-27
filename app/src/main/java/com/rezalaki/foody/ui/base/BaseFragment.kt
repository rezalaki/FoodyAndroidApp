package com.rezalaki.foody.ui.base

import androidx.fragment.app.Fragment
import com.rezalaki.foody.R
import dagger.hilt.android.AndroidEntryPoint
import org.aviran.cookiebar2.CookieBar
import javax.inject.Inject

open class BaseFragment : Fragment() {

    fun showNetworkError() {
        showErrorMessage("Your network is not available!")
    }

    fun showErrorMessage(message: String) {
        CookieBar.build(requireActivity())
            .setMessage(message)
            .setBackgroundColor(R.color.red)
            .setMessageColor(R.color.white)
            .setDuration(3_000)
            .show()
    }

}