package com.example.ibolot.ui.fragments.base

import android.widget.DatePicker
import android.widget.TimePicker
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

open class BaseFragment(@LayoutRes layoutId: Int) : Fragment(layoutId) {
    open fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {}
    open fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {}
}