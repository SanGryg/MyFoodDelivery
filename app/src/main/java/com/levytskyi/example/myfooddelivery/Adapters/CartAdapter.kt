package com.levytskyi.example.myfooddelivery.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.levytskyi.example.myfooddelivery.Models.PopularModel
import com.levytskyi.example.myfooddelivery.databinding.CartAddItemBinding

class CartAdapter(
    val context: Context,
    private var list: ArrayList<PopularModel>
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartAdapter.CartViewHolder {

        val binding = CartAddItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartAdapter.CartViewHolder, position: Int) {

        val listModel = list[position]

        holder.foodName.text = listModel.getFoodName()
        holder.foodPrice.text = listModel.getFoodPrice().toString()
        listModel.getFoodImage()?.let { holder.foodImage.setImageResource(it) }
        holder.foodCount.text = listModel.getFoodCount().toString()


        holder.plus.setOnClickListener {
            if (listModel.getFoodCount() < 10) {
                val count = listModel.getFoodCount() + 1
                listModel.setFoodCount(count)
                val price = listModel.getFoodPriceConstant() * listModel.getFoodCount()
                listModel.setFoodPrice(price)
                holder.foodPrice.text = listModel.getFoodPrice().toString()
                holder.foodCount.text = listModel.getFoodCount().toString()
                }
        }

        holder.minus.setOnClickListener {

            if (listModel.getFoodCount() >1){
               val count = listModel.getFoodCount() - 1
                listModel.setFoodCount(count)
                val price = listModel.getFoodPriceConstant() * listModel.getFoodCount()
                listModel.setFoodPrice(price)
                holder.foodPrice.text = listModel.getFoodPrice().toString()
                holder.foodCount.text = listModel.getFoodCount().toString()
            } else{
                holder.bindItem()
            }

        }
        holder.deleteBTN.setOnClickListener {
            holder.bindItem()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class CartViewHolder(binding: CartAddItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val foodImage = binding.homeFoodImage
        val foodName = binding.homeFoodName
        val foodPrice = binding.homeFoodPrice
        val foodCount = binding.foodCount

        val plus = binding.plusBtn
        val minus = binding.minusBtn

        val deleteBTN = binding.deleteBtn

        fun bindItem(){
            if(adapterPosition != RecyclerView.NO_POSITION){
               deleteItem(adapterPosition)
            }
        }
    }
    fun deleteItem(position: Int) {
        if (position in list.indices) {  // Перевіряємо, чи позиція існує
            list.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, list.size - position)
        }
    }
}