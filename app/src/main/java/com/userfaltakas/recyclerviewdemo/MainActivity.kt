package com.userfaltakas.recyclerviewdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.userfaltakas.recyclerviewdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var adapter: MyAdapter
    lateinit var layoutManager: LinearLayoutManager

    var models = ArrayList<Model>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        getItems()




        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

                val visibleItems = layoutManager.childCount
                val pastVisibleItems = layoutManager.findFirstCompletelyVisibleItemPosition()
                val total = adapter.itemCount

                if ((visibleItems + pastVisibleItems) >= total) {
                    getItems()
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }

    private fun getItems(){
        for (i in 0..10) {
            models.add(Model("A", i))
        }
        if (::adapter.isInitialized){
            adapter.notifyDataSetChanged()
        }else{
            adapter = MyAdapter(models)
            binding.recyclerView.adapter = adapter

        }
    }
}