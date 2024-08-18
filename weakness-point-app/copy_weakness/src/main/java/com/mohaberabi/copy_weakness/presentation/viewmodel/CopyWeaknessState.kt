package com.mohaberabi.copy_weakness.presentation.viewmodel

import com.mohaberabi.model.WeaknessModel
import com.myfitnessbag.order.core.util.UiText


enum class WeaknessStatus {
    Initial, Loading, Error, Populated
}

data class CopyWeaknessState(
    val state: WeaknessStatus = WeaknessStatus.Initial,
    val error: UiText = UiText.Empty,
    val weaknesses: List<WeaknessModel> = emptyList()
)
