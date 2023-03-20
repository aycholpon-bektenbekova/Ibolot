package com.example.ibolot.ui.fragments.service

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ibolot.R
import com.example.ibolot.databinding.FragmentServiceBinding
import com.example.ibolot.domain.model.ServiceItem
import com.example.ibolot.ui.fragments.base.BaseFragment
import com.example.ibolot.ui.fragments.service.adapters.ServicesAdapter

class ServiceFragment : BaseFragment(R.layout.fragment_service) {

    private val binding by viewBinding(FragmentServiceBinding::bind)
    private val adapter = ServicesAdapter(this::onItemClick)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        binding.rvServices.adapter = adapter

    }

    private fun onItemClick(item: ServiceItem) {

        findNavController().navigate(R.id.ortophedicsFragment)
    }

}