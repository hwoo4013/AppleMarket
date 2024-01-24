package com.example.applemarket

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.databinding.ItemRecyclerviewBinding

class MyAdapter(val myItems: MutableList<MyItem>) : RecyclerView.Adapter<MyAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick : ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.Holder {
        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        Log.d("MyAdapter", "onCreateViewHolder()")
        return Holder(binding)
        )
    }

    override fun onBindViewHolder(holder: MyAdapter.Holder, position: Int) {
      holder.itemView.setOnClickListener {
          itemClick?.onClick(it, position)
      }
        holder.iconImageView.setImageResource(MyItem[position].)
    }


    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount() : Int {
        return myItems.size
    }

    inner class Holder(val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val iconImageView = binding.iconItem
        val
    }

}