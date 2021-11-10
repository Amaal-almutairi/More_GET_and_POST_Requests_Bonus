package com.example.more_get_and_post_requests_bonus

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.more_get_and_post_requests_bonus.databinding.ItemRowBinding


    class MyAdap  (val names: ArrayList<String>): RecyclerView.Adapter<MyAdap.Holder>(){
        class Holder (val binding: ItemRowBinding): RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            return Holder(ItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
        }
        override fun onBindViewHolder(holder: Holder, position: Int) {
            var name = names[position]
            holder.binding.apply {
                tvRV.text = name
            }
        }

        override fun getItemCount() = names.size

    }
