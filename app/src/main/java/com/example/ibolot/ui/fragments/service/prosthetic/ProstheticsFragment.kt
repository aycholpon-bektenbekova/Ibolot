package com.example.ibolot.ui.fragments.service.prosthetic

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ibolot.R
import com.example.ibolot.databinding.FragmentProstheticsBinding
import com.example.ibolot.databinding.FragmentServiceBinding
import com.example.ibolot.ui.fragments.base.BaseFragment


class ProstheticsFragment : BaseFragment(R.layout.fragment_prosthetics) {

    private val binding by viewBinding(FragmentProstheticsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {
        binding.btnSubmit.setOnClickListener {
            //переход к списку врачей
        }
    }
}