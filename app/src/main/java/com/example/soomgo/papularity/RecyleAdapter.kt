package com.example.soomgo.papularity

import android.content.Context
import android.content.Intent
import android.util.Log
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
import com.example.soomgo.papularity.models.PopuarityResult
import com.example.soomgo.studydetail.StudyDetailActivity


class RecyclerAdapter(val context: Context, val popularityList: ArrayList<PopuarityResult>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val title = itemView?.findViewById<TextView>(R.id.recye_text)
        val imageURL = itemView?.findViewById<ImageView>(R.id.recye_img)
        fun bind(itemPop: PopuarityResult?, context: Context) {
            title?.text = itemPop?.bottomCategoryTitle
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return RecyclerAdapter.ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(popularityList[position], context)
        holder.title?.text = popularityList[position].bottomCategoryTitle
        var url = popularityList[position].popularImage
        Glide.with(holder.imageURL!!.context).load(url).apply(RequestOptions.bitmapTransform(RoundedCorners(14))).into(holder.imageURL)

        holder.itemView.setOnClickListener {
            when(position.toString()){
                "3" -> {
                    val intent = Intent(holder.itemView?.context, StudyDetailActivity::class.java)
                    intent.putExtra("api_key", "5")
                    ContextCompat.startActivity(holder.itemView.context, intent, null)
                }
                "5" -> {
                    val intent = Intent(holder.itemView?.context, StudyDetailActivity::class.java)
                    intent.putExtra("api_key", "7")
                    ContextCompat.startActivity(holder.itemView.context, intent, null)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return popularityList.count()
    }


}