package com.example.paginationapp.features.home

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import java.lang.Exception

class MainDataSource: PagingSource<Int, MainDataModel>() {

    private fun generateMainDataSource(loadSize: Int): List<MainDataModel> {
        var index = 0
        val list = mutableListOf<MainDataModel>()
        while (index < 50){
            list.add(MainDataModel("$index"))
            index++
        }
        Log.d("zhu","fake source loadSize $loadSize")
        return list
    }

    override fun getRefreshKey(state: PagingState<Int, MainDataModel>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(anchorPosition = it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MainDataModel> {
        try {
            val list = generateMainDataSource(params.loadSize)
            var result = list.size/10
            val aa = list.size % 10
            if (aa != 0) {
                result += 1
            }
            val position = params.key
            return LoadResult.Page(
                data = generateMainDataSource(params.loadSize),
                prevKey = if (position == 1) null else (position?.minus(1)),
                nextKey = if (position == result) null else position?.plus(1)
            )
        }catch (e: Exception){
            throw e
        }

    }
}