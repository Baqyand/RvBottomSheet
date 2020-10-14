package com.baqynra.withbaqyand.rvbottomsheet.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.RecyclerView
import com.baqynra.withbaqyand.rvbottomsheet.R
import com.baqynra.withbaqyand.rvbottomsheet.model.Laptop
import kotlinx.android.synthetic.main.item_laptop.view.*

class ListlaptopAdapter(private val contex : Context): RecyclerView.Adapter<ListlaptopAdapter.LaptopViewHolder>() {
    private val dataArray= ArrayList<Laptop>()

    fun addData(data:MutableList<Laptop>){
        dataArray.addAll(data)
        notifyDataSetChanged()
    }
    fun initData(data:MutableList<Laptop>){
        dataArray.clear()
        dataArray.addAll(data)
        notifyDataSetChanged()
    }

    fun clearData(){
        dataArray.clear()
        notifyDataSetChanged()
    }

    fun subtractData(){
        dataArray.removeAt(dataArray.size-1)
        notifyDataSetChanged()
    }



    inner class LaptopViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val foto= itemView.img_laptop
        val name: TextView = itemView.tv_nama
        val harga = itemView.tv_Harga
        val detail = itemView.tv_detail
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaptopViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_laptop, parent, false)
        return LaptopViewHolder(view)
    }

    override fun onBindViewHolder(holder: LaptopViewHolder, position: Int) {
        holder.foto.setImageResource(dataArray[position].photo)
        holder.name.text = dataArray[position].nama
        holder.harga.text = dataArray[position].harga
        holder.detail.text = dataArray[position].detail
        holder.foto.setOnClickListener {
          val data = Intent("Data Ketrigger")
          data.putExtra("photo", dataArray[position].photo)
          data.putExtra("Nama", dataArray[position].nama)
          data.putExtra("Detail", dataArray[position].detail)
          data.putExtra("Harga", dataArray[position].harga)
          LocalBroadcastManager.getInstance(contex).sendBroadcast(data)
        }

    }

    override fun getItemCount(): Int {
        return dataArray.size
    }


}