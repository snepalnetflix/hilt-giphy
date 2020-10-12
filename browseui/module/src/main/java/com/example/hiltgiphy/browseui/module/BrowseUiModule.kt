package com.example.hiltgiphy.browseui.module

import com.example.hiltgiphy.browseui.api.BrowseUi
import com.example.hiltgiphy.browseui.impl.BrowseUiImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface BrowseUiModule {
    @Binds
    fun bindBrowseUi(impl: BrowseUiImpl): BrowseUi
}
