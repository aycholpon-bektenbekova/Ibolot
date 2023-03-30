package com.example.ibolot.ui.fragments.board

import android.content.SharedPreferences

class Prefs {

    private lateinit var sharedPrefs : SharedPreferences

    fun isBoardShown(): Boolean? {
        return sharedPrefs.getBoolean("isBoardShown", false)
    }
}