package com.example.paginationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.paginationapp.features.home.MainAdapter
import com.example.paginationapp.features.home.MainDataModel
import com.example.paginationapp.features.home.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView
    private lateinit var progressBar : ProgressBar
    private lateinit var adapter : MainAdapter<MainDataModel>
    private lateinit var viewModel:MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()
        initViews()
        loadData()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    private fun loadData() {
            viewModel.dataSource.observe(this@MainActivity){
                lifecycleScope.launch {
                    adapter.submitData(it)
                }

            }

    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.progressBar)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = MainAdapter()
        recyclerView.adapter = adapter

        lifecycleScope.launch {
            adapter.loadStateFlow.collectLatest { state ->
                progressBar.isVisible = state.refresh is LoadState.Loading
                if (state.refresh is LoadState.NotLoading) Toast.makeText(this@MainActivity,"try", Toast.LENGTH_LONG).show()
                if (state.refresh is LoadState.Error) Toast.makeText(this@MainActivity,"Error ~~~", Toast.LENGTH_LONG).show()
            }
        }

    }
}