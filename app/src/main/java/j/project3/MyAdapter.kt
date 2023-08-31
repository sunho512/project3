package com.android.customitemview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import j.project3.MyItem
import j.project3.databinding.ItemPageBinding
import java.text.NumberFormat

class MyAdapter(val mItems: MutableList<MyItem>) : RecyclerView.Adapter<MyAdapter.Holder>() {
    interface ItemClick {
        fun onClick(view: View, position: Int)
    }
    var itemClick: ItemClick? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            ItemPageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }
        holder.iconImageView.setImageResource(mItems[position].Image123)
        holder.name1.text = mItems[position].name1
        holder.name2.text = mItems[position].name2
        holder.name2.text = mItems[position].name2
        val price = mItems[position].price.toInt()
        val formattedPrice = formatPrice(price)
        holder.price1.text = formattedPrice

        val heart = mItems[position].heart.toInt()
        val formattedheart = formatheart(heart)
        holder.heart1.text = formattedheart

        val chat = mItems[position].chat.toInt()
        val formattedchat = formatchat(chat)
        holder.heart1.text = formattedchat
    }

    private fun formatPrice(price: Int): String {
        val pricenumber = NumberFormat.getNumberInstance()
        return "${pricenumber.format(price)}원"
    }
    private fun formatheart(heart: Int): String {
        val heartnumber = NumberFormat.getNumberInstance()
        return heartnumber.format(heart)
    }
    private fun formatchat(chat: Int): String {
        val chatnumber = NumberFormat.getNumberInstance()
        return chatnumber.format(chat)
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    inner class Holder(val binding: ItemPageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val iconImageView = binding.iconItem
        val name1 = binding.textName
        val name2 = binding.textname
        val price1 = binding.textprice
        val heart1 = binding.hearttext
        val chat1 = binding.chatimg
    }
}