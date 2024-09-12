package com.onurkaraduman.musifyapp.presentation.search.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.onurkaraduman.musifyapp.domain.model.search.SearchMusicsModel

@Composable
fun SearchList(
    modifier: Modifier = Modifier,
    searchMusicList: List<SearchMusicsModel>,
    onClick: (Long) -> Unit
) {

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        contentPadding = PaddingValues(all = 6.dp)
    ) {
        items(count = searchMusicList.size) {
            val searchMusic = searchMusicList[it]
            SearchCard(searchResult = searchMusic, onClick = { onClick(searchMusic.id) })

        }

    }

}
