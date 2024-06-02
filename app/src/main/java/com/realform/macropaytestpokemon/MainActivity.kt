package com.realform.macropaytestpokemon

import android.app.PendingIntent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.realform.macropaytestpokemon.core.session.UserSession
import com.realform.macropaytestpokemon.databinding.ActivityMainBinding
import com.realform.macropaytestpokemon.presentation.nav.mainNavigation.RootNavGraphNavigation
import com.realform.macropaytestpokemon.presentation.ui.theme.AppTheme
import com.realform.macropaytestpokemon.shortcuts.Shortcuts
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainActivity : ComponentActivity(), KoinComponent {
    private val auth: FirebaseAuth by inject()
    private var authStateListener: FirebaseAuth.AuthStateListener? = null

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

         if(Build.VERSION.SDK_INT>=28){
             ShortcutPins()
         }
        // Inicia la sesión del usuario
        UserSession.start(auth)

        setContent {
            if (Build.VERSION.SDK_INT >= 25) {
                Shortcuts.shortcutSetup(this)
            }
            AppTheme {
                RootNavGraphNavigation(rememberNavController())
            }
        }

    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun ShortcutPins() {
        binding.btnAdd.setOnClickListener {
            val shortcutManager = getSystemService(ShortcutManager::class.java)
            if (shortcutManager.isRequestPinShortcutSupported) {
                val pinShortcutInfo = ShortcutInfo.Builder(this, "OPEN_WEBSITE").build()
                val shortCutCallbackIntent =
                    shortcutManager.createShortcutResultIntent(pinShortcutInfo)
                val successCallback = PendingIntent.getBroadcast(
                    applicationContext, 0, shortCutCallbackIntent,
                    PendingIntent.FLAG_IMMUTABLE
                )
                shortcutManager.requestPinShortcut(pinShortcutInfo, successCallback.intentSender)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        // auth.addAuthStateListener(authStateListener!!)
    }

    override fun onStop() {
        super.onStop()
        // auth.removeAuthStateListener(authStateListener!!)
    }


}


