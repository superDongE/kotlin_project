package com.example.soomgo.reciverFragment

import android.content.Context
import android.util.Log
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
import com.example.soomgo.reciverFragment.models.ReciverResult

class RecevieAdapter(val context: Context, val reciverList: ArrayList<ReciverResult>) :
    RecyclerView.Adapter<RecevieAdapter.ViewHolder>() {
    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val imageUrl = itemView!!.findViewById<ImageView>(R.id.recive_item_image)
        val daytitle = itemView!!.findViewById<TextView>(R.id.recive_item_day)
        fun bind(itemPop: ReciverResult?, context: Context) {
//            title?.text = itemPop?.bottomCategoryTitle
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return RecevieAdapter.ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.recevie_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imgurl : String = reciverList[position].profileImage
        val test : String =reciverList[position].dateTime
        holder.daytitle?.text = reciverList[position].dateTime.toString()
        Glide.with(holder.itemView.context).load(imgurl).apply(RequestOptions.bitmapTransform(RoundedCorners(18))).into(holder.imageUrl)


    }

    override fun getItemCount(): Int = 1
}