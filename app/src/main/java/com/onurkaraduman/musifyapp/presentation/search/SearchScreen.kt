package com.onurkaraduman.musifyapp.presentation.search

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.onurkaraduman.musifyapp.design_system.components.SearchCardShimmerEffect
import com.onurkaraduman.musifyapp.presentation.search.components.SearchBar
import com.onurkaraduman.musifyapp.presentation.search.components.SearchList

@Composable
fun SearchScreen(
    state: SearchState,
    event: (SearchEvent) ->Unit,
    navigateToMusicPlayer: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchBar(
            modifier = Modifier.padding(top = 28.dp),
            text = state.searchQuery,
            readOnly = false,
            onValueChange = {event(SearchEvent.UpdateSearchQuery(it))},
            onSearch = {
                event(SearchEvent.SearchMusics)
            }
        )
        Spacer(modifier = Modifier.height(24.dp))

        when {
            state.isLoading -> {
                repeat(10){
                    SearchCardShimmerEffect()
                }
            }
            state.words != null -> {
                SearchList(searchMusicList = state.words , onClick = {navigateToMusicPlayer()})
            }
            state.errorMessage !=null -> {
                Log.e("Dante","EROOR: ${state.errorMessage}")
            }
            else -> {
                // todo NO Result Components
            }
        }

    }
}
