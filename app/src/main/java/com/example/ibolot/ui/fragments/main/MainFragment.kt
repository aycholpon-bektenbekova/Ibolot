package com.example.ibolot.ui.fragments.main

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ibolot.R
import com.example.ibolot.databinding.FragmentMainBinding
import com.example.ibolot.domain.model.ServiceItem
import com.example.ibolot.ui.fragments.base.BaseFragment
import com.example.ibolot.ui.fragments.main.adapters.AdapterPager

class MainFragment : BaseFragment(R.layout.fragment_main) {

    private val binding by viewBinding(FragmentMainBinding::bind)
    private val adapter = AdapterPager(
        context = this@MainFragment,
        onItemClick = this::onItemClick
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    fun init() {
        binding.viewPager2.adapter = adapter
        binding.dotsInd.setViewPager2(binding.viewPager2)
    }
    private fun onItemClick(item: ServiceItem) {
        findNavController().navigate(R.id.navigation_service)
    }
}