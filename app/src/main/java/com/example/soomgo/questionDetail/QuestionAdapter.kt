package com.example.soomgo.questionDetail

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.soomgo.R
import com.example.soomgo.questionDetail.models.QuestionResponseResult
import com.example.soomgo.study.models.StudyResult

class QuestionAdapter(val context: Context, val studyList: ArrayList<QuestionResponseResult>, val apply: Int) :
    RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {
    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val title = itemView?.findViewById<TextView>(R.id.apply_questuin)
        val img = itemView?.findViewById<ImageView>(R.id.apply_img)
        val imgBtn = itemView?.findViewById<Button>(R.id.apply_button)
        val titledetail = itemView?.findViewById<TextView>(R.id.apply_questuin)
        fun bind(itemPop: QuestionResponseResult?, context: Context) {
            title?.text = itemPop?.choice
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return QuestionAdapter.ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.question_listview, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            holder.title?.text = studyList[position].choice

        holder.itemView.setOnClickListener {
            when(position.toString()){
                "0" -> {
//                   리스트 아이템 클릭시
                    holder.img?.setImageResource(R.drawable.applu_q2)
                    holder.imgBtn?.setBackgroundColor(ContextCompat.getColor(context, R.color.success))
                    holder.titledetail?.setTextColor(Color.parseColor("#00c7ae"))

                }
            }
        }
    }

    override fun getItemCount(): Int = 5
//    {
//        return studyList.count()
//    }


}