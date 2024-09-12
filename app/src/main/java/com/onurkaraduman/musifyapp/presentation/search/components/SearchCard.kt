package com.onurkaraduman.musifyapp.presentation.search.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.onurkaraduman.musifyapp.R
import com.onurkaraduman.musifyapp.design_system.theme.MusifyAppTheme
import com.onurkaraduman.musifyapp.domain.model.search.SearchMusicsModel

@Composable
fun SearchCard(
    modifier: Modifier = Modifier,
    searchResult: SearchMusicsModel,
    onClick: () -> Unit
) {

    val context = LocalContext.current

    Row(modifier = modifier.clickable { onClick() }
        .background(Color.Black)) {
        AsyncImage(
            modifier = Modifier
                .size(40.dp)
                .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(context).data(searchResult.pictureSmall).build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .height(40.dp)
        ) {
            Text(
                text = searchResult.title,
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(R.color.white),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = searchResult.artistName,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.LightGray,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )


        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewSearchCard() {
    MusifyAppTheme {
        SearchCard(searchResult = SearchMusicsModel(
            id = 9856454,
            artistName = "The Weekend",
            title = "In The Night",
            "",
            next = "5",
            total = 5,
        ), onClick = {})
    }
}
