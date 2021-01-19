package com.example.soomgo.homeFragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.soomgo.R
import com.example.soomgo.homeFragment.models.HomeChuchenData

class HomeRecyclerChuchenAdapter(val context: Context, val homeChuchenData: ArrayList<HomeChuchenData>) :
    RecyclerView.Adapter<HomeRecyclerChuchenAdapter.ViewHolder>() {

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val title = itemView?.findViewById<TextView>(R.id.home_chuchen_text)
        val img = itemView?.findViewById<ImageView>(R.id.home_chuchenimg)
        fun bind(itemPop: HomeChuchenData?, context: Context) {
            title?.text = itemPop?.name
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeRecyclerChuchenAdapter.ViewHolder {
        return HomeRecyclerChuchenAdapter.ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.layout_recycler_homechuchen, parent, false)
        )
    }

    override fun onBindViewHolder(holder: HomeRecyclerChuchenAdapter.ViewHolder, position: Int) {
        holder.title?.text = homeChuchenData[position].name
        var url = homeChuchenData[position].img
        Glide.with(holder.img!!.context).load(url).apply(
            RequestOptions.bitmapTransform(
                RoundedCorners(14)
            )).into(holder.img)

    }

    override fun getItemCount(): Int {
        return homeChuchenData.count()
    }


}