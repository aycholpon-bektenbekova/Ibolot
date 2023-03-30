package com.example.ibolot.ui.fragments.profile

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ibolot.R
import com.example.ibolot.databinding.FragmentRegistrationBinding
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import java.util.concurrent.TimeUnit

class RegistrationFragment : Fragment(R.layout.fragment_registration) {
    private val binding by viewBinding(FragmentRegistrationBinding::bind)
    private val auth = FirebaseAuth.getInstance()
    private lateinit var uid: String
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    private lateinit var resendToken: PhoneAuthProvider.ForceResendingToken

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClick()
        binding.btnSms.setOnClickListener {
            if (binding.etNumber.text.isEmpty()) {
               // Toast.makeText(this@RegistrationFragment, "Input phone number", Toast.LENGTH_SHORT).show()
            }
            initCallback()
            val options = PhoneAuthOptions.newBuilder(auth)
                .setPhoneNumber(binding.etNumber.text.toString())
                .setTimeout(60L, TimeUnit.SECONDS)
                .setActivity(requireActivity())
                .setCallbacks(callbacks)
                .build()
            PhoneAuthProvider.verifyPhoneNumber(options)
        }
        binding.btnExit.setOnClickListener {
            examCode()
        }
    }

    private fun examCode() {
        val credential = PhoneAuthProvider.getCredential(
            uid,
            binding.etPassword.text.toString()
        )

        auth.signInWithCredential(credential)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    Log.d("aic", "signInWithCredential:success")
                    findNavController().navigate(R.id.navigation_main)
                } else Log.d("aic", "signInWithCredential:error")
            }
    }

    private fun initCallback() {
        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                // This callback will be invoked in two situations:
                // 1 - Instant verification. In some cases the phone number can be instantly
                //     verified without needing to send or enter a verification code.
                // 2 - Auto-retrieval. On some devices Google Play services can automatically
                //     detect the incoming verification SMS and perform verification without
                //     user action.
//                Log.d(TAG, "onVerificationCompleted:$credential")
//                signInWithPhoneAuthCredential(credential)
            }

            override fun onVerificationFailed(e: FirebaseException) {
                // This callback is invoked in an invalid request for verification is made,
                // for instance if the the phone number format is not valid.
//                Log.w(TAG, "onVerificationFailed", e)
                Log.d("ololo", e.message.toString())
                if (e is FirebaseAuthInvalidCredentialsException) {
                    // Invalid request
                } else if (e is FirebaseTooManyRequestsException) {
                    // The SMS quota for the project has been exceeded
                }

                // Show a message and update the UI
            }

            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {
                // The SMS verification code has been sent to the provided phone number, we
                // now need to ask the user to enter the code and then construct a credential
                // by combining the code with a verification ID.
//                Log.d(TAG, "onCodeSent:$verificationId")

                // Save verification ID and resending token so we can use them later
                uid = verificationId
                resendToken = token
                Log.d("aic", "auth succd")
                with(binding) {
                    btnSms.isVisible = false
                    etPassword.isVisible = true
                    btnExit.isVisible = true
                }
            }
        }

    }
//saving()

    private fun initClick() {
        binding.btnExit.setOnClickListener {
            findNavController().navigate(R.id.navigation_main)
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
