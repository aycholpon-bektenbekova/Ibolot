package com.example.ibolot.ui.fragments.service.doctors

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ibolot.R
import com.example.ibolot.databinding.FragmentDoctorsBinding
import com.example.ibolot.domain.model.ServiceItem
import com.example.ibolot.ui.fragments.base.BaseFragment
import com.example.ibolot.ui.fragments.service.adapters.ServicesAdapter

class DoctorsFragment : BaseFragment(R.layout.fragment_doctors) {

    private val binding by viewBinding(FragmentDoctorsBinding::bind)
    private val adapter = ServicesAdapter(
        context = this@DoctorsFragment,
        onItemClick = this::onItemClick)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        binding.rvDoctors.adapter = adapter
        binding.rvDoctors.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        adapter.addItems(ServiceItem(R.drawable.item_doctor.toString(), getString(R.string.name_doctor), 1))
        adapter.addItems(ServiceItem(R.drawable.item_doctor.toString(), getString(R.string.name_doctor), 1))
        adapter.addItems(ServiceItem(R.drawable.item_doctor.toString(), getString(R.string.name_doctor), 1))
        adapter.addItems(ServiceItem(R.drawable.item_doctor.toString(), getString(R.string.name_doctor), 1))
        adapter.addItems(ServiceItem(R.drawable.item_doctor.toString(), getString(R.string.name_doctor), 1))
    }

    private fun onItemClick(item: ServiceItem) {
        if (item.keyId == 1)
            findNavController().navigate(R.id.recordFragment)
        }
}