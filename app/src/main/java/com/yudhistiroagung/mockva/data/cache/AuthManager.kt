package com.yudhistiroagung.mockva.data.cache

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import javax.inject.Inject

class AuthManager @Inject constructor(
    private val context: Context
) {

    companion object {
        const val PREF_NAME = "AUTH_MANAGER_PREFS"
        const val SESSION_ID_KEY = "SESSION_ID_KEY"
    }

    private val sharedPrefs: SharedPreferences by lazy {
        context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)
    }

    fun setSessionId(sessionId: String) {
        sharedPrefs.edit()
            .putString(SESSION_ID_KEY, sessionId)
            .apply()
    }

    fun getSessionId(): String? {
        return sharedPrefs.getString(SESSION_ID_KEY, "")
    }

}