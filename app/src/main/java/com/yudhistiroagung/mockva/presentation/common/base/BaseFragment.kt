package com.yudhistiroagung.mockva.presentation.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_login.*

abstract class BaseFragment : Fragment() {

    abstract fun getResLayoutId(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(getResLayoutId(), container, false)

    protected fun showLoading() {
        loading_view?.let {
            loading_view.isVisible = true
        }
    }

    protected fun hideLoading() {
        loading_view?.let {
            loading_view.isVisible = false
        }
    }

    protected fun showError(message: String = "Terjadi Kesalahan") {
        view?.let {
            Snackbar
                .make(it, message, Snackbar.LENGTH_LONG)
                .show()
        }
    }

}