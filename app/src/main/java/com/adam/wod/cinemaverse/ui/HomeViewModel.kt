package com.adam.wod.cinemaverse.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adam.wod.cinemaverse.repository.tv_show.TvShowsContract
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val tvShowsUseCase: TvShowsContract.TvShowUseCase) : ViewModel() {

    var state by mutableStateOf(
        HomeViewState(popularTvShows = listOf(), isRefreshing = true)
    )

    init {
        getPopularTvShows()
    }

    private fun getPopularTvShows() {
        viewModelScope.launch {
            state = HomeViewState(
                popularTvShows = tvShowsUseCase.getPopularTvShows(),
                isRefreshing = false
            )
        }
    }
}