package com.mohaberabi.copy_weakness.presentation.viewmodel

import com.myfitnessbag.order.core.util.UiText


sealed interface CopyWeaknessEvents {


    data object Copied : CopyWeaknessEvents
    data class Error(val error: UiText) : CopyWeaknessEvents
}