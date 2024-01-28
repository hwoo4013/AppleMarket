package com.example.applemarket

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // MyItem 정보 가져오기
        val myItem = intent.getParcelableExtra<MyItem>("EXTRA_MY_ITEM")


    }
}