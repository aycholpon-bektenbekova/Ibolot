package com.example.ibolot.ui.fragments.service.record

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ibolot.R
import com.example.ibolot.databinding.FragmentRecordBinding
import com.example.ibolot.ui.fragments.base.BaseFragment

class RecordFragment : BaseFragment(R.layout.fragment_record) {

    private val binding by viewBinding(FragmentRecordBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {
        binding.inRecord.btnRecord.setOnClickListener {
           binding.inCalendar.calendar.isVisible = true
           binding.inCalendar.calendar.setOnDateChangeListener { view, year, month, dayOfMonth ->
               //textView.text = "$dayOfMonth.${month + 1}.$year"
           }

        }
    }
}