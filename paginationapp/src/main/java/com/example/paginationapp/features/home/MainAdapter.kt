package com.example.paginationapp.features.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.RecyclerView
import com.example.paginationapp.R

class MainAdapter<T>
    : PagingDataAdapter< MainDataModel, MainViewHolder>(ItemCallback) {
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MainViewHolder(view)
    }
}

class MainViewHolder(
    view: View
) : RecyclerView.ViewHolder(view){

    private var textView: TextView = view.findViewById(R.id.text)
    fun bind(item: MainDataModel){
        textView.text = item.name
    }
}

object ItemCallback : ItemCallback<MainDataModel>() {
    override fun areItemsTheSame(oldItem: MainDataModel, newItem: MainDataModel): Boolean = true

    override fun areContentsTheSame(oldItem: MainDataModel, newItem: MainDataModel): Boolean = true

}
