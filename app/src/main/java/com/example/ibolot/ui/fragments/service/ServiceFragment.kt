package com.example.ibolot.ui.fragments.service

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ibolot.R
import com.example.ibolot.databinding.FragmentServiceBinding
import com.example.ibolot.domain.model.ServiceItem
import com.example.ibolot.ui.fragments.base.BaseFragment
import com.example.ibolot.ui.fragments.service.adapters.ServicesAdapter

class ServiceFragment : BaseFragment(R.layout.fragment_service) {

    private val binding by viewBinding(FragmentServiceBinding::bind)
    private val adapter = ServicesAdapter(
        context = this@ServiceFragment,
        onItemClick = this::onItemClick)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        binding.inService.rvServices.adapter = adapter
        binding.inService.rvServices.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        adapter.addItems(ServiceItem(R.drawable.item.toString(), "Ортопедия", 1))
        adapter.addItems(ServiceItem(R.drawable.item.toString(), "Имплантация ,удаление зубов,сложная хирургия", 2))
        adapter.addItems(ServiceItem(R.drawable.item.toString(), "Ортодотия (брекеты)", 3))
        adapter.addItems(ServiceItem(R.drawable.item.toString(), "Терапевтическая", 4))
        adapter.addItems(ServiceItem(R.drawable.item.toString(), "Хирургия", 5))
        adapter.addItems(ServiceItem(R.drawable.item.toString(), "Диагностика", 6))
    }

    private fun onItemClick(item: ServiceItem) {
        if (item.keyId == 1) {
            findNavController().navigate(R.id.ortophedicsFragment)
        }
    }
}