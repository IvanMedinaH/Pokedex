package com.realform.macropaytestpokemon.presentation.ui.dashboard.helpermodels

import java.util.UUID

data class Message(
    val messageId: String,
    val senderId: String,
    val title: String,
    val messageContent: String,
    val timestamp: Long
){
    //constructor in case of wanting to send a message
    constructor(senderId: String, title: String, messageContent: String) : this(
        UUID.randomUUID().toString(),
        senderId,
        title,
        messageContent,
        System.currentTimeMillis()
    )
}
