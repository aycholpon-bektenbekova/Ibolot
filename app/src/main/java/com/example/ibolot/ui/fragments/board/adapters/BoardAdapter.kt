package com.example.ibolot.ui.fragments.board.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ibolot.databinding.PagerBoardBinding

class BoardAdapter(var array : List<Unit>) : RecyclerView.Adapter<BoardAdapter.BoardViewHolder>() {

    inner class BoardViewHolder(var binding: PagerBoardBinding ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Unit) {
            binding.btnFinish.setOnClickListener {
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        return BoardViewHolder(PagerBoardBinding.inflate(LayoutInflater.from(parent.context) , parent , false))
    }

    override fun getItemCount(): Int = array.size

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.onBind(array[position])
    }
}