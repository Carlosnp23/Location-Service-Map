package com.example.carlosnorambuena_mapd721_optionalassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.carlosnorambuena_mapd721_optionalassignment.Model.Places

class LandmarksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landmarks)

        val place = intent.getParcelableExtra<Places>(MainActivity.INTENT_PARCELABLE)

        val txtName = findViewById<TextView>(R.id.txtName)

        txtName.text = place?.title
    }
}