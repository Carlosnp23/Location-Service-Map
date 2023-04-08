package com.example.carlosnorambuena_mapd721_optionalassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carlosnorambuena_mapd721_optionalassignment.Adapter.ImageAdapter
import com.example.carlosnorambuena_mapd721_optionalassignment.Model.Places


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var titleToolbar: TextView

    companion object{const val INTENT_PARCELABLE = "OBJECT_INTENT"}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageList = listOf<Places>(
            Places("Suggested locations", R.drawable.toronto),
            Places("Historic Old Buildings", R.drawable.historic_old_buildings),
            Places("Museums", R.drawable.royal_ontario_museum),
            Places("Stadiums", R.drawable.casa_loma),
            Places("Attractions", R.drawable.toronto)
        )

        titleToolbar = findViewById(R.id.toolbar_title);
        titleToolbar.text ="City of Toronto"

        recyclerView = findViewById(R.id.recycler_View_Item)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ImageAdapter(this, imageList){
            val intent = Intent(this, LandmarksActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }

    }
}