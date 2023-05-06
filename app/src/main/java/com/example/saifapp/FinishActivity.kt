package com.example.saifapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class FinishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
    }
    fun start(view: View) {
        val intent = Intent(this@FinishActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
        }
}