package com.example.ibolot.ui.fragments.service.record

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ibolot.R
import com.example.ibolot.databinding.FragmentRecordBinding
import com.example.ibolot.ui.fragments.base.BaseFragment

class RecordFragment : BaseFragment(R.layout.fragment_record), TimePickerDialog.OnTimeSetListener,
    DatePickerDialog.OnDateSetListener {

    private val binding by viewBinding(FragmentRecordBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {
        binding.inRecord.btnRecord.setOnClickListener {

            if (binding.inRecord.etName.text.isEmpty()) {
                Toast.makeText(requireContext(), getString(R.string.input_name), Toast.LENGTH_SHORT).show()
            } else
                findNavController().navigate(R.id.calendarFragment)
        }
    }
}