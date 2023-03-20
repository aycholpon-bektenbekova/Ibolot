package com.example.ibolot.ui.fragments.service.orthopedics

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ibolot.R
import com.example.ibolot.databinding.FragmentOrthopedicsBinding
import com.example.ibolot.ui.fragments.base.BaseFragment


class OrthopedicsFragment : BaseFragment(R.layout.fragment_orthopedics) {

    private val binding by viewBinding(FragmentOrthopedicsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}