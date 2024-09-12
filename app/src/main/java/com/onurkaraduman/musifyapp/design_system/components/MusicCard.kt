package com.onurkaraduman.musifyapp.design_system.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun MusicCard(title: String, imageUrl: String) {
    Card(
        modifier = Modifier
            .size(100.dp)
            .padding(horizontal = 2.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
        ) {
            val painter = rememberAsyncImagePainter(model = imageUrl)

            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .matchParentSize()
            )

            Column(
                modifier = Modifier
                    .align(Alignment.Center)
            ) {
                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
@Preview
fun MusicCardRowPreview() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        MusicCard(
            title = "Hit parçalar",
            imageUrl = "https://e-cdns-images.dzcdn.net/images/misc/8b9faa4bff0892283000a53b0d85eb73/56x56-000000-80-0-0.jpg"
        )
        MusicCard(
            title = "Indie",
            imageUrl = "https://e-cdns-images.dzcdn.net/images/misc/235ec47f2b21c3c73e02fce66f56ccc5/56x56-000000-80-0-0.jpg"
        )
        MusicCard(
            title = "TNTF",
            imageUrl = "https://e-cdns-images.dzcdn.net/images/misc/5dfdae5fdb147623ed11a2513074a970/56x56-000000-80-0-0.jpg"
        )
    }
}