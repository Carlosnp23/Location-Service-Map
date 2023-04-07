package com.example.carlosnorambuena_mapd721_optionalassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carlosnorambuena_mapd721_optionalassignment.Adapter.ImageAdapter
import com.example.carlosnorambuena_mapd721_optionalassignment.Model.Places


class MainActivity : AppCompatActivity() {

    companion object{const val INTENT_PARCELABLE = "OBJECT_INTENT"}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageList = listOf<Places>(
            Places("Casa Loma", R.drawable .casa_loma),
            Places("Casa 1", R.drawable .casa_loma),
            Places("Casa 2", R.drawable .casa_loma),
            Places("Casa 3", R.drawable .casa_loma),
            Places("Casa 4", R.drawable .casa_loma),
        )


        val recyclerView = findViewById<RecyclerView>(R.id.recycler_View_Item)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ImageAdapter(this, imageList){
            val intent = Intent(this, LandmarksActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }

    }
}