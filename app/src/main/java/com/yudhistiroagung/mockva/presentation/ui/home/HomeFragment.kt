package com.yudhistiroagung.mockva.presentation.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.yudhistiroagung.mockva.R
import com.yudhistiroagung.mockva.domain.account.model.Account
import com.yudhistiroagung.mockva.presentation.common.UIState
import com.yudhistiroagung.mockva.presentation.common.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private val homeViewModel by viewModels<HomeViewModel>()

    override fun getResLayoutId(): Int = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(homeViewModel) {
            accountDetailResult.observe(viewLifecycleOwner, ::handleAccountResult)
        }
    }

    private fun handleAccountResult(value: UIState<Account>) {
        when (value) {
            is UIState.Loading -> {
                showLoading()
            }
            is UIState.Success -> {
                hideLoading()
                setAccountInfo(value.data)
            }
            else -> {
                hideLoading()
                showError()
            }
        }
    }

    private fun setAccountInfo(account: Account) {
        with(account) {
            tvName.text = "Hello, $name"
            tvBalance.text = "Rp $balance"
        }
    }

}