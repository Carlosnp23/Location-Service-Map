package com.example.carlosnorambuena_mapd721_optionalassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carlosnorambuena_mapd721_optionalassignment.Adapter.LocationAdapter
import com.example.carlosnorambuena_mapd721_optionalassignment.Model.Location
import java.util.*
import kotlin.collections.ArrayList

class LandmarksActivity : AppCompatActivity(), LocationAdapter.MyClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var locationList = ArrayList<Location>()
    private lateinit var adapter: LocationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landmarks)

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        addDataToList()
        adapter = LocationAdapter(locationList, this@LandmarksActivity)
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })
    }

    private fun filterList(query: String?) {

        if (query != null) {
            val filteredList = ArrayList<Location>()
            for (i in locationList) {
                if (i.title.uppercase(Locale.ROOT).contains(query) ||
                    i.title.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)

                    //Log.d("TAG", "message")
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(this, "No Data found", Toast.LENGTH_SHORT).show()
            } else {
                adapter.setFilteredList(filteredList)
                Toast.makeText(this, "Data found", Toast.LENGTH_SHORT).show()

            }
        }
    }

    private fun addDataToList() {
        locationList.add(
            Location(
                "Casa Loma",
                R.drawable.casa_loma,
                "A prime example of modern Toronto’s commitment to its rich history ..."
            )
        )

        locationList.add(
            Location(
                "Loma",
                R.drawable.casa_loma,
                "A prime example of modern."
            )
        )
    }

    override fun onClick(position: Int) {
        when(position) {
            0 -> {
                Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, DetailsActivity::class.java)
                intent.putExtra("name", "Casa Loma")
                intent.putExtra("desc", "A prime example of modern Toronto’s commitment to its " +
                        "rich history, Casa Loma was first built in 1914 by financier " +
                        "Sir Henry Pellatt. The castle located in midtown Toronto, is now " +
                        "owned by the City of Toronto and is regarded as a treasured heritage " +
                        "landmark. Today, Casa Loma is one of Toronto’s top tourist attractions " +
                        "and hospitality venues.")
                startActivity(intent)
            }
            1 -> {
                Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, DetailsActivity::class.java)
                intent.putExtra("name", "Loma")
                intent.putExtra("desc", "A prime example of modern Toronto’s commitment to its " +
                        "rich history...")
                startActivity(intent)
            }
        }
    }
}