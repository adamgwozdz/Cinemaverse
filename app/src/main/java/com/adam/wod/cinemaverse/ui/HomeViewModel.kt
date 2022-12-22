package com.adam.wod.cinemaverse.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adam.wod.cinemaverse.data.TvShowContract
import com.adam.wod.cinemaverse.data.tv_show.model.room.PopularTvShowEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val tvShowsUseCase: TvShowContract.TvShowUseCase) : ViewModel() {

    var state by mutableStateOf(
        HomeViewState(popularTvShows = PopularTvShowEntity(), isRefreshing = true)
    )

    init {
        viewModelScope.launch(Dispatchers.Main) {
            getPopularTvShows()
        }
    }

    private fun getPopularTvShows() {
        viewModelScope.launch(Dispatchers.IO) {
            state = HomeViewState(
                popularTvShows = tvShowsUseCase.getPopularTvShows(),
                isRefreshing = false
            )
        }
    }
}