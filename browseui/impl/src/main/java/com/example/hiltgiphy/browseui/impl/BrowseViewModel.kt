package com.example.hiltgiphy.browseui.impl

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltgiphy.net.api.GiphyWebService
import kotlinx.coroutines.launch

class BrowseViewModel @ViewModelInject constructor(
    private val webServices: GiphyWebService
) : ViewModel(){

    fun fetchTrending(limit: Int, offset: Int) {
        viewModelScope.launch {
            webServices.fetchTrending(limit, offset)
        }
    }

}