package com.example.carlosnorambuena_mapd721_optionalassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carlosnorambuena_mapd721_optionalassignment.Adapter.RecyclerViewAdapter
import com.example.carlosnorambuena_mapd721_optionalassignment.Model.Places

class MainActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var recyclerViewAdapter: RecyclerViewAdapter? = null
    private var placeList = mutableListOf<Places>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        placeList = ArrayList()

        recyclerView = findViewById<View>(R.id.recycler_View_Item) as RecyclerView
        recyclerViewAdapter = RecyclerViewAdapter(this@MainActivity, placeList)
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this, 2)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = recyclerViewAdapter

        preparePlacesListData()
    }

    private fun preparePlacesListData() {
        var places = Places("Casa Loma", R.drawable.casa_loma)
        placeList.add(places)

        places = Places("Other 1", R.drawable.casa_loma)
        placeList.add(places)

        places = Places("Other 2", R.drawable.casa_loma)
        placeList.add(places)

        recyclerViewAdapter!!.notifyDataSetChanged()

        //All Code is done let's run the app
    }

}