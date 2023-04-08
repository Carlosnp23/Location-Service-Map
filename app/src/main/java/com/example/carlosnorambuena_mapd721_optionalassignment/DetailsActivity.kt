package com.example.carlosnorambuena_mapd721_optionalassignment

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        //val place = intent.getParcelableExtra<Places>(MainActivity.INTENT_PARCELABLE)
        //val txtName = findViewById<TextView>(R.id.txtName)
        //txtName.text = place?.title
        val bundle = intent
        val dato = bundle.getStringExtra("name")

        val txtName = findViewById<TextView>(R.id.textView)

        txtName.text = dato

    }
}