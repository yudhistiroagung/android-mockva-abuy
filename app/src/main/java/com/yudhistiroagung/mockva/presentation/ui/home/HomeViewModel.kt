package com.yudhistiroagung.mockva.presentation.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yudhistiroagung.mockva.domain.account.model.Account
import com.yudhistiroagung.mockva.domain.account.usecase.GetAccountDetailUseCase
import com.yudhistiroagung.mockva.domain.common.usecase.BaseUseCase
import com.yudhistiroagung.mockva.presentation.common.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAccountDetailUseCase: GetAccountDetailUseCase
) : ViewModel() {
    private val _accountDetailResult = MutableLiveData<UIState<Account>>()
    val accountDetailResult: LiveData<UIState<Account>> = _accountDetailResult

    init {
        getAccountDetail()
    }

    fun getAccountDetail() {
        _accountDetailResult.value = UIState.Loading()
        getAccountDetailUseCase.invoke(
            scope = viewModelScope,
            params = BaseUseCase.None()
        ) {
            it.fold(
                { account ->
                    _accountDetailResult.setValue(UIState.Success(account))
                },
                { throwable ->
                    Log.d("ERROR", "${throwable.message}")
                    _accountDetailResult.setValue(UIState.Failure(throwable))
                }
            )
        }
    }

}