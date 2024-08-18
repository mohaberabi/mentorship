package com.mohaberabi.repository

import com.mohaberabi.model.WeaknessModel
import com.myfitnessbag.order.core.util.EmptyDataResult
import com.myfitnessbag.order.core.util.error.ErrorModel
import kotlinx.coroutines.flow.Flow


interface WeaknessRepository {
    fun getAllWeakness(): Flow<List<WeaknessModel>>
    suspend fun addWeakness(weakness: WeaknessModel): EmptyDataResult<ErrorModel>
}