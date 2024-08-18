package com.mohaberabi.add_weakness.viewmodel

sealed interface AddWeaknessActions {


    data object SaveWeakness : AddWeaknessActions


    data class NameChanged(val value: String) : AddWeaknessActions

    data class BodyChanged(val value: String) : AddWeaknessActions


}