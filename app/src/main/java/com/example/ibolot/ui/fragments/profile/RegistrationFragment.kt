package com.example.ibolot.ui.fragments.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ibolot.R
import com.example.ibolot.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment(R.layout.fragment_registration) {
    private val binding by viewBinding(FragmentRegistrationBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClick()

//saving()
    }

    private fun initClick() {
        binding.btnExit.setOnClickListener {
            findNavController().navigate(R.id.navigation_profile)
        }
    }

//    private fun saving() {
//        val firstName = binding.etFirstName.text.toString()
//        val secondName = binding.etSecondName.text.toString()
//        val birthday = binding.etBirthday.text.toString()
//        val email = binding.etEmail.text.toString()
//        val number = binding.etNumber.text.toString()
//        val password = binding.etPassword.text.toString()
//        val bundle = Bundle()
//        val user = UserModel(1,firstName,secondName,birthday,email,number,password)
//        bundle.putSerializable("user", user)
//        parentFragmentManager.setFragmentResult("rk_news", bundle)
//        App.dataBase.userDao().insert(user)
//        findNavController().navigateUp()
//    }
}