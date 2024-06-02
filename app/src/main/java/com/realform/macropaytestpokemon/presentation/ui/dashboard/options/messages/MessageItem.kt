package com.realform.macropaytestpokemon.presentation.ui.dashboard.options.messages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.realform.macropaytestpokemon.presentation.ui.dashboard.helpermodels.Message
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.realform.macropaytestpokemon.R


@Composable
fun MessageItem(message: Message, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        modifier = Modifier.padding(8.dp)
                    .width(300.dp)
                   .clickable { onClick() }
    ) {

            Row(modifier = Modifier.padding(16.dp)) {
                // Icon column (if needed)
                // Add icon here if necessary
                // Notification icon
                Icon(
                    painter = painterResource(id = R.drawable.ic_notification),
                    contentDescription = "Notification",
                    tint = Color.Yellow, // Customize icon color as needed
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.width(16.dp))
                // Content column
                Column {
                    Text(
                        text = message.title,
                        fontSize = 16.sp,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = message.messageContent,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    // Optional hyperlink
                    /* message.link?.let { link ->
                    Text(
                        text = link,
                        fontSize = 14.sp,
                        color = Color.Blue,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }*/
                }
            }
    }
}

@Preview
@Composable
fun PreviewMessageItem() {
    val sampleMessage = Message(
        senderId = "Promociones",
        title = "Dia de Pizza",
        messageContent = "Hello, how are you?",
    )
    MessageItem(message = sampleMessage,{})
}


