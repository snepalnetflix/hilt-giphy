package com.example.hiltgiphy.browseui.api

import android.content.Context
import android.content.Intent

interface BrowseUi {
    fun getActivityIntent(context: Context): Intent
}
