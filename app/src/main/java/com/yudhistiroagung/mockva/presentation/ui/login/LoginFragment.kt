package com.yudhistiroagung.mockva.presentation.ui.login

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.widget.addTextChangedListener
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
            Log.d("LOGIN", "BUTTON CLICKED")
            loginViewModel.login()
        }

        emailAddress.addTextChangedListener{
            loginViewModel.onUsernameChanged(it.toString())
        }
        password.addTextChangedListener {
            loginViewModel.onPasswordChanged(it.toString())
        }

        setCredentialsInput()
    }

    private fun setCredentialsInput() {
        emailAddress.setText("USER050905")
        password.setText("tb8450z")
    }

    private fun handleLoginResult(state: UIState<Boolean>) {
        when(state) {
            is UIState.Success -> {
                hideLoading()
                onLoginSuccess()
            }
            is UIState.Loading -> {
                showLoading()
            }
            else -> {
                showError()
                hideLoading()
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