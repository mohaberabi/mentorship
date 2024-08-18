package com.myfitnessbag.order.core.util


import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.mohaberabi.core.designsystem.R
import com.myfitnessbag.order.core.util.error.AppError
import com.myfitnessbag.order.core.util.error.CommonError
import com.myfitnessbag.order.core.util.error.LocalError


sealed class UiText {

    data object Empty : UiText()

    data class Dynamic(val value: String) : UiText()

    data class StringResource(
        @StringRes val id: Int,
        val formatArgs: List<Any> = listOf()
    ) : UiText()


    @Composable
    fun asString(): String {
        return when (this) {
            is Dynamic -> this.value
            Empty -> ""
            is StringResource -> stringResource(this.id)
        }
    }


    fun asString(context: Context): String {
        return when (this) {
            is Dynamic -> this.value
            Empty -> ""
            is StringResource -> context.getString(this.id)
        }
    }
}


fun AppError.asUiText(): UiText {
    val id = when (this) {

        is CommonError -> {
            when (this) {
                CommonError.IO_ERROR -> R.string.unknown_error
                CommonError.UNKNOWN -> R.string.unknown_error
            }
        }


        is LocalError -> {
            when (this) {
                LocalError.DISK_FULL -> R.string.unknown_error
                LocalError.UNKNOWN -> R.string.unknown_error
                LocalError.IO -> R.string.unknown_error
            }
        }


        else -> R.string.unknown_error
    }
    return UiText.StringResource(id)
}

