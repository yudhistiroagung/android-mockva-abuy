package com.yudhistiroagung.mockva.presentation.common.extension

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import com.yudhistiroagung.mockva.R

private fun buildHorizontalAnimOptions(
    popupTo: Int?,
    inclusive: Boolean = false
): NavOptions {
    val builder = NavOptions.Builder()
        .setEnterAnim(R.anim.slide_in_right)
        .setExitAnim(R.anim.slide_out_left)
        .setPopEnterAnim(R.anim.slide_in_left)
        .setPopExitAnim(R.anim.slide_out_right)
    if (popupTo != null) builder.setPopUpTo(popupTo, inclusive)
    return builder.build()
}

private fun buildFadeAnimOptions(
    popupTo: Int?,
    inclusive: Boolean = false
): NavOptions {
    val builder = NavOptions.Builder()
        .setEnterAnim(R.anim.fade_in)
        .setExitAnim(R.anim.fade_out)
        .setPopEnterAnim(R.anim.fade_in)
        .setPopExitAnim(R.anim.fade_out)
    if (popupTo != null) builder.setPopUpTo(popupTo, inclusive)
    return builder.build()
}

fun NavController.navigateSlideHorizontal(
    @IdRes direction: Int,
    popupTo: Int? = null,
    inclusive: Boolean = false,
    args: Bundle? = null,
    options: NavOptions = buildHorizontalAnimOptions(popupTo, inclusive)
) {
    navigate(direction, args, options)
}

fun NavController.navigateSlideHorizontal(
    navDirections: NavDirections,
    popupTo: Int? = null,
    inclusive: Boolean = false,
    options: NavOptions = buildHorizontalAnimOptions(popupTo, inclusive)
) {
    navigate(navDirections, options)
}

fun NavController.navigateFadeAnimOptions(
    @IdRes direction: Int,
    popupTo: Int? = null,
    inclusive: Boolean = false,
    options: NavOptions = buildFadeAnimOptions(popupTo, inclusive)
) {
    navigate(direction, null, options)
}

fun NavController.navigateFadeAnimOptions(
    navDirections: NavDirections,
    popupTo: Int? = null,
    inclusive: Boolean = false,
    options: NavOptions = buildFadeAnimOptions(popupTo, inclusive)
) {
    navigate(navDirections, options)
}