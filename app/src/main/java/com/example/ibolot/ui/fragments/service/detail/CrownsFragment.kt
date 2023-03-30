package com.example.ibolot.ui.fragments.service.detail

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ibolot.R
import com.example.ibolot.databinding.FragmentCrownsBinding
import com.example.ibolot.ui.fragments.base.BaseFragment

class CrownsFragment : BaseFragment(R.layout.fragment_crowns) {

    private val binding by viewBinding(FragmentCrownsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initClicker()
    }

    private fun initViews() {
        binding.inEndFragment.tv.text = getString(R.string.coronki)
        binding.inEndFragment.desc1.text = getString(R.string.crowns_desc)
    }

    private fun initClicker() {
        binding.inEndFragment.btnSubmit.setOnClickListener {
            findNavController().navigate(R.id.doctorsFragment)
        }
    }
}