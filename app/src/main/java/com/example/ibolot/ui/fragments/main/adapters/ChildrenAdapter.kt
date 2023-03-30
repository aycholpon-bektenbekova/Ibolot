package com.example.ibolot.ui.fragments.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ibolot.R
import com.example.ibolot.databinding.ItemChildrenBinding
import com.example.ibolot.domain.model.ServiceItem

class ChildrenAdapter(
    var context: Fragment,
    private var onItemClick: (ServiceItem) -> Unit
) : RecyclerView.Adapter<ChildrenAdapter.ServicesViewHolder>() {

    private var views = arrayListOf<ServiceItem>()

    fun addItems(serviceItem: ServiceItem) {
        views.add(serviceItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesViewHolder {
        return ServicesViewHolder(
            ItemChildrenBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ServicesViewHolder, position: Int) {
        holder.bind(views[position])
    }

    override fun getItemCount() = views.size

    inner class ServicesViewHolder(private val binding: ItemChildrenBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ServiceItem) {
            itemView.setOnClickListener {
                onItemClick.invoke(item)
            }
            binding.tvChildren.text = item.title
            Glide.with(context).load(R.drawable.iv_children).into(binding.ivCard)
        }
    }

}