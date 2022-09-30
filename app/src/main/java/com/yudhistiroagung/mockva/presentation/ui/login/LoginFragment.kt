package com.yudhistiroagung.mockva.presentation.ui.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.yudhistiroagung.mockva.R
import com.yudhistiroagung.mockva.presentation.common.UIState
import com.yudhistiroagung.mockva.presentation.common.base.BaseFragment
import com.yudhistiroagung.mockva.presentation.common.extension.navigateSlideHorizontal
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_login.*

@AndroidEntryPoint
class LoginFragment : BaseFragment() {
    private val loginViewModel by viewModels<LoginViewModel>()

    override fun getResLayoutId(): Int = R.layout.fragment_login

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(loginViewModel) {
            loginResult.observe(viewLifecycleOwner, ::handleLoginResult)
        }
        btn_login.setOnClickListener {

        }
    }

    private fun handleLoginResult(state: UIState<Boolean>) {
        when(state) {
            is UIState.Success -> {
                onLoginSuccess()
            }
            is UIState.Loading -> {}
            is UIState.Failure -> {}
            else -> {

            }
        }
    }

    private fun onLoginSuccess() {
        findNavController().navigateSlideHorizontal(
            LoginFragmentDirections.actionLoginToHomeFragment(),
            R.id.app_nav,
        )
    }

}