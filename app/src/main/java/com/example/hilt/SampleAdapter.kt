package com.example.hilt

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.qualifiers.ActivityContext
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class SampleAdapter @Inject constructor(@ActivityContext var context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    @Inject
    lateinit var users: Users

    init {
        GlobalScope.launch {
            while (true) {
                delay(2000)
                System.out.println("adapter    ${users.name}")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var sampleItem = SampleItem(context)
        var layoutParams = RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        sampleItem.layoutParams = layoutParams
        return object : RecyclerView.ViewHolder(sampleItem) {}
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder.itemView as SampleItem).setData(position)
    }

    override fun getItemCount(): Int {
        return 10
    }
}