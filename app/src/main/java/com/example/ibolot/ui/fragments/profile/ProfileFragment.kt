package com.example.ibolot.ui.fragments.profile

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ibolot.Prefs
import com.example.ibolot.R
import com.example.ibolot.databinding.FragmentProfileBinding
import com.example.ibolot.ui.fragments.base.BaseFragment


class ProfileFragment : BaseFragment(R.layout.fragment_profile) {

    private val binding by viewBinding(FragmentProfileBinding::bind)
    private lateinit var launcher: ActivityResultLauncher<Intent>
    private lateinit var prefs: Prefs

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        saveImage()
        initLauncher()
//        saveName()
        prefs = Prefs(requireContext())
        initClicker()
//

        }


    private fun initClicker() {
        binding.btnExit.setOnClickListener {

                findNavController().navigate(R.id.exitFragment)
        prefs.saveRegister(true)

        }
    }

    private fun saveImage() {
        binding.pickPhoto.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_PICK
            intent.type = "image/*"
            launcher.launch(intent)
        }
    }

    private fun initLauncher() {
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

            if (it.resultCode == AppCompatActivity.RESULT_OK) {
                val image = it.data?.data
                if (image != null) {
                    binding.profileImage.setImageURI(image)
                }
            }
        }
    }

//    private fun saveName() {
//
//        binding.tvName.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(s: Editable?) {
//            }
//
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                context?.let { Prefs(it).saveNames(s.toString()) };
//                //prefs.saveNames(s.toString());
//            }
//        })
//        binding.tvName.setText(context?.let { Prefs(it).getName() })
//    }

    }

