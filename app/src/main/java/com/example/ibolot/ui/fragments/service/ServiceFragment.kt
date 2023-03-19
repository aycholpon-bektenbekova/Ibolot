package com.example.ibolot.ui.fragments.service

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.ibolot.databinding.FragmentServiceBinding

class ServiceFragment : Fragment() {

    private lateinit var binding: FragmentServiceBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentServiceBinding.inflate(layoutInflater)
    }

}