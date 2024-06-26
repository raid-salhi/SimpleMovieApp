package com.example.simplemovieapp.presentation.componants

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Size
import com.example.simplemovieapp.R
import com.example.simplemovieapp.data.model.Movie
import com.example.simplemovieapp.data.utils.Constant
import kotlin.math.min

@Composable
fun MovieItem(movie: Movie, onClick: () -> Unit) {
    Row (modifier = Modifier
        .clickable { onClick.invoke() }
        .fillMaxSize()
        .padding(bottom = 10.dp)) {
        MovieImage(
            poster =movie.poster ,
            modifier = Modifier
                .padding(end = 5.dp)
                .fillMaxWidth(0.25f)
        )
        Column {
            TitleText(text = movie.title, modifier = Modifier.padding(bottom = 10.dp))
            Text(
                text = movie.getYear(),
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
            )
        }
    }

}
@Composable
fun ContentText(text: String, modifier: Modifier) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        modifier=modifier
    )
}

@Composable
fun TitleText(text: String, modifier: Modifier) {
    Text(
        text = text,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}

@Composable
fun MovieImage(poster: String, modifier: Modifier) {
    AsyncImage(
        model = Constant.PIC_BASE_URL + poster,
        contentDescription = stringResource(R.string.description),
        contentScale = ContentScale.Crop,
        modifier = modifier,

    )
}