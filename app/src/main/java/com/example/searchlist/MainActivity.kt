package com.example.searchlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.searchlist.Adapter.DiscoverAdapter
import com.example.searchlist.model.DiscoverModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val list= mutableListOf<DiscoverModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayList()
        searchView()
    }

    private fun displayList() {
        for(i in 0 until 10){
            list.add(DiscoverModel(i,R.drawable.discover,"Cầu Sông Hàn Đà Nẵng","Khi nhắc đến Đà Nẵng, chúng ta không thể không nhắc đến dòng sông Hàn rộng lớn và vô cùng thơ mộng"))
        }
        rv_discover.adapter=DiscoverAdapter(list)
        rv_discover.layoutManager=LinearLayoutManager(this)
        rv_discover.setHasFixedSize(true)
    }

    private fun searchView() {
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if(query.isNullOrEmpty()){
                    showSearchData(mutableListOf())
                }else{
                    showSearchData(getListDataSearch(query))
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if(newText.isNullOrEmpty()){
                    showSearchData(mutableListOf())
                }else{
                    showSearchData(getListDataSearch(newText))
                }
                return true
            }
        })
    }

    private fun getListDataSearch(query: String): MutableList<DiscoverModel> {
        val listFilter = list.filter {
           it.title.contains(query, true)
        }
        return listFilter.toMutableList()
    }

    private fun showSearchData(mutableListOf: MutableList<DiscoverModel>) {
        list.clear()
        if(mutableListOf.isNotEmpty()){
            list.addAll(mutableListOf)
        }
        rv_discover.adapter=DiscoverAdapter(list)
        rv_discover.adapter?.notifyDataSetChanged()
    }
}