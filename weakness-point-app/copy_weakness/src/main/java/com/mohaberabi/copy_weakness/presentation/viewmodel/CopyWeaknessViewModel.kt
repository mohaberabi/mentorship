package com.mohaberabi.copy_weakness.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohaberabi.copy_weakness.domain.AppContentProviderCursor
import com.mohaberabi.model.WeaknessModel
import com.mohaberabi.repository.WeaknessRepository
import com.myfitnessbag.order.core.util.asUiText
import com.myfitnessbag.order.core.util.onFailure
import com.myfitnessbag.order.core.util.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CopyWeaknessViewModel @Inject constructor(
    private val weaknessRepository: WeaknessRepository,
    private val cursor: AppContentProviderCursor<WeaknessModel>
) : ViewModel() {


    private val _state = MutableStateFlow(CopyWeaknessState())

    val state = _state.asStateFlow()


    private val _event = Channel<CopyWeaknessEvents>()
    val event = _event.receiveAsFlow()

    init {
        getWeakness()
    }


    fun onAction(action: CopyWeaknessActions) {
        when (action) {
            is CopyWeaknessActions.OnWeaknessClick -> copyWeakness(action.weakness)
        }
    }

    private fun getWeakness() {
        setState { copy(state = WeaknessStatus.Loading) }
        viewModelScope.launch {
            cursor.query()
                .onSuccess { setState { copy(state = WeaknessStatus.Populated, weaknesses = it) } }
                .onFailure {
                    setState {
                        copy(
                            state = WeaknessStatus.Error,
                            error = it.asUiText()
                        )
                    }
                }
        }
    }

    private fun copyWeakness(weakness: WeaknessModel) {
        viewModelScope.launch {
            weaknessRepository.addWeakness(weakness)
                .onSuccess { _event.send(CopyWeaknessEvents.Copied) }
                .onFailure { fail -> _event.send(CopyWeaknessEvents.Error(fail.asUiText())) }
        }
    }

    private fun setState(state: CopyWeaknessState.() -> CopyWeaknessState) {
        _state.update { state(_state.value) }
    }
}