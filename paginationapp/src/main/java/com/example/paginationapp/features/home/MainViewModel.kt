package com.example.paginationapp.features.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData

class MainViewModel : ViewModel() {

    private val mutableDataSource = MutableLiveData<PagingData<MainDataModel>>()

    val dataSource: LiveData<PagingData<MainDataModel>>
        get() {

            return Pager(
                config = PagingConfig(10)
            ) {
                MainDataSource()
            }.liveData
        }
}