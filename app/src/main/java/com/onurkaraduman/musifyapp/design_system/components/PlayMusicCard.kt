package com.onurkaraduman.musifyapp.design_system.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.onurkaraduman.musifyapp.R
import com.onurkaraduman.musifyapp.design_system.theme.MusifyAppTheme

@Composable
fun PlayMusicCard(
    title: String,
    name: String,
    imageUrl: String,
    onClickCard: (Int) -> Unit,
    onClickPlayButton: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .size(width = 350.dp, height = 65.dp)
            .clickable { onClickCard(1) } // Example of adding click action to the card
            .background(color = Color.Black)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black)
                .padding(8.dp) // Optional: Padding for spacing
        ) {
            val painter = rememberAsyncImagePainter(model = imageUrl)
            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(50.dp)
            )

            Column(
                modifier = Modifier
                    .weight(1f) // Allows column to use remaining space
                    .padding(start = 8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = title,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp // Increased font size for visibility
                )
                Text(
                    text = name,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp // Increased font size for visibility
                )
            }

            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Play Button",
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterVertically) // Center vertically in the row
                    .size(32.dp) // Specify size to ensure visibility
                    .padding(start = 8.dp) // Optional: Padding for spacing
                    .clickable { onClickPlayButton(imageUrl) } // Example of adding click action to the icon
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewPlayMusicCard() {
    MusifyAppTheme {
        PlayMusicCard(
            title = "Mae Stephens - If We Ever Broke Up",
            name = "If We Ever Broke Up",
            imageUrl = "",
            onClickCard = {},
            onClickPlayButton = {}
        )
    }
}
