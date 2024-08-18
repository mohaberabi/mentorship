package com.mohaberabi.copy_weakness.data

import android.content.ContentUris
import android.content.ContentValues
import android.content.Context
import android.net.Uri
import com.mohaberabi.copy_weakness.domain.AppContentProviderCursor
import com.mohaberabi.model.WeaknessModel
import com.myfitnessbag.order.core.util.AppResult
import com.myfitnessbag.order.core.util.EmptyDataResult
import com.myfitnessbag.order.core.util.error.AppError
import com.myfitnessbag.order.core.util.error.CommonError
import com.myfitnessbag.order.core.util.error.errorModel
import javax.inject.Inject

class WeaknessContentResolverCursor @Inject constructor(
    private val context: Context,
) : AppContentProviderCursor<WeaknessModel> {

    companion object {

        private const val ID = "_id"
        private const val TITLE = "title"

    }

    override val uri: String
        get() = "content://com.mohaberabi.weaknesspointapp.feature.copy_weakness"

    private val WEAKNESS_URI: Uri = Uri.withAppendedPath(Uri.parse(uri), "weakness")

    private val resolver = context.contentResolver
    override fun query(): AppResult<List<WeaknessModel>, AppError> {


        return try {
            val list = mutableListOf<WeaknessModel>()
            resolver.query(
                WEAKNESS_URI,
                null,
                null,
                null,
                null,
            ).use {
                it?.let { cursor ->
                    val idColumn = cursor.getColumnIndexOrThrow(ID)
                    val titleColumn = cursor.getColumnIndexOrThrow(TITLE)
                    while (cursor.moveToNext()) {
                        val id = cursor.getLong(idColumn)
                        val title = cursor.getString(titleColumn)
                        val weakness = WeaknessModel(
                            id = id,
                            title = title,
                        )
                        list.add(weakness)
                    }
                } ?: return@use

            }
            return AppResult.Done(list)
        } catch (e: Exception) {
            e.printStackTrace()
            AppResult.Error(errorModel(CommonError.UNKNOWN) {
                cause = e
                message = e.message
            })
        }

    }

    override fun delete(
        id: Long,
    ): EmptyDataResult<AppError> {
        return try {
            val deleteUri = ContentUris.withAppendedId(WEAKNESS_URI, id)
            resolver.delete(deleteUri, null, null)
            AppResult.Done(Unit)
        } catch (e: Exception) {
            e.printStackTrace()
            AppResult.Error(errorModel(CommonError.UNKNOWN) {
                cause = e
                message = e.message
            })
        }
    }

    override fun update(
        item: WeaknessModel,
    ): EmptyDataResult<AppError> {

        return try {
            val updateUri = ContentUris.withAppendedId(WEAKNESS_URI, item.id ?: 1L)
            val values = ContentValues().apply {
                put(TITLE, item.title)
            }

            resolver.update(updateUri, values, null, null)
            AppResult.Done(Unit)
        } catch (e: Exception) {
            e.printStackTrace()
            AppResult.Error(errorModel(CommonError.UNKNOWN) {
                cause = e
                message = e.message
            })
        }
    }

    override fun add(
        item: WeaknessModel,
    ): EmptyDataResult<AppError> {
        return try {
            val values = ContentValues().apply {
                put(TITLE, item.title)
            }
            resolver.insert(WEAKNESS_URI, values)
            AppResult.Done(Unit)
        } catch (e: Exception) {
            e.printStackTrace()
            AppResult.Error(errorModel(CommonError.UNKNOWN) {
                cause = e
                message = e.message
            })
        }
    }
}