package com.example.rvasgridview.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Context

import com.example.rvasgridview.adapter.CustomAdapter

import androidx.recyclerview.widget.GridLayoutManager

import androidx.recyclerview.widget.RecyclerView
import com.example.rvasgridview.model.People


class MainActivity : AppCompatActivity() {
    private lateinit var context: Context
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.rvasgridview.R.layout.activity_main)
        initViews()
        val peoples: ArrayList<People> = preparePeopleList()
        refreshAdapter(peoples)
    }

    private fun initViews() {
        context = this
        recyclerView = findViewById(com.example.rvasgridview.R.id.recyclerView)
        recyclerView.setLayoutManager(GridLayoutManager(context, 3))
    }

    private fun refreshAdapter(fruits: ArrayList<People>) {
        val adapter = CustomAdapter(context, fruits)
        recyclerView.adapter = adapter
    }

    private fun preparePeopleList(): ArrayList<People> {
        val peoples: ArrayList<People> = ArrayList()
        var helper = 0
        for (i in 1..60) {
            if ((i + 3 - helper) % 3 == 1) {
                peoples.add(People(com.example.rvasgridview.R.drawable.img))
            } else if ((i + 3 - helper) % 3 == 2) {
                peoples.add(People(com.example.rvasgridview.R.drawable.sher))
            } else {
                peoples.add(People(com.example.rvasgridview.R.drawable.img2))
            }
            if (i % 3 == 0) helper++
        }
        return peoples
    }
}