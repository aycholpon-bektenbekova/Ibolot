package com.example.ibolot.ui.fragments.main

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ibolot.R
import com.example.ibolot.databinding.FragmentChildrenBinding
import com.example.ibolot.domain.model.ServiceItem
import com.example.ibolot.ui.fragments.base.BaseFragment
import com.example.ibolot.ui.fragments.main.adapters.ChildrenAdapter

class ChildrenFragment : BaseFragment(R.layout.fragment_children) {

    private val binding by viewBinding(FragmentChildrenBinding::bind)
    private val adapter = ChildrenAdapter(
        context = this@ChildrenFragment,
        onItemClick = this::onItemClick
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        binding.recyclerView.adapter = adapter

        adapter.addItems(ServiceItem(R.drawable.img_children.toString() , getString(R.string.children) , 1))
        adapter.addItems(ServiceItem(R.drawable.children_iv.toString() , getString(R.string.tv_children) , 2))
        adapter.addItems(ServiceItem(R.drawable.iv_children.toString() , getString(R.string.children_tv) , 3))
    }

    private fun onItemClick(item: ServiceItem) {
        if (item.keyId == 1) {
            findNavController().navigate(R.id.deleteToothFragment)
        }
        if (item.keyId == 2) {
            findNavController().navigate(R.id.dentalTreatmentFragment)
        }
        if (item.keyId == 3) {
            findNavController().navigate(R.id.toothChildrenFragment)
        }
    }
}