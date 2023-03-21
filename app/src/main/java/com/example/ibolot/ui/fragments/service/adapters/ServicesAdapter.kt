package com.example.ibolot.ui.fragments.service.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ibolot.databinding.ItemServicesBinding
import com.example.ibolot.domain.model.ServiceItem
import com.example.ibolot.ui.fragments.service.ServiceFragment

class ServicesAdapter(
    var context: ServiceFragment,
    private var onItemClick: (ServiceItem) -> Unit
        ) : RecyclerView.Adapter<ServicesAdapter.ServicesViewHolder>() {

    private var views = arrayListOf<ServiceItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesViewHolder {
        return ServicesViewHolder(
            ItemServicesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ServicesViewHolder, position: Int) {
        holder.bind(views[position])
    }

    override fun getItemCount() = views.size

    inner class ServicesViewHolder(private val binding: ItemServicesBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ServiceItem) {
            itemView.setOnClickListener {
                onItemClick.invoke(item)
            }
            binding.tvServices.text = item.title
            Glide.with(context).load(item.image).into(binding.imgServices)
        }
    }

}