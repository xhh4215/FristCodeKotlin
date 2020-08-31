package com.example.thefristcode.jetpackproject.recycleviews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.thefristcode.jetpackproject.R

class FruitAdapter(val list: List<String>) : RecyclerView.Adapter<FruitAdapter.ViewHolder>() {


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fruitName = view.findViewById<TextView>(R.id.recycleViewItem);
    }

    /***
     * 创建viewholder的方法
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewholder = ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_recycleview_item, parent, false)
        )
        val position = viewholder.adapterPosition
        viewholder.fruitName.setOnClickListener {
            Toast.makeText(parent.context, "fruit Name", Toast.LENGTH_SHORT).show()
        }
        return viewholder
    }

    /****
     * 返回item的数据的类型 ，不同的数据使用不同的布局来展示
     */
    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    /***
     * 返回列表显示的数据的个数
     */
    override fun getItemCount() = list.size

    /***
     * viewholder和数据进行绑定的方法
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = list[position]
        holder.fruitName.text = fruit
    }


}