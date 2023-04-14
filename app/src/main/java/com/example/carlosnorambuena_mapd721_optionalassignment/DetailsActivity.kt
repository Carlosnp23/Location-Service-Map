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

        var latitude = ""
        var longitude = ""

        // Gets the data from the LandmarksActivity
        val bundle = intent
        val name = bundle.getStringExtra("name")
        val desc = bundle.getStringExtra("desc")

        txtName = findViewById(R.id.txtName)
        txtDesc = findViewById(R.id.txtDesc)
        btnMap = findViewById(R.id.btnMap)

        txtName.text = name
        txtDesc.text = desc

        // Get the corresponding coordinates
        when (txtName.text) {
            "Casa Loma" -> {
                latitude = "43.67808369380379"
                longitude = "-79.40946455181027"
            }
            "University College" -> {
                latitude = "43.66289879972133"
                longitude = "-79.39565561947617"
            }
            "Gooderham Building" -> {
                latitude = "43.64838958499782"
                longitude = "-79.37430167294382"
            }
            "Queen's Park" -> {
                latitude = "43.664338299823726"
                longitude = "-79.39231052703927"
            }
            "St. Michael's Cathedral" -> {
                latitude = "43.65494821052606"
                longitude = "-79.37734782328927"
            }
            "Royal Ontario Museum" -> {
                latitude = "43.66771646980012"
                longitude = "-79.39477777294319"
            }
            "Art Gallery of Ontario" -> {
                latitude = "43.65361098790115"
                longitude = "-79.39251330414521"
            }
            "Gardiner Museum" -> {
                latitude = "43.668100654800256"
                longitude = "-79.39315176128551"
            }
            "Spadina Museum" -> {
                latitude = "43.67898426493864"
                longitude = "-79.40824040915417"
            }
            "Ontario Science Centre" -> {
                latitude = "43.717051395079416"
                longitude = "-79.33891567355346"
            }
            "Rogers Centre" -> {
                latitude = "43.641822625456136"
                longitude = "-79.3891194181152"
            }
            "Scotiabank Arena" -> {
                latitude = "43.64347085233844"
                longitude = "-79.37909975019983"
            }
            "BMO Field" -> {
                latitude = "43.6331774590372"
                longitude = "-79.41861955515294"
            }
            "Coca-Cola Coliseum" -> {
                latitude = "43.63615595538369"
                longitude = "-79.41525138174838"
            }
            "CN Tower" -> {
                latitude = "43.642577450508874"
                longitude = "-79.38705503514532"
            }
            "Ripley's Aquarium of Canada" -> {
                latitude = "43.642187610292375"
                longitude = "-79.38659950116693"
            }
            "High Park Toronto" -> {
                latitude = "43.64655564262937"
                longitude = "-79.46368694962955"
            }
            "Toronto Zoo" -> {
                latitude = "43.82066783733963"
                longitude = "-79.18150353066314"
            }
            "Yonge-Dundas Square" -> {
                latitude = "43.656088642206974"
                longitude = "-79.38017047152505"
            }
        }

        // Button to display the Location
        btnMap.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            intent.putExtra("name", txtName.text)
            intent.putExtra("lat", latitude)
            intent.putExtra("long", longitude)
            startActivity(intent)
        }
    }
}