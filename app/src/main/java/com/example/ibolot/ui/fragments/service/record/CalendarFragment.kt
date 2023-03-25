package com.example.ibolot.ui.fragments.service.record

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ibolot.R
import com.example.ibolot.databinding.FragmentCalendarBinding
import com.example.ibolot.ui.fragments.base.BaseFragment
import java.util.*

class CalendarFragment : BaseFragment(R.layout.fragment_calendar), TimePickerDialog.OnTimeSetListener,
    DatePickerDialog.OnDateSetListener {

    private val binding by viewBinding(FragmentCalendarBinding::bind)

    var day = 0
    var moth = 0
    var year = 0
    var hour = 0
    var minute = 0

    var savedDay = 0
    var savedMoth = 0
    var savedYear = 0
    var savedHour = 0
    var savedMinute = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {
        binding.inCalendar.btmTime.setOnClickListener{
            getDateTimeCalendar()
            DatePickerDialog(requireContext(),this, year, moth, day).show()
        }
        binding.inCalendar.btmRegister.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun getDateTimeCalendar(){
        val cal : Calendar = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        moth = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
        hour = cal.get(Calendar.HOUR)
        minute = cal.get(Calendar.MINUTE)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        savedDay =dayOfMonth
        savedMoth =  month + 1
        savedYear = year
        getDateTimeCalendar()
        TimePickerDialog(requireContext(),this,hour,minute,true).show()
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        savedHour = hourOfDay
        savedMinute = minute

        binding.inCalendar.tvTextTime.text="$savedDay-$savedMoth-$savedYear\n Часов:$savedHour Минут:$savedMinute"
    }

}