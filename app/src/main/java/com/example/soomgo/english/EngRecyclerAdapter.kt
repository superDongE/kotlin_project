package com.example.soomgo.english

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.soomgo.R
import com.example.soomgo.english.models.EngResult
import com.example.soomgo.study.models.StudyResult
import com.example.soomgo.studydetail.StudyDetailActivity

class EngRecyclerAdapter(val context: Context, val engList: ArrayList<EngResult>) :
    RecyclerView.Adapter<EngRecyclerAdapter.ViewHolder>() {
    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val title = itemView?.findViewById<TextView>(R.id.stduy_text)
        fun bind(itemPop: StudyResult?, context: Context) {
            title?.text = itemPop?.bottomCategoryTitle
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return EngRecyclerAdapter.ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.stduy_recyle, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title?.text = engList[position].bottomCategoryTitle

        holder.itemView.setOnClickListener {
            when(position.toString()){
                "0" -> {
                    //영어과외
                    val intent = Intent(holder.itemView?.context, StudyDetailActivity::class.java)
                    intent.putExtra("api_key", "1")
                    ContextCompat.startActivity(holder.itemView.context, intent, null)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return engList.count()
    }


}