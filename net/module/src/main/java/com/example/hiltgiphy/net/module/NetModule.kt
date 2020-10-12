package com.example.hiltgiphy.net.module

import com.example.hiltgiphy.net.api.GiphyWebService
import com.example.hiltgiphy.net.impl.GiphyWebServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NetModule {
    @Binds
    @Singleton
    fun bindGiphyWebService(impl: GiphyWebServiceImpl): GiphyWebService
}
