package com.example.weatherappxml.adapters

import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherappxml.databinding.ListItemBinding

// ...
class WeatherAdapter : ListAdapter<WeatherModel, WeatherAdapter.Holder>() {
    class  Holder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ListItemBinding.bind(view)

        fun bind(item: WeatherModel) = with(binding){
            tvDate.text = item.time
            tvCondition.text = item.condition
            tvTemp.text = item.currentTemp
        }
    }
}