package com.example.ibolot.ui.fragments.main.details

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ibolot.R
import com.example.ibolot.databinding.FragmentDeleteToothBinding
import com.example.ibolot.ui.fragments.base.BaseFragment

class DeleteToothFragment : BaseFragment(R.layout.fragment_delete_tooth) {

    private val binding by viewBinding(FragmentDeleteToothBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSubmit.setOnClickListener {
            findNavController().navigate(R.id.doctorsFragment)
        }
    }
}