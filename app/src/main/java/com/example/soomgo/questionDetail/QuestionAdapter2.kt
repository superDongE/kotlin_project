package com.example.soomgo.questionDetail

import android.content.Context
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

class QuestionAdapter2(val context: Context, val studyList: ArrayList<QuestionResponseResult>, val apply: Int) :
    RecyclerView.Adapter<QuestionAdapter2.ViewHolder>() {
    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val title = itemView?.findViewById<TextView>(R.id.apply_questuin)
        val img = itemView?.findViewById<ImageView>(R.id.apply_img)
        val title1 = itemView?.findViewById<TextView>(R.id.question_title)
        val imgBtn = itemView?.findViewById<Button>(R.id.apply_button)
        fun bind(itemPop: QuestionResponseResult?, context: Context) {
            title?.text = itemPop?.choice
            title1?.text = itemPop?.question
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return QuestionAdapter2.ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.question_listview, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.title?.text = studyList[position+9].choice

        holder.itemView.setOnClickListener {
            when(position.toString()){
                "0" -> {
//                   리스트 아이템 클릭시
                    holder.img?.setImageResource(R.drawable.applu_q2)
                    holder.imgBtn?.setBackgroundColor(ContextCompat.getColor(this!!.context, R.color.success))

                }
            }
        }
    }

    override fun getItemCount(): Int = 2
//    {
//        return studyList.count()
//    }


}