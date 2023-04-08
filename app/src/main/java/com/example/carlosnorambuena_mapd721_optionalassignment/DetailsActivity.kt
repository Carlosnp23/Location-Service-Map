package com.example.carlosnorambuena_mapd721_optionalassignment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class DetailsActivity : AppCompatActivity() {

    private lateinit var txtName: TextView
    private lateinit var txtDesc: TextView
    private lateinit var btnMap: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val bundle = intent
        val name = bundle.getStringExtra("name")
        val desc = bundle.getStringExtra("desc")

        txtName = findViewById(R.id.txtName)
        txtDesc = findViewById(R.id.txtDesc)
        btnMap = findViewById(R.id.btnMap)

        txtName.text = name
        txtDesc.text = desc

        btnMap.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }
    }
}