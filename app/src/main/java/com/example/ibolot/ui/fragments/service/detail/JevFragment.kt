package com.example.ibolot.ui.fragments.service.detail

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ibolot.R
import com.example.ibolot.databinding.FragmentJevBinding
import com.example.ibolot.ui.fragments.base.BaseFragment


class JevFragment : BaseFragment(R.layout.fragment_jev) {

    private val binding by viewBinding(FragmentJevBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initClicker()
    }

    private fun initViews() {
        binding.inEndFragment.tv.text = "ВОССТАНОВЛЕНИЕ ЖЕВАТЕЛЬНОЙ ФУНКЦИИ"
    }

    private fun initClicker() {
        binding.inEndFragment.btnSubmit.setOnClickListener {
            findNavController().navigate(R.id.doctorsFragment)
        }
    }

}