package com.mohaberabi.uselessrepos.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohaberabi.uselessrepos.domain.usecase.GetAllReposUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GithubViewModel(
    private val getAllReposUseCase: GetAllReposUseCase
) : ViewModel() {


    private val _state = MutableStateFlow(GithubState())
    val state = _state.asStateFlow()


    init {
        getRepos()
    }

    private fun getRepos() {
        _state.update { it.copy(state = GithubStatus.Loading) }

        viewModelScope.launch {
            getAllReposUseCase()
                .onSuccess { repos ->
                    _state.update {
                        it.copy(
                            state = GithubStatus.Populated,
                            repos = repos
                        )
                    }
                }
                .onFailure { fail ->
                    fail.printStackTrace()
                    _state.update { it.copy(state = GithubStatus.Error) }
                }
        }
    }
}