package com.example.hiltgiphy.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp(Application::class)
class GiphyApplication : Hilt_GiphyApplication()