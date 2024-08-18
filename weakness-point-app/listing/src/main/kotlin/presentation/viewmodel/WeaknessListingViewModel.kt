package presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohaberabi.repository.WeaknessRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

import javax.inject.Inject

@HiltViewModel
class WeaknessListingViewModel @Inject constructor(
    private val weaknessRepository: WeaknessRepository,
) : ViewModel() {

    val state: StateFlow<WeaknessListingState> = weaknessRepository.getAllWeakness()
        .onStart { WeaknessListingState.Loading }
        .map { weakness -> WeaknessListingState.Done(weakness) }
        .catch { WeaknessListingState.Error }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            WeaknessListingState.Loading
        )


}