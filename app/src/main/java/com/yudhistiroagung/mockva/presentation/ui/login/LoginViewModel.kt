package com.yudhistiroagung.mockva.presentation.ui.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yudhistiroagung.mockva.domain.authentication.model.LoginRequest
import com.yudhistiroagung.mockva.domain.authentication.usecase.LoginUseCase
import com.yudhistiroagung.mockva.presentation.common.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
): ViewModel() {

    private val _emailAddress = MutableLiveData("")
    val emailAddress: LiveData<String> = _emailAddress

    private val _password = MutableLiveData("")
    val password: LiveData<String> = _password

    private val _loginResult = MutableLiveData<UIState<Boolean>>()
    val loginResult: LiveData<UIState<Boolean>> = _loginResult

    fun login() {
        Log.d("LOGIN", "login CALLED")
        val username = _emailAddress.value
        val password = _password.value

        if (username == null || password == null) {
            return
        }

        Log.d("LOGIN", "login CALLED 2")

        _loginResult.value = UIState.Loading()
        loginUseCase.invoke(
            scope = viewModelScope,
            params = LoginRequest(username, password)
        ){
            it.fold({ data ->
                _loginResult.setValue(UIState.Success(true))
                Log.d("LOGIN", "SUCCESS $data")
            }, { throwable ->
                Log.d("LOGIN", "ERROR ${throwable}")
                _loginResult.setValue(UIState.Failure(throwable))
            })
        }
    }

    fun onUsernameChanged(emailAddress: String) {
        _emailAddress.value = emailAddress
    }

    fun onPasswordChanged(password: String) {
        _password.value = password
    }
}