package com.example.ibolot.ui.fragments.service.orthopedics

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ibolot.R
import com.example.ibolot.databinding.FragmentOrthopedicsBinding
import com.example.ibolot.domain.model.ServiceItem
import com.example.ibolot.ui.fragments.base.BaseFragment
import com.example.ibolot.ui.fragments.service.adapters.ServicesAdapter

class OrthopedicsFragment : BaseFragment(R.layout.fragment_orthopedics) {

    private val binding by viewBinding(FragmentOrthopedicsBinding::bind)
    private val adapter = ServicesAdapter(
        context = this@OrthopedicsFragment,
        onItemClick = this::onItemClick)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        binding.inOrthopedic.rvServices.adapter = adapter
        binding.inOrthopedic.rvServices.layoutManager = LinearLayoutManager(
            context, LinearLayoutManager.VERTICAL,
            false)

        adapter.addItems(ServiceItem(R.drawable.orthopedics.toString(), "Протезирование"))
        adapter.addItems(ServiceItem(R.drawable.orthopedics.toString(), "Протезирование"))
        adapter.addItems(ServiceItem(R.drawable.orthopedics.toString(), "Протезирование"))
        adapter.addItems(ServiceItem(R.drawable.orthopedics.toString(), "Протезирование"))
        adapter.addItems(ServiceItem(R.drawable.orthopedics.toString(), "Протезирование"))
        adapter.addItems(ServiceItem(R.drawable.orthopedics.toString(), "Протезирование"))
    }

    private fun onItemClick(item: ServiceItem) {
        findNavController().navigate(R.id.prostheticsFragment)
    }
}