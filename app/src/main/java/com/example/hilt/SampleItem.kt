package com.example.hilt

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.item_sample.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SampleItem @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    @Inject
    lateinit var iMainPresent: IMainPresent
    var index = 0
    fun setData(position: Int) {
        index = position
        tx.text = position.toString()
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.item_sample, this)
        tx.setOnClickListener {
            iMainPresent.doItemWork(index)
        }

    }

}