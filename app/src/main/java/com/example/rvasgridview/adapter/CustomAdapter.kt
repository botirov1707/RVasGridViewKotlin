package com.example.rvasgridview.adapter

import android.R
import android.content.Context

import androidx.recyclerview.widget.RecyclerView

import androidx.annotation.NonNull

import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.ImageView
import com.example.rvasgridview.model.People


class CustomAdapter(context: Context, peoples: ArrayList<People>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val context: Context
    private val peoples: ArrayList<People>
    override fun getItemCount(): Int {
        return peoples.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(com.example.rvasgridview.R.layout.item_custom_layout_view, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val people: People = peoples[position]
        if (holder is CustomViewHolder) {
            val imageView: ImageView = holder.imageView
            imageView.setImageResource(people.image)
        }
    }

    inner class CustomViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var view: View
        var imageView: ImageView

        init {
            view = v
            imageView = view.findViewById(com.example.rvasgridview.R.id.imageView)
        }
    }

    init {
        this.context = context
        this.peoples = peoples
    }
}
