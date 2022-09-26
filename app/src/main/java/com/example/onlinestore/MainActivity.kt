package com.example.onlinestore

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinestore.Model.productDetail
import com.example.onlinestore.Presentation.productDetailAdapter
import com.example.onlinestore.Presentation.productDetailState
import com.example.onlinestore.Presentation.productDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewModel by viewModels<productDetailViewModel>()
    private var mRecyclerView : RecyclerView ?= null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val data : List<productDetail>
        if(viewModel.getState().value == null)
            data = emptyList()
        else
            data = viewModel.getState().value?.data!!
        var adapter = productDetailAdapter(data,this)
        mRecyclerView = findViewById(R.id.recyclerView)
        mRecyclerView?.adapter = adapter
        mRecyclerView?.layoutManager = LinearLayoutManager(this)
    }
}