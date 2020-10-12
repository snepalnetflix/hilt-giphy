package com.example.hiltgiphy.browseui.impl

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint(AppCompatActivity::class)
class BrowseActivity : Hilt_BrowseActivity() {
    companion object {
        const val BROWSE_FRAGMENT_TAG = "browse"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (supportFragmentManager.findFragmentByTag(BROWSE_FRAGMENT_TAG) == null) {
            supportFragmentManager
                .beginTransaction()
                .add(BrowseFragment(), BROWSE_FRAGMENT_TAG)
                .commitNow()
        }
    }
}
