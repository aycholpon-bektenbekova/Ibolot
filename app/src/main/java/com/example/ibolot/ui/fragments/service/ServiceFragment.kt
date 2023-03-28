package com.example.ibolot.ui.fragments.service

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ibolot.R
import com.example.ibolot.R.drawable.item_service
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

        adapter.run {
            addItems(ServiceItem(item_service.toString(), getString(R.string.protezirovanie), 1))
            addItems(ServiceItem(item_service.toString(), getString(R.string.jev), 2))
            addItems(ServiceItem(item_service.toString(), getString(R.string.dentures), 3))
            addItems(ServiceItem(item_service.toString(), getString(R.string.coronki), 4))
            addItems(ServiceItem(item_service.toString(), getString(R.string.implant), 5))
            addItems(ServiceItem(item_service.toString(), getString(R.string.brackets), 6))
            addItems(ServiceItem(item_service.toString(), getString(R.string.caries), 7))
            addItems(ServiceItem(item_service.toString(), getString(R.string.otbelivanie), 8))
        }
    }

    private fun onItemClick(item: ServiceItem) {
        if (item.keyId == 1) {
            findNavController().navigate(R.id.prostheticsFragment)
        }
        if (item.keyId == 2) {
            findNavController().navigate(R.id.jevFragment)
        }
        if (item.keyId == 3) {
            findNavController().navigate(R.id.denturesFragment)
        }
        if (item.keyId == 4) {
            findNavController().navigate(R.id.crownsFragment)
        }
        if (item.keyId == 5) {
            findNavController().navigate(R.id.prostheticsFragment)
        }
        if (item.keyId == 6) {
            findNavController().navigate(R.id.prostheticsFragment)
        }
        if (item.keyId == 7) {
            findNavController().navigate(R.id.prostheticsFragment)
        }
        if (item.keyId == 8) {
            findNavController().navigate(R.id.prostheticsFragment)
        }
    }
}