package com.example.soomgo.searchgosuFragment

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.soomgo.R
import com.example.soomgo.config.BaseFragment
import com.example.soomgo.databinding.FragmentSearchgosuBinding
import com.example.soomgo.searchgosuFragment.models.GosuListReponses
import com.example.soomgo.searchgosuRegin.SearchGosuReginActivity

class SearchgosuFragment : BaseFragment<FragmentSearchgosuBinding>(
    FragmentSearchgosuBinding::bind,
    R.layout.fragment_searchgosu
), SearchGosuView {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoadingDialog(this.context!!)
        SearchGosuService(this).tryGetGosuList()
    }

    override fun onResume() {
        super.onResume()
        binding.searchRegin.setOnClickListener {
//            startActivity(Intent(this.context, SearchGosuReginActivity::class.java))
            startActivityForResult(Intent(this.context, SearchGosuReginActivity::class.java), 0)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 0) {
            if(resultCode == RESULT_OK) {
                val data = data!!.getStringExtra("first")
                binding.searchReginService.text = data
            }
        }
    }

    override fun onReponseSearchSuccess(reponse: GosuListReponses) {
        dismissLoadingDialog()

        val list = reponse.result
        var adapter = SearchRecylerAdapter(this.context!!, list)
        binding.searchGosuRec.adapter = adapter
        binding.searchGosuRec.layoutManager =
            LinearLayoutManager(activity).also { it.orientation = LinearLayoutManager.VERTICAL }
    }

    override fun onReponseSearchFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }
}