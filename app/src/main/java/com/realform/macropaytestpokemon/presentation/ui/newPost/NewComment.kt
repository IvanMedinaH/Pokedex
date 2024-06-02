package com.realform.macropaytestpokemon.presentation.ui.newPost

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun PostForm() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = "",
            onValueChange = { /* Do something */ },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("What's on your mind?") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { /* Handle done action */ })
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { /* Handle add photo/video action */ },
                modifier = Modifier.weight(1f).padding(end = 8.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = ImageVector.vectorResource(id = android.R.drawable.picture_frame), contentDescription = "Add photo")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "Add Photo/Video")
                }
            }
            Button(
                onClick = { /* Handle post action */ },
                modifier = Modifier.weight(1f).padding(start = 8.dp)
            ) {
                Text(text = "Post")
            }
        }
    }
}

@Composable
fun Icon(imageVector: ImageVector, contentDescription: String) {
    Image(
        imageVector = imageVector,
        contentDescription = contentDescription,
        modifier = Modifier.size(24.dp),
        colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.Black)
    )
}
