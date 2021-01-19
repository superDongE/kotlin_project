package com.example.soomgo.searchgosuRegin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.Toast
import com.example.soomgo.R
import com.example.soomgo.config.BaseActivity
import com.example.soomgo.databinding.ActivitySearchgosureginBinding
import com.example.soomgo.searchgosuRegin.ExpandableListData.data


class SearchGosuReginActivity : BaseActivity<ActivitySearchgosureginBinding>(
    ActivitySearchgosureginBinding::inflate
) {
    private var expandableListView: ExpandableListView? = null
    private var adapter: ExpandableListAdapter? = null
    private var titleList: List<String>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onResume() {
        super.onResume()
        var v1: String = ""
        var v2: String = ""
        expandableListView = findViewById(R.id.expendableList)
        if (expandableListView != null) {
            val listData = data
            titleList = ArrayList(listData.keys)
            adapter = CustomExpandableListAdapter(this, titleList as ArrayList<String>, listData)
            expandableListView!!.setAdapter(adapter)
            expandableListView!!.setOnGroupExpandListener { groupPosition ->
//                Toast.makeText(
//                    applicationContext,
//                    (titleList as ArrayList<String>)[groupPosition] + " List Expanded.",
//                    Toast.LENGTH_SHORT
//                ).show()

            }
            expandableListView!!.setOnGroupCollapseListener { groupPosition ->
//                Toast.makeText(
//                    applicationContext,
//                    (titleList as ArrayList<String>)[groupPosition] + " List Collapsed.",
//                    Toast.LENGTH_SHORT
//                ).show()
                v1 = "서울"


            }
            expandableListView!!.setOnChildClickListener { _, _, groupPosition, childPosition, _ ->
//                Toast.makeText(
//                    applicationContext,
//                    "Clicked: " + (titleList as ArrayList<String>)[groupPosition] + " -> " + listData[(
//                            titleList as
//                                    ArrayList<String>
//                            )
//                            [groupPosition]]!!.get(
//                        childPosition
//                    ),
//                    Toast.LENGTH_SHORT
//                ).show()
                v2 = "강남구"
                val intent = Intent()
                intent.putExtra("first", "서울 강남구 개포 1동")
//        intent.putExtra("scond", "$v2")
                setResult(RESULT_OK, intent)
                finish()


                false
            }

            binding.reginX.setOnClickListener {
                finish()
            }
        }


    }
}