package com.yudhistiroagung.mockva.presentation.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yudhistiroagung.mockva.R
import com.yudhistiroagung.mockva.presentation.common.extension.navigateSlideHorizontal
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_login, container, false)

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