package com.onurkaraduman.musifyapp.presentation.home

import MusicState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.onurkaraduman.musifyapp.R
import com.onurkaraduman.musifyapp.design_system.components.MusicCard
import com.onurkaraduman.musifyapp.design_system.components.PlayMusicCard

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val musicState = viewModel.state.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.black)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(30.dp))

        DiscoverMusicSection(musicState.discoverMusicState)
        Spacer(modifier = Modifier.height(16.dp))

        GenresMusicSection(musicState.genresState)
        Spacer(modifier = Modifier.height(16.dp))

        PopularMusicSection(musicState.popularMusicState)
    }
}

@Composable
fun DiscoverMusicSection(state: MusicState.Discover) {
    HeaderAndButtonSection(
        header = stringResource(id = R.string.discover_new_music),
        buttonText = stringResource(id = R.string.browse)
    )
    Spacer(modifier = Modifier.height(8.dp))

    when {
        state.state.isLoading -> {
            CircularProgressIndicator(modifier = Modifier.padding(16.dp))
        }
        state.state.error.isNotBlank() -> {
            Text(
                text = state.state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
        }
        else -> {
            LazyRow(modifier = Modifier.fillMaxWidth().padding(horizontal = 28.dp)) {
                items(state.state.data) { discoverMusic ->
                    MusicCard(title = discoverMusic.title, imageUrl = discoverMusic.pictureSmall)
                }
            }
        }
    }
}

@Composable
fun GenresMusicSection(state: MusicState.Genres) {
    HeaderAndButtonSection(
        header = stringResource(id = R.string.genres),
        buttonText = stringResource(id = R.string.explore)
    )
    Spacer(modifier = Modifier.height(8.dp))

    when {
        state.state.isLoading -> {
            CircularProgressIndicator(modifier = Modifier.padding(16.dp))
        }
        state.state.error.isNotBlank() -> {
            Text(
                text = state.state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
        }
        else -> {
            LazyRow(modifier = Modifier.fillMaxWidth().padding(horizontal = 28.dp)) {
                items(state.state.data) { genre ->
                    MusicCard(title = genre.name, imageUrl = genre.pictureSmall)
                }
            }
        }
    }
}

@Composable
fun PopularMusicSection(state: MusicState.Popular) {
    HeaderAndButtonSection(
        header = stringResource(id = R.string.popular_songs),
        buttonText = stringResource(id = R.string.more)
    )

    when {
        state.state.isLoading -> {
            CircularProgressIndicator(modifier = Modifier.padding(16.dp))
        }
        state.state.error.isNotBlank() -> {
            Text(
                text = state.state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
        }
        else -> {
            LazyColumn(modifier = Modifier.fillMaxWidth().padding(horizontal = 28.dp)) {
                items(state.state.data) { popularMusic ->
                    PlayMusicCard(
                        title = popularMusic.title,
                        name = popularMusic.artistName,
                        imageUrl = popularMusic.pictureSmall,
                        onClickCard = {},
                        onClickPlayButton = {}
                    )
                }
            }
        }
    }
}

@Composable
fun HeaderAndButtonSection(
    modifier: Modifier = Modifier,
    header: String,
    buttonText: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = header,
            color = colorResource(id = R.color.white),
            fontWeight = FontWeight.Bold
        )

        Button(
            modifier = Modifier,
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.gray)
            )
        ) {
            Text(text = buttonText)
        }
    }
}