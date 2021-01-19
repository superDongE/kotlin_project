package com.example.soomgo.homeFragment

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.soomgo.R
import com.example.soomgo.homeFragment.models.HomeServiceData


class HomeRecyclerAdapter(val context: Context, val homeServiceData: ArrayList<HomeServiceData>) :
    RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val title = itemView?.findViewById<TextView>(R.id.home_item_title)
        val img = itemView?.findViewById<ImageView>(R.id.home_item_img)
        fun bind(itemPop: HomeServiceData?, context: Context) {
            title?.text = itemPop?.name
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeRecyclerAdapter.ViewHolder {
        return HomeRecyclerAdapter.ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_home_recyler, parent, false)
        )
    }

    override fun onBindViewHolder(holder: HomeRecyclerAdapter.ViewHolder, position: Int) {
        holder.title?.text = homeServiceData[position].name
        holder.img?.background = holder.itemView.context.resources.getDrawable(R.drawable.itme_recyle_corner, null)
        holder.img?.clipToOutline = true
        holder.img?.setImageResource(homeServiceData[position].getImageId(context))
    }

    override fun getItemCount(): Int {
        return homeServiceData.count()
    }


}