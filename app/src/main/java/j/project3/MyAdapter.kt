package com.android.customitemview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import j.project3.MyItem
import j.project3.databinding.ItemRecyclerviewBinding
import java.text.NumberFormat

class MyAdapter(val mItems: MutableList<MyItem>) : RecyclerView.Adapter<MyAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view : View, position : Int)
    }

    var itemClick : ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {  //클릭이벤트추가부분
            itemClick?.onClick(it, position)
        }
        holder.iconImageView.setImageResource(mItems[position].Image123)
        holder.name1.text = mItems[position].name1
        holder.name2.text = mItems[position].name2
        holder.name2.text = mItems[position].name2
        val price = mItems[position].price.toInt() // price 값을 Int로 변환
        val formattedPrice = formatPrice(price)
        holder.price1.text = formattedPrice
    }

    private fun formatPrice(price: Int): String {
        val numberFormat = NumberFormat.getNumberInstance()
        return numberFormat.format(price)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    inner class Holder(val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val iconImageView = binding.iconItem
        val name1 = binding.textName
        val name2 = binding.textname
        val price1 = binding.textprice
    }
}