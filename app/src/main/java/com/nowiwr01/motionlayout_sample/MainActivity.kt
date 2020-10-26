package com.nowiwr01.motionlayout_sample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nowiwr01.motionlayout_sample.tinder.TinderActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tinder.setOnClickListener {
            startActivity(Intent(this, TinderActivity::class.java))
        }
    }
}