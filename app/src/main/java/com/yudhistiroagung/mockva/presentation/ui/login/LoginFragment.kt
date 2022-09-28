package com.yudhistiroagung.mockva.presentation.ui.login

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.yudhistiroagung.mockva.R
import com.yudhistiroagung.mockva.presentation.common.base.BaseFragment
import com.yudhistiroagung.mockva.presentation.common.extension.navigateSlideHorizontal
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment() {
    override fun getResLayoutId(): Int = R.layout.fragment_login

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_login.setOnClickListener {
            findNavController().navigateSlideHorizontal(
                LoginFragmentDirections.actionLoginToHomeFragment(),
                R.id.app_nav,
            )
        }
    }

}