package com.levytskyi.example.myfooddelivery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.levytskyi.example.myfooddelivery.Adapters.PopularAdapter
import com.levytskyi.example.myfooddelivery.Models.PopularModel
import com.levytskyi.example.myfooddelivery.Models.SharedModel


class MenuBottomSheerFragment : BottomSheetDialogFragment() {

    private lateinit var adapter: PopularAdapter
    private lateinit var menuList: ArrayList<PopularModel>
    private lateinit var menuRv: RecyclerView

    private lateinit var sharedModel: SharedModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_menu_bottom_sheer, container, false)

        sharedModel = ViewModelProvider(requireActivity()).get(SharedModel :: class.java )


        menuList = ArrayList()
        menuList.add(PopularModel(R.drawable.pop_menu_burger, "Sandwich", 7, 7, 1))
        menuList.add(PopularModel(R.drawable.pop_menu_sandwich, "Momo", 9, 9, 1))
        menuList.add(PopularModel(R.drawable.pop_menu_momo, "Burger", 5, 5, 1))
        menuList.add(PopularModel(R.drawable.pop_menu_burger, "Sandwich", 7, 7, 1))
        menuList.add(PopularModel(R.drawable.pop_menu_sandwich, "Momo", 9, 9, 1))
        menuList.add(PopularModel(R.drawable.pop_menu_momo, "Burger", 5, 5, 1))
        menuList.add(PopularModel(R.drawable.pop_menu_burger, "Sandwich", 7, 7, 1))
        menuList.add(PopularModel(R.drawable.pop_menu_sandwich, "Momo", 9, 9, 1))
        menuList.add(PopularModel(R.drawable.pop_menu_momo, "Burger", 5, 5, 1))
        menuList.add(PopularModel(R.drawable.pop_menu_burger, "Sandwich", 7, 7, 1))
        menuList.add(PopularModel(R.drawable.pop_menu_sandwich, "Momo", 9, 9, 1))
        menuList.add(PopularModel(R.drawable.pop_menu_momo, "Burger", 5, 5, 1))

        adapter = PopularAdapter(requireContext(), menuList)
        adapter.setSharedModel(sharedModel)

        menuRv = view.findViewById(R.id.menu_RV)
        menuRv.layoutManager = LinearLayoutManager(requireContext())
        menuRv.adapter = adapter

        return view
    }


}