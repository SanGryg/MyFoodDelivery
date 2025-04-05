package com.levytskyi.example.myfooddelivery

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.levytskyi.example.myfooddelivery.Adapters.CartAdapter
import com.levytskyi.example.myfooddelivery.Models.PopularModel
import com.levytskyi.example.myfooddelivery.Models.SharedModel
import com.levytskyi.example.myfooddelivery.databinding.FragmentCartBinding


class CartFragment : Fragment() {

   private lateinit var binding : FragmentCartBinding


   private lateinit var adapter : CartAdapter

   private lateinit var sharedModel: SharedModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentCartBinding.inflate(inflater, container, false)

        sharedModel = ViewModelProvider(requireActivity()).get(SharedModel :: class.java )

        adapter = CartAdapter(requireContext(), sharedModel.cartItem.value ?: ArrayList())

        binding.cartRV.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRV.adapter = adapter

        binding.proceedBtn.setOnClickListener {
            val totalPrice = sharedModel.cartItem.value?.let { it1 -> calculatorPrice(it1) }
            if (totalPrice == 0){
              Toast.makeText(requireContext(), "List is Empty", Toast.LENGTH_SHORT).show()
            }
            val TotalPrice = totalPrice.toString()
            val intent = Intent(requireContext(), Details :: class.java)
            intent.putExtra("totalPrice", TotalPrice)
            startActivity(intent)
        }

        return binding.root
    }

    fun calculatorPrice(itemPrice : List<PopularModel>) : Int{

        var totalPrice = 0

        itemPrice.forEach { itemPrice ->
            val price = itemPrice.getFoodPriceConstant() * itemPrice.getFoodCount()
            totalPrice += price
        }

        return totalPrice
    }

}