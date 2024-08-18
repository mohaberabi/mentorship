package com.mohaberabi.add_weakness.viewmodel

import com.mohaberabi.model.WeaknessModel

data class AddWeaknessState(
    val name: String = "",
    val body: String = "",
    val loading: Boolean = false,
)


val AddWeaknessState.weakness
    get() = WeaknessModel(
        title = name,
    )
