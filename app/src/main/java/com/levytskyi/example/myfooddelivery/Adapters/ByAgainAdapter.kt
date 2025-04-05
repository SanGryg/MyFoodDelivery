package com.levytskyi.example.myfooddelivery.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.levytskyi.example.myfooddelivery.Models.PopularModel
import com.levytskyi.example.myfooddelivery.databinding.ItemPreviousBuyBinding

class ByAgainAdapter(
    private val context: Context,
    private val list: ArrayList<PopularModel>
) : RecyclerView.Adapter<ByAgainAdapter.ByAgainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ByAgainViewHolder {
        val binding = ItemPreviousBuyBinding.inflate(LayoutInflater.from(context), parent, false)
        return ByAgainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ByAgainViewHolder, position: Int) {
        val item = list[position]
        holder.binding.foodName.text = item.getFoodName()
        holder.binding.foodPrice.text = item.getFoodPrice().toString()
        item.getFoodImage()?.let { holder.binding.foodImage.setImageResource(it) }
    }

    override fun getItemCount(): Int = list.size

    class ByAgainViewHolder(val binding: ItemPreviousBuyBinding) : RecyclerView.ViewHolder(binding.root)
}
