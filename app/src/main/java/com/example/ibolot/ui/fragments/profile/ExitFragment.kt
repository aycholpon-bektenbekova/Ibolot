package com.example.ibolot.ui.fragments.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ibolot.Prefs
import com.example.ibolot.R
import com.example.ibolot.databinding.FragmentExitBinding

class ExitFragment : Fragment(R.layout.fragment_exit) {
    private val binding by viewBinding(FragmentExitBinding::bind)
    private lateinit var prefs: Prefs

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
initClicker()
    }

    private fun initClicker() {

        binding.btnExit.setOnClickListener {
            findNavController().navigate(R.id.navigation_profile)

        }
        binding.tvForgotPassword.setOnClickListener{
                findNavController().navigate(R.id.forgotPasswordFragment) }

        binding.tvRegistration.setOnClickListener {
            findNavController().navigate(R.id.registrationFragment)

        }}
    }
