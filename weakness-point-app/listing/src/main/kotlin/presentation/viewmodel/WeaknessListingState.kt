package presentation.viewmodel

import com.mohaberabi.model.WeaknessModel


sealed interface WeaknessListingState {


    data object Loading : WeaknessListingState
    data class Done(val weaknessList: List<WeaknessModel>) : WeaknessListingState
    data object Error : WeaknessListingState

}