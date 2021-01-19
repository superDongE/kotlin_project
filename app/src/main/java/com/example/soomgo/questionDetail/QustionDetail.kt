package com.example.soomgo.questionDetail


import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.soomgo.config.BaseActivity
import com.example.soomgo.databinding.ActivityQustionBinding
import com.example.soomgo.questionDetail.models.QuestionResponse
import com.example.soomgo.questionDetail.models.QuestionResponseResult
import com.example.soomgo.qustionlast.QuestionLastActivity
import com.example.soomgo.searchgosuRegin.SearchGosuReginActivity


class QustionDetail : BaseActivity<ActivityQustionBinding>(ActivityQustionBinding::inflate),
    QuestionView {

    lateinit var list: ArrayList<QuestionResponseResult>
    var percent: Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val cate: String = "5"
        showLoadingDialog(this)
        QuestionService(this).tryGetQuestion(cate)
    }

    override fun onResume() {
        super.onResume()
        binding.applyButton.setOnClickListener {
            if (percent == 2) {
                binding.progressBar2.setProgress(25)
                binding.questionTitle.text = "레슨생의 연령대는 어떻게 되나요?"
                percent++
                binding.percentQuestion.text = 25.toString()
                var adapter = QuestionAdapter1(this, list, 2)
                binding.questionDetailRecycler.adapter = adapter
                binding.questionDetailRecycler.layoutManager =
                    LinearLayoutManager(this).also { it.orientation = LinearLayoutManager.VERTICAL }
            } else if (percent == 3) {
                binding.progressBar2.setProgress(65)
                percent++
                binding.percentQuestion.text = 65.toString()
                binding.questionTitle.text = "레슨생의 성별은 무엇인가요?"
                var adapter = QuestionAdapter2(this, list, 3)
                binding.questionDetailRecycler.adapter = adapter
                binding.questionDetailRecycler.layoutManager =
                    LinearLayoutManager(this).also { it.orientation = LinearLayoutManager.VERTICAL }
            } else {
                binding.progressBar2.setProgress(99)
                percent++
                binding.questionTitle.text = "레슨을 원하는 지역을 선택해 주세요"
                var adapter = QuestionAdapter3(this, list, 4)
                binding.questionDetailRecycler.adapter = adapter
                binding.questionDetailRecycler.layoutManager =
                    LinearLayoutManager(this).also { it.orientation = LinearLayoutManager.VERTICAL }
                binding.applyTttt.visibility = View.VISIBLE
                binding.questionDetailRecycler.visibility = View.GONE
                binding.percentQuestion.text = 99.toString()
                binding.applyTttt.setOnClickListener {
                    startActivityForResult(Intent(this, SearchGosuReginActivity::class.java), 0)
                }
                binding.applyButton.setOnClickListener{
                    startActivity(Intent(this, QuestionLastActivity::class.java))
                    finish()
                }

            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 0){
            if(resultCode == RESULT_OK){
                val data = data!!.getStringExtra("first")
                binding.serachTab.text = data
                binding.serachTab.setTextColor(Color.parseColor("#000000"))
                binding.serachTab.textSize = 15F
            }
        }
    }
    override fun onQuestionSuccess(response: QuestionResponse) {
        dismissLoadingDialog()

        list = response.result
        var adapter = QuestionAdapter(this, list, 1)
        binding.questionTitle.text = "어떤 레슨을 원하시나요?"
        binding.questionDetailRecycler.adapter = adapter
        binding.questionDetailRecycler.layoutManager =
            LinearLayoutManager(this).also { it.orientation = LinearLayoutManager.VERTICAL }
        percent++
    }

    override fun onQuestionFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast(message)
    }
}
