package com.mohaberabi.add_weakness.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
class AddWeaknessViewModel @Inject constructor(
    private val weaknessRepository: WeaknessRepository,
) : ViewModel() {


    private val _state = MutableStateFlow(AddWeaknessState())
    val state = _state.asStateFlow()
    private val _event = Channel<AddWeaknessEvents>()
    val event = _event.receiveAsFlow()

    fun onAction(action: AddWeaknessActions) {
        when (action) {
            is AddWeaknessActions.BodyChanged -> bodyChanged(action.value)
            is AddWeaknessActions.NameChanged -> nameChanged(action.value)
            AddWeaknessActions.SaveWeakness -> saveWeakness()
        }
    }


    private fun nameChanged(value: String) = setState { copy(name = value) }
    private fun bodyChanged(value: String) = setState { copy(body = value) }

    private fun saveWeakness() {
        setState { copy(loading = true) }

        val stateVal = _state.value
        viewModelScope.launch {
            weaknessRepository.addWeakness(stateVal.weakness)
                .onSuccess { _event.send(AddWeaknessEvents.Saved) }
                .onFailure { _event.send(AddWeaknessEvents.Error(it.asUiText())) }
        }
        setState { copy(loading = false) }
    }

    private fun setState(state: AddWeaknessState.() -> AddWeaknessState) {
        _state.update { state(_state.value) }
    }
}