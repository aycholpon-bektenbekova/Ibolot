package com.example.ibolot.ui.fragments.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ibolot.R
import com.example.ibolot.databinding.ItemPagerBinding
import com.example.ibolot.domain.model.PagerItem
import com.example.ibolot.ui.fragments.main.MainFragment

class AdapterPager(
    var context: MainFragment,
    private var onItemClick: (PagerItem) -> Unit,
    private var images: List<PagerItem>
) :
    RecyclerView.Adapter<AdapterPager.PagerViewHolder>() {
    inner class PagerViewHolder(private val binding: ItemPagerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: PagerItem) {
            onItemClick.invoke(item)
            Glide.with(context).load(R.drawable.main_img).into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        return PagerViewHolder(
            ItemPagerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.onBind(images[position])
    }
}