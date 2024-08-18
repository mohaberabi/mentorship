package com.mohaberabi.sourc

import com.mohaberabi.model.WeaknessModel
import kotlinx.coroutines.flow.Flow


interface WeaknessLocalDataSource {
    suspend fun addWeakness(weakness: WeaknessModel)
    fun getAllWeakness(): Flow<List<WeaknessModel>>
}