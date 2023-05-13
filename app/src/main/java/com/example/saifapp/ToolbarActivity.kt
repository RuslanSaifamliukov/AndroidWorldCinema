package com.example.saifapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ToolbarActivity : AppCompatActivity() {

    lateinit var preff: SharedPreferences
    lateinit var name: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)
        name = findViewById(R.id.textACC)
        val poster_res:RecyclerView=findViewById((R.id.rec_view))
        poster_res.adapter = Poster_adapter(this, PosterList().list)
        val actor_res:RecyclerView=findViewById((R.id.rec_view2))
        actor_res.adapter = ActorAdapter(this, ActorList().list2)
        preff = getSharedPreferences("TABLEE", MODE_PRIVATE)
        name.setText(preff?.getString("key1", ""))
    }

    fun start(view: View) {
        val intent = Intent(this@ToolbarActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
        }
}