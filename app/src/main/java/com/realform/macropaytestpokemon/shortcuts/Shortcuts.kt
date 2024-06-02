package com.realform.macropaytestpokemon.shortcuts

import android.content.Context
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.realform.macropaytestpokemon.MainActivity
import com.realform.macropaytestpokemon.R


private  val OPEN_WEBSITE="open_website"
private  val SHORTCUT_ID="add_comment"
@RequiresApi(Build.VERSION_CODES.N_MR1)
object Shortcuts {
    fun shortcutSetup(context:Context){
        val shortcutManager =
            ContextCompat.getSystemService<ShortcutManager>(context , ShortcutManager::class.java)

        val webShortCut = ShortcutInfo.Builder(context, OPEN_WEBSITE)
            .setLongLabel("Visit the new website")
            .setShortLabel("visit Website")
            .setIcon(Icon.createWithResource(context, R.drawable.ic_web))
            .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse("https://realformstudio.com")))
            .build()


        val intents = arrayOf(
            Intent(Intent.ACTION_VIEW,null,context, MainActivity::class.java),
            Intent(Intent.ACTION_VIEW,null,context, ShortCutsActivity::class.java)
        )
        val intent = Intent( context, ShortCutsActivity::class.java)
        intent.setAction("com.realform.macropaytest.shortcuts.ShortCutsActivity");

        val commentShortcut = ShortcutInfo.Builder(context, SHORTCUT_ID)
            .setLongLabel("Add a new Comment")
            .setShortLabel("Add Comment")
            .setIcon(Icon.createWithResource(context, R.drawable.ic_comment))
            .setIntent(intent)
            .build()

        shortcutManager?.setDynamicShortcuts(listOf(commentShortcut, webShortCut))
    }
}