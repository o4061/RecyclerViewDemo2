package com.userfaltakas.recyclerviewdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.userfaltakas.recyclerviewdemo.databinding.RowItemBinding

class MyAdapter(private val models: List<Model>) :
    RecyclerView.Adapter<MyAdapter.MyAdapterViewHolder>() {

    inner class MyAdapterViewHolder(val binding: RowItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapterViewHolder {
        return MyAdapterViewHolder(
            RowItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyAdapterViewHolder, position: Int) {
        val curItem = models[position]

        holder.binding.apply {
            this.textView.text = curItem.title
            this.textView2.text = curItem.num.toString()
        }
    }

    override fun getItemCount(): Int {
        return models.size
    }
}