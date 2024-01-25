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
    }

    override fun onBindViewHolder(holder: MyAdapter.Holder, position: Int) {
      holder.itemView.setOnClickListener {
          itemClick?.onClick(it, position)
      }

        // 리사이클러뷰 목룍
        holder.iconItem.setImageResource(myItems[position].Image)
        holder.itemTitle.text = myItems[position].ItemTitle
        holder.Adress.text = myItems[position].Address
        holder.itemPrice.text = myItems[position].price
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount() : Int {
        return myItems.size
    }

    inner class Holder(val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val iconItem = binding.iconItem
        val itemTitle = binding.itemTitle
        val Adress = binding.Adress
        val itemPrice = binding.itemPrice
    }

}