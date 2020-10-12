package com.example.hiltgiphy.browseui.impl

import android.content.Context
import android.content.Intent
import com.example.hiltgiphy.browseui.api.BrowseUi

class BrowseUiImpl : BrowseUi {
    override fun getActivityIntent(context: Context): Intent {
        return Intent(context, BrowseActivity::class.java)
            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
}