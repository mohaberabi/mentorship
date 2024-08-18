package com.mohaberabi.copy_weakness.domain

import android.content.Context
import android.net.Uri
import com.mohaberabi.model.WeaknessModel
import com.myfitnessbag.order.core.util.AppResult
import com.myfitnessbag.order.core.util.EmptyDataResult
import com.myfitnessbag.order.core.util.error.AppError
import com.myfitnessbag.order.core.util.error.CommonError
import com.myfitnessbag.order.core.util.error.errorModel
import javax.inject.Inject


interface AppContentProviderCursor<T> {
    val uri: String
    fun query(): AppResult<List<T>, AppError>
    fun add(item: T): EmptyDataResult<AppError>
    fun update(item: T): EmptyDataResult<AppError>
    fun delete(id: Long): EmptyDataResult<AppError>

}

