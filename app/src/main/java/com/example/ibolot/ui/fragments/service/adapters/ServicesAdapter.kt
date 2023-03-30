package com.example.ibolot.ui.fragments.service.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ibolot.R
import com.example.ibolot.databinding.ItemServicesBinding
import com.example.ibolot.domain.model.ServiceItem

class ServicesAdapter(
    var context: Fragment,
    private var onItemClick: (ServiceItem) -> Unit
        ) : RecyclerView.Adapter<ServicesAdapter.ServicesViewHolder>() {

    private var views = arrayListOf<ServiceItem>()

    fun addItems(serviceItem: ServiceItem){
        views.add(serviceItem)
    }

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
            Glide.with(context).load(R.drawable.orthopedics).into(binding.imgServices)
        }
    }

}