package com.example.ibolot.ui.fragments.main.adapters
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ibolot.R
import com.example.ibolot.databinding.ViewPagerBinding
import com.example.ibolot.domain.model.ServiceItem
import com.example.ibolot.ui.fragments.main.MainFragment


class AdapterPager(var context: MainFragment, private var onItemClick: (ServiceItem) -> Unit) :
    RecyclerView.Adapter<AdapterPager.PagerViewHolder>() {


    private var views = arrayListOf<ServiceItem>()

    inner class PagerViewHolder(private val binding: ViewPagerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: ServiceItem) {
            itemView.setOnClickListener {
                onItemClick.invoke(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        return PagerViewHolder(
            ViewPagerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = views.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.onBind(views[position])
    }

}