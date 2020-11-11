package com.example.searchlist.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.searchlist.R
import com.example.searchlist.model.DiscoverModel
import kotlinx.android.synthetic.main.item_layout.view.*

class DiscoverAdapter(private val listDiscover: List<DiscoverModel>) : RecyclerView.Adapter<DiscoverAdapter.DiscoverViewHodel>(){

    class DiscoverViewHodel(itemView: View):RecyclerView.ViewHolder(itemView) {
        val imageView=itemView.ivProjectList
        val title=itemView.vTitle
        val address=itemView.tvProjectListAddress
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscoverViewHodel {
    val itemView=LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return DiscoverViewHodel(itemView)
    }

    override fun getItemCount(): Int = listDiscover.size

    override fun onBindViewHolder(holder: DiscoverViewHodel, position: Int) {
        val currentItem=listDiscover[position]
        holder.imageView.setImageResource(currentItem.imgUrl)
        holder.title.text=currentItem.title
        holder.address.text=currentItem.address
    }
}