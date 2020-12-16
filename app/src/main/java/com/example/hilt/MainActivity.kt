package com.example.hilt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var sampleAdapter: SampleAdapter

    @Inject
    lateinit var users: Users

    @Inject
    lateinit var iMainPresent: IMainPresent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        with(list) {
            adapter = sampleAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        GlobalScope.launch {
            while (true) {
                delay(2000)
                System.out.println("activity     ${users.name}")
            }
        }
        GlobalScope.launch {
            delay(3000)
            users.name = "kotlin"
        }
        iMainPresent.doMainWork()
    }


}