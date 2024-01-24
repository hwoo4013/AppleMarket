package com.example.applemarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applemarket.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 데이터 준비
        val dataList = mutableListOf<MyItem>()

        dataList.add(MyItem(R.drawable.sample1, "", "", "", "", ""))

        binding.recyclerView.adapter = MyAdapter(dataList)

        val adapter = MyAdapter(dataList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.itemClick = object : MyAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val name: String = dataList[position].aName
                Toast.makeText(this@MainActivity,"$name 선택!", Toast.LENGTH_SHORT)
            }
        }
    }
}