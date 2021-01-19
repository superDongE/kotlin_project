package com.example.soomgo.searchgosuFragment

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.soomgo.R
import com.example.soomgo.searchgosuFragment.models.GosuListResult
import com.example.soomgo.searchgosudetail.SearchGosuDtail
import com.example.soomgo.study.models.StudyResult

class SearchRecylerAdapter(val context: Context, val searchList: ArrayList<GosuListResult>) :
    RecyclerView.Adapter<SearchRecylerAdapter.ViewHolder>() {
    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val profile = itemView?.findViewById<ImageView>(R.id.gosu_profile_img)
        val gosuName = itemView?.findViewById<TextView>(R.id.gosu_id)
        val gosuOnLine = itemView?.findViewById<TextView>(R.id.gosu_onelinetext)
        fun bind(itemPop: StudyResult?, context: Context) {
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchRecylerAdapter.ViewHolder {
        return SearchRecylerAdapter.ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.gosulist_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SearchRecylerAdapter.ViewHolder, position: Int) {
        var url = searchList[position].profileImage
        Glide.with(holder.profile!!.context).load(url).apply(
            RequestOptions.bitmapTransform(
                RoundedCorners(24)
            )
        )
            .into(holder.profile)
        holder.gosuName?.text = searchList[position].userName
        holder.gosuOnLine?.text = searchList[position].oneLineDescription

        holder.itemView.setOnClickListener {
            when(position.toString()){
                "0" -> {
                    val intent = Intent(holder.itemView?.context, SearchGosuDtail::class.java)
                    intent.putExtra("api_key", "1")
                    ContextCompat.startActivity(holder.itemView.context, intent, null)
                }
                "1"-> {
                    val intent = Intent(holder.itemView?.context, SearchGosuDtail::class.java)
                    intent.putExtra("api_key", "2")
                    ContextCompat.startActivity(holder.itemView.context, intent, null)
                }
                "2" -> {
                    val intent = Intent(holder.itemView?.context, SearchGosuDtail::class.java)
                    intent.putExtra("api_key", "3")
                    ContextCompat.startActivity(holder.itemView.context, intent, null)
                }
                "3" -> {
                    val intent = Intent(holder.itemView?.context, SearchGosuDtail::class.java)
                    intent.putExtra("api_key", "4")
                    ContextCompat.startActivity(holder.itemView.context, intent, null)
                }
                "4" -> {
                    val intent = Intent(holder.itemView?.context, SearchGosuDtail::class.java)
                    intent.putExtra("api_key", "5")
                    ContextCompat.startActivity(holder.itemView.context, intent, null)
                }
                "5" -> {
                    val intent = Intent(holder.itemView?.context, SearchGosuDtail::class.java)
                    intent.putExtra("api_key", "6")
                    ContextCompat.startActivity(holder.itemView.context, intent, null)
                }
                "6" -> {
                    val intent = Intent(holder.itemView?.context, SearchGosuDtail::class.java)
                    intent.putExtra("api_key", "7")
                    ContextCompat.startActivity(holder.itemView.context, intent, null)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return searchList.count()
    }

}

