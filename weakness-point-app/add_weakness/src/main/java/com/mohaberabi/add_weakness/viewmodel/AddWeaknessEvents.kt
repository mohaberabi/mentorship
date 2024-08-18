package com.mohaberabi.add_weakness.viewmodel

import com.myfitnessbag.order.core.util.UiText

sealed interface AddWeaknessEvents {
    data class Error(val error: UiText) : AddWeaknessEvents

    data object Saved : AddWeaknessEvents
}