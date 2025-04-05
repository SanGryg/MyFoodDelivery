package com.levytskyi.example.myfooddelivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.levytskyi.example.myfooddelivery.Adapters.ByAgainAdapter
import com.levytskyi.example.myfooddelivery.Models.PopularModel
import com.levytskyi.example.myfooddelivery.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var adapter: ByAgainAdapter
    private lateinit var list: ArrayList<PopularModel>
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)


        sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        list = ArrayList()

        adapter = ByAgainAdapter(requireContext(), list)
        binding.recyclerView.adapter = adapter
        return binding.root
    }
}
