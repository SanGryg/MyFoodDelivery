package com.levytskyi.example.myfooddelivery.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.levytskyi.example.myfooddelivery.Models.NotificationModel
import com.levytskyi.example.myfooddelivery.databinding.NotificationItemBinding

class NotificationAdapter(
    private val context: Context,
    private val nList: ArrayList<NotificationModel>
) : RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val binding = NotificationItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return NotificationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val notificationItem = nList[position]


        notificationItem.getImage()?.let { holder.image.setImageResource(it) }


        holder.notification.text = notificationItem.getNotification()
    }

    override fun getItemCount(): Int {
        return nList.size
    }

    class NotificationViewHolder(val binding: NotificationItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val image = binding.notificationImage
        val notification = binding.notificationText
    }
}
