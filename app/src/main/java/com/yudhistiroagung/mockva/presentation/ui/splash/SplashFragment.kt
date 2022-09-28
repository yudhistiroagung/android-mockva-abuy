package com.yudhistiroagung.mockva.presentation.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.yudhistiroagung.mockva.R
import com.yudhistiroagung.mockva.presentation.common.extension.navigateFadeAnimOptions
import com.yudhistiroagung.mockva.presentation.common.extension.navigateSlideHorizontal
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_splash, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            delay(3000L)
            navigateToLoginPage()
        }
    }

    private fun navigateToLoginPage() {
        findNavController().navigateFadeAnimOptions(
            SplashFragmentDirections.actionSplashToLoginFragment(),
            R.id.app_nav,
        )
    }

}