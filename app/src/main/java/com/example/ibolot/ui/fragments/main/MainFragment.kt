package com.example.ibolot.ui.fragments.main

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ibolot.R
import com.example.ibolot.databinding.FragmentMainBinding
import com.example.ibolot.domain.model.PagerItem
import com.example.ibolot.ui.fragments.base.BaseFragment
import com.example.ibolot.ui.fragments.main.adapters.AdapterPager


class MainFragment : BaseFragment(R.layout.fragment_main) {

    private val binding by viewBinding(FragmentMainBinding::bind)
    private var imageList = mutableListOf<PagerItem>()
    private val adapter = AdapterPager(
        context = this@MainFragment,
        onItemClick = this::onItemClick,
        images = imageList
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    fun init() {
        binding.viewPager2.adapter = adapter
        binding.dotsInd.setViewPager2(binding.viewPager2)

        Log.e("ololo", "ololo")
        imageList.add(PagerItem(R.drawable.main_img.toString(), 1))
        imageList.add(PagerItem(R.drawable.main_img.toString(), 2))
        imageList.add(PagerItem(R.drawable.main_img.toString(), 3))
        imageList.add(PagerItem(R.drawable.main_img.toString(), 4))
    }

    private fun onItemClick(item: PagerItem) {

        binding.cardDoctors.setOnClickListener {
            findNavController().navigate(R.id.doctorsFragment)
        }
        binding.cardChildren.setOnClickListener {
            Toast.makeText(context, "Раздел находится в разработке", Toast.LENGTH_SHORT).show()
        }
        binding.cardAbout.setOnClickListener {
            Toast.makeText(context, "Раздел находится в разработке", Toast.LENGTH_SHORT).show()
        }
        binding.cardServices.setOnClickListener {
            findNavController().navigate(R.id.navigation_service)
        }

    }
}
