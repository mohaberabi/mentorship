package com.mohaberabi.copy_weakness.presentation.viewmodel

import com.mohaberabi.model.WeaknessModel

sealed interface CopyWeaknessActions {


    data class OnWeaknessClick(
        val weakness: WeaknessModel,
    ) : CopyWeaknessActions
}