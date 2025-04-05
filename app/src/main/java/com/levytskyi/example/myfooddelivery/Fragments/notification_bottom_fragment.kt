package com.levytskyi.example.myfooddelivery.Fragments

import android.app.Notification
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.levytskyi.example.myfooddelivery.Adapters.NotificationAdapter
import com.levytskyi.example.myfooddelivery.Models.NotificationModel
import com.levytskyi.example.myfooddelivery.R
import com.levytskyi.example.myfooddelivery.databinding.FragmentNotificationBottomFragmentBinding


class notification_bottom_fragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNotificationBottomFragmentBinding
    private lateinit var notificationList: ArrayList<NotificationModel>
    private lateinit var adapter: NotificationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationBottomFragmentBinding.inflate(inflater, container, false)

        notificationList = ArrayList()
        notificationList.add(NotificationModel(R.drawable.n_unsuccess, "Your order has been Canceled Successfully"))
        notificationList.add(NotificationModel(R.drawable.n_deliver, "Order has been taken by the driver"))
        notificationList.add(NotificationModel(R.drawable.n_success, "Congrats You Order Placed"))

        binding.btnBack.setOnClickListener{
            dismiss()
        }

        adapter = NotificationAdapter(requireContext(), notificationList as ArrayList<NotificationModel>)

        binding.noteRv.layoutManager = LinearLayoutManager(requireContext())
        binding.noteRv.adapter = adapter
        return binding.root
    }
}