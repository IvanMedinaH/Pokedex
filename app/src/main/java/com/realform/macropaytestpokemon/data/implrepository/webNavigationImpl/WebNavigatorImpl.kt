package com.realform.macropaytestpokemon.data.implrepository.webNavigationImpl

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.realform.macropaytestpokemon.domain.repository.website.IWebNavigator

class WebNavigatorImpl(private val context: Context): IWebNavigator {

    override fun openWebsite(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }
}