package com.yudhistiroagung.mockva.domain.account.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Account(
    val id: String,
    val name: String,
    val username: String,
    val balance: Double,
): Parcelable