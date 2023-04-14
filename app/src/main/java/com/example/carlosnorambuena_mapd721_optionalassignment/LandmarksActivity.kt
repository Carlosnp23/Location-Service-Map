package com.example.carlosnorambuena_mapd721_optionalassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carlosnorambuena_mapd721_optionalassignment.Adapter.LocationAdapter
import com.example.carlosnorambuena_mapd721_optionalassignment.Model.Location
import com.example.carlosnorambuena_mapd721_optionalassignment.Model.Places
import java.util.*
import kotlin.collections.ArrayList

class LandmarksActivity : AppCompatActivity(), LocationAdapter.MyClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var locationList = ArrayList<Location>()
    private lateinit var adapter: LocationAdapter
    private lateinit var titleToolbar: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landmarks)

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        val place: Places = intent.getParcelableExtra(MainActivity.INTENT_PARCELABLE)!!
        titleToolbar = findViewById(R.id.toolbar_title);
        titleToolbar.text = place.title

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        when (titleToolbar.text) {
            "Suggested locations" -> {
                addDataToListSuggested()
            }
            "Historic Old Buildings" -> {
                addDataToListHistoric()
            }
            "Museums" -> {
                addDataToListMuseums()
            }
            "Stadiums" -> {
                addDataToListStadiums()
            }
            "Attractions" -> {
                addDataToListAttractions()
            }
        }

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
                    i.title.lowercase(Locale.ROOT).contains(query)
                ) {
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

    //Action to go to the Details Screen
    override fun onClick(position: Int) {
        when (titleToolbar.text) {
            "Suggested locations" -> {
                when (position) {
                    0 -> {
                        Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("name", "Casa Loma")
                        intent.putExtra(
                            "desc", "A prime example of modern Toronto’s commitment to its " +
                                    "rich history, Casa Loma was first built in 1914 by financier " +
                                    "Sir Henry Pellatt. The castle located in midtown Toronto, is now " +
                                    "owned by the City of Toronto and is regarded as a treasured heritage " +
                                    "landmark. Today, Casa Loma is one of Toronto’s top tourist attractions " +
                                    "and hospitality venues."
                        )
                        startActivity(intent)
                    }
                    1 -> {
                        Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("name", "University College")
                        intent.putExtra(
                            "desc", "University College, popularly referred to as UC, is a " +
                                    "constituent college of the University of Toronto, created in 1853 specifically as an " +
                                    "institution of higher learning free of religious affiliation. University College is one " +
                                    "of two places in the University of Toronto that has been designated a National Historic " +
                                    "Site of Canada, along with Annesley Hall of Victoria College. It is home to the oldest " +
                                    "student government in Canada, the Literary and Athletic Society."
                        )
                        startActivity(intent)
                    }
                    2 -> {
                        Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("name", "Queen's Park")
                        intent.putExtra(
                            "desc",
                            "Queen's park is located just a couple of blocks south of the trendy " +
                                    "neighbourhood of Yorkville. In addition to being the home of the Ontario Legislative Assembly, " +
                                    "Queens Park features several commemorative statues including one of Edward VII who opened the park " +
                                    "in 1860. There is also a war memorial."
                        )
                        startActivity(intent)
                    }
                    3 -> {
                        Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("name", "Royal Ontario Museum")
                        intent.putExtra(
                            "desc", "The Royal Ontario Museum is a museum of art, " +
                                    "world culture and natural history in Toronto, Ontario, Canada. It is one of " +
                                    "the largest museums in North America and the largest in Canada. It attracts " +
                                    "more than one million visitors every year, making the ROM the most-visited " +
                                    "museum in Canada."
                        )
                        startActivity(intent)
                    }
                    4 -> {
                        Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("name", "Ontario Science Centre")
                        intent.putExtra(
                            "desc",
                            "Planning for the Science Centre started in 1961 during Toronto's massive expansion of " +
                                    "the late 1950s and 1960s. In 1964, Toronto architect Raymond Moriyama was hired to design the site. " +
                                    "Construction started in 1966 with plans to open the Centennial Centre of Science and Technology as part of " +
                                    "the Canadian Centennial celebrations in 1967.However, construction was not completed in 1967, and the " +
                                    "Science Centre did not open to the public until two years later, on September 26, 1969."
                        )
                        startActivity(intent)
                    }
                    5 -> {
                        Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("name", "Rogers Centre")
                        intent.putExtra(
                            "desc",
                            "Opened in 1989 on the former Railway Lands, it is home to the Toronto " +
                                    "Blue Jays of Major League Baseball (MLB). Previously, the stadium was also home to " +
                                    "the Toronto Argonauts of the Canadian Football League (CFL) and the Toronto Raptors of " +
                                    "the National Basketball Association (NBA). The Buffalo Bills of the National Football " +
                                    "League (NFL) played an annual game at the stadium as part of the Bills Toronto Series from " +
                                    "2008 to 2013."
                        )
                        startActivity(intent)
                    }
                    6 -> {
                        Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("name", "Scotiabank Arena")
                        intent.putExtra(
                            "desc",
                            "It is the home of the Toronto Raptors of the National Basketball Association (NBA) " +
                                    "and the Toronto Maple Leafs of the National Hockey League (NHL). In addition, the minor league " +
                                    "Toronto Marlies of the American Hockey League (AHL) and the Raptors 905 of the NBA G League play " +
                                    "occasional games at the arena. The arena was previously home to the Toronto Phantoms of the Arena " +
                                    "Football League (AFL) and the Toronto Rock of the National Lacrosse League. Scotiabank Arena also " +
                                    "hosts other events, such as concerts, political conventions and video game competitions."
                        )
                        startActivity(intent)
                    }
                    7 -> {
                        Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("name", "Coca-Cola Coliseum")
                        intent.putExtra(
                            "desc",
                            "Coca-Cola Coliseum (also or formerly known as CNE Coliseum, Royal Coliseum, Ricoh Coliseum, " +
                                    "Toronto Coliseum or Coliseum) is an arena at Exhibition Place in Toronto, Ontario, Canada, used for agricultural " +
                                    "displays, ice hockey, and trade shows. It was built for the Canadian National Exhibition (CNE) and the Royal " +
                                    "Agricultural Winter Fair (the Royal) in 1921. Since 1997 it has been part of the Enercare Centre exhibition complex. " +
                                    "It serves as the home arena of the Toronto Marlies ice hockey team, the American Hockey League farm team of the Toronto " +
                                    "Maple Leafs. For the 2015 Pan American Games the venue hosted the gymnastics competitions and was known as the Toronto " +
                                    "Coliseum."
                        )
                        startActivity(intent)
                    }
                    8 -> {
                        Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("name", "CN Tower")
                        intent.putExtra(
                            "desc",
                            "The CN Tower (French: Tour CN) is a 553.3 m-high (1,815.3 ft) concrete communications and observation tower in " +
                                    "downtown Toronto, Ontario, Canada. Built on the former Railway Lands, it was completed in 1976. Its name CN " +
                                    "referred to Canadian National, the railway company that built the tower. Following the railway's decision to divest " +
                                    "non-core freight railway assets prior to the company's privatization in 1995, it transferred the tower to the Canada " +
                                    "Lands Company, a federal Crown corporation responsible for real estate development."
                        )
                        startActivity(intent)
                    }
                    9 -> {
                        Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("name", "Ripley's Aquarium of Canada")
                        intent.putExtra(
                            "desc",
                            "Ripley's Aquarium of Canada is a public aquarium in Toronto, Ontario, Canada. The aquarium is one of three aquariums " +
                                    "owned-and-operated by Ripley Entertainment. It is located in downtown Toronto, just southeast of the CN Tower. " +
                                    "The aquarium has 5.7 million litres (1.25 million gallons) of marine and freshwater habitats from across the world. " +
                                    "The exhibits hold more than 20,000 exotic sea and freshwater specimens from more than 450 species."
                        )
                        startActivity(intent)
                    }
                    10 -> {
                        Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("name", "Toronto Zoo")
                        intent.putExtra(
                            "desc",
                            "The Toronto Zoo is a zoo located in Toronto, Ontario, Canada. Encompassing 287 hectares (710 acres), the Toronto Zoo " +
                                    "is the largest zoo in Canada. It is divided into seven zoogeographic regions: Indo-Malaya, Africa, Americas, " +
                                    "Tundra Trek, Australasia, Eurasia, and the Canadian Domain. Some animals are displayed indoors in pavilions and " +
                                    "outdoors in what would be their naturalistic environments, with viewing at many levels. It also has areas such as " +
                                    "the Kids Zoo, Waterside Theatre, and Splash Island."
                        )
                        startActivity(intent)
                    }
                }
            }
            "Historic Old Buildings" -> {
                when (position) {
                    0 -> {
                        Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("name", "Casa Loma")
                        intent.putExtra(
                            "desc", "A prime example of modern Toronto’s commitment to its " +
                                    "rich history, Casa Loma was first built in 1914 by financier " +
                                    "Sir Henry Pellatt. The castle located in midtown Toronto, is now " +
                                    "owned by the City of Toronto and is regarded as a treasured heritage " +
                                    "landmark. Today, Casa Loma is one of Toronto’s top tourist attractions " +
                                    "and hospitality venues."
                        )
                        startActivity(intent)
                    }
                    1 -> {
                        Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("name", "University College")
                        intent.putExtra(
                            "desc", "University College, popularly referred to as UC, is a " +
                                    "constituent college of the University of Toronto, created in 1853 specifically as an " +
                                    "institution of higher learning free of religious affiliation. University College is one " +
                                    "of two places in the University of Toronto that has been designated a National Historic " +
                                    "Site of Canada, along with Annesley Hall of Victoria College. It is home to the oldest " +
                                    "student government in Canada, the Literary and Athletic Society."
                        )
                        startActivity(intent)
                    }
                    2 -> {
                        Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("name", "Gooderham Building")
                        intent.putExtra(
                            "desc",
                            "The Gooderham Building is the focal point of one of Toronto's " +
                                    "most iconic vistas: looking west down Front Street towards the building's prominent rounded " +
                                    "corner, framed on the sides by the heritage commercial blocks along Front Street, and with the " +
                                    "skyscrapers of the Financial District towering in the background."
                        )
                        startActivity(intent)
                    }
                    3 -> {
                        Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("name", "Queen's Park")
                        intent.putExtra(
                            "desc",
                            "Queen's park is located just a couple of blocks south of the trendy " +
                                    "neighbourhood of Yorkville. In addition to being the home of the Ontario Legislative Assembly, " +
                                    "Queens Park features several commemorative statues including one of Edward VII who opened the park " +
                                    "in 1860. There is also a war memorial."
                        )
                        startActivity(intent)
                    }
                    4 -> {
                        Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("name", "St. Michael's Cathedral")
                        intent.putExtra(
                            "desc",
                            "St. Michael's Cathedral is a major building of faith in downtown Toronto. " +
                                    "It was originally constructed away from the city's centre, but over time the city has grown to encompass it. " +
                                    "It was constructed to better serve the growing Roman Catholic population of Toronto. It is a prime example " +
                                    "of the English Gothic Revival style of architecture."
                        )
                        startActivity(intent)
                    }
                }
            }
            "Museums" -> {
                when (position) {
                    0 -> {
                        Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("name", "Royal Ontario Museum")
                        intent.putExtra(
                            "desc", "The Royal Ontario Museum is a museum of art, " +
                                    "world culture and natural history in Toronto, Ontario, Canada. It is one of " +
                                    "the largest museums in North America and the largest in Canada. It attracts " +
                                    "more than one million visitors every year, making the ROM the most-visited " +
                                    "museum in Canada."
                        )
                        startActivity(intent)
                    }
                    1 -> {
                        Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("name", "Art Gallery of Ontario")
                        intent.putExtra(
                            "desc",
                            "It was established in 1900 as the Art Museum of Toronto, and " +
                                    "formally incorporated in 1903, it was renamed the Art Gallery of Toronto in 1919, " +
                                    "before it adopted its present name, the Art Gallery of Ontario, in 1966. The museum " +
                                    "acquired the Grange in 1911 and later undertook several expansions to the north and west " +
                                    "of the structure."
                        )
                        startActivity(intent)
                    }
                    2 -> {
                        Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("name", "Gardiner Museum")
                        intent.putExtra(
                            "desc",
                            "The Gardiner Museum presents original and thought-provoking exhibitions of " +
                                    "both historical and contemporary ceramics, promoting understanding of broad social and " +
                                    "artistic perspectives."
                        )
                        startActivity(intent)
                    }
                    3 -> {
                        Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("name", "Spadina Museum")
                        intent.putExtra(
                            "desc",
                            "Spadina Museum offers a glimpse of Toronto during the 1900-1930 period through " +
                                    "the lens of the Austin family. The museum highlights the effects of transformative events on " +
                                    "the Austins such as the First World War, the Great Depression and societal changes in Canada."
                        )
                        startActivity(intent)
                    }
                    4 -> {
                        Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("name", "Ontario Science Centre")
                        intent.putExtra(
                            "desc",
                            "Planning for the Science Centre started in 1961 during Toronto's massive expansion of " +
                                    "the late 1950s and 1960s. In 1964, Toronto architect Raymond Moriyama was hired to design the site. " +
                                    "Construction started in 1966 with plans to open the Centennial Centre of Science and Technology as part of " +
                                    "the Canadian Centennial celebrations in 1967.However, construction was not completed in 1967, and the " +
                                    "Science Centre did not open to the public until two years later, on September 26, 1969."
                        )
                        startActivity(intent)
                    }
                }
            }
            "Stadiums" -> {
                when (position) {
                    0 -> {
                        Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("name", "Rogers Centre")
                        intent.putExtra(
                            "desc",
                            "Opened in 1989 on the former Railway Lands, it is home to the Toronto " +
                                    "Blue Jays of Major League Baseball (MLB). Previously, the stadium was also home to " +
                                    "the Toronto Argonauts of the Canadian Football League (CFL) and the Toronto Raptors of " +
                                    "the National Basketball Association (NBA). The Buffalo Bills of the National Football " +
                                    "League (NFL) played an annual game at the stadium as part of the Bills Toronto Series from " +
                                    "2008 to 2013."
                        )
                        startActivity(intent)
                    }
                    1 -> {
                        Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("name", "Scotiabank Arena")
                        intent.putExtra(
                            "desc",
                            "It is the home of the Toronto Raptors of the National Basketball Association (NBA) " +
                                    "and the Toronto Maple Leafs of the National Hockey League (NHL). In addition, the minor league " +
                                    "Toronto Marlies of the American Hockey League (AHL) and the Raptors 905 of the NBA G League play " +
                                    "occasional games at the arena. The arena was previously home to the Toronto Phantoms of the Arena " +
                                    "Football League (AFL) and the Toronto Rock of the National Lacrosse League. Scotiabank Arena also " +
                                    "hosts other events, such as concerts, political conventions and video game competitions."
                        )
                        startActivity(intent)
                    }
                    2 -> {
                        Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("name", "BMO Field")
                        intent.putExtra(
                            "desc",
                            "BMO Field is an outdoor stadium located at Exhibition Place in Toronto, Ontario, Canada, " +
                                    "which is home to Toronto FC of Major League Soccer and the Toronto Argonauts of the Canadian Football " +
                                    "League. Constructed on the site of the former Exhibition Stadium and first opened in 2007, it is owned " +
                                    "by the City of Toronto, and managed by Maple Leaf Sports & Entertainment. The stadium's naming rights are " +
                                    "held by the Bank of Montreal, which is commonly branded as BMO"
                        )
                        startActivity(intent)
                    }
                    3 -> {
                        Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("name", "Coca-Cola Coliseum")
                        intent.putExtra(
                            "desc",
                            "Coca-Cola Coliseum (also or formerly known as CNE Coliseum, Royal Coliseum, Ricoh Coliseum, " +
                                    "Toronto Coliseum or Coliseum) is an arena at Exhibition Place in Toronto, Ontario, Canada, used for agricultural " +
                                    "displays, ice hockey, and trade shows. It was built for the Canadian National Exhibition (CNE) and the Royal " +
                                    "Agricultural Winter Fair (the Royal) in 1921. Since 1997 it has been part of the Enercare Centre exhibition complex. " +
                                    "It serves as the home arena of the Toronto Marlies ice hockey team, the American Hockey League farm team of the Toronto " +
                                    "Maple Leafs. For the 2015 Pan American Games the venue hosted the gymnastics competitions and was known as the Toronto " +
                                    "Coliseum."
                        )
                        startActivity(intent)
                    }
                }
            }
            "Attractions" -> {
                when (position) {
                    0 -> {
                        Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("name", "CN Tower")
                        intent.putExtra(
                            "desc",
                            "The CN Tower (French: Tour CN) is a 553.3 m-high (1,815.3 ft) concrete communications and observation tower in " +
                                    "downtown Toronto, Ontario, Canada. Built on the former Railway Lands, it was completed in 1976. Its name CN " +
                                    "referred to Canadian National, the railway company that built the tower. Following the railway's decision to divest " +
                                    "non-core freight railway assets prior to the company's privatization in 1995, it transferred the tower to the Canada " +
                                    "Lands Company, a federal Crown corporation responsible for real estate development."
                        )
                        startActivity(intent)
                    }
                    1 -> {
                        Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("name", "Ripley's Aquarium of Canada")
                        intent.putExtra(
                            "desc",
                            "Ripley's Aquarium of Canada is a public aquarium in Toronto, Ontario, Canada. The aquarium is one of three aquariums " +
                                    "owned-and-operated by Ripley Entertainment. It is located in downtown Toronto, just southeast of the CN Tower. " +
                                    "The aquarium has 5.7 million litres (1.25 million gallons) of marine and freshwater habitats from across the world. " +
                                    "The exhibits hold more than 20,000 exotic sea and freshwater specimens from more than 450 species."
                        )
                        startActivity(intent)
                    }
                    2 -> {
                        Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("name", "High Park Toronto")
                        intent.putExtra(
                            "desc",
                            "High Park is a municipal park in Toronto, Ontario, Canada. High Park is a mixed recreational and natural park, " +
                                    "with sporting facilities, cultural facilities, educational facilities, gardens, playgrounds and a zoo. One-third of " +
                                    "the park remains in a natural state, with a rare oak savannah ecology. High Park was opened to the public in 1876 " +
                                    "and is based on a bequest of land from John George Howard to the City of Toronto. It spans 161 hectares (400 acres) " +
                                    "and is the second-largest municipal park in Toronto, after Centennial Park."
                        )
                        startActivity(intent)
                    }
                    3 -> {
                        Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("name", "Toronto Zoo")
                        intent.putExtra(
                            "desc",
                            "The Toronto Zoo is a zoo located in Toronto, Ontario, Canada. Encompassing 287 hectares (710 acres), the Toronto Zoo " +
                                    "is the largest zoo in Canada. It is divided into seven zoogeographic regions: Indo-Malaya, Africa, Americas, " +
                                    "Tundra Trek, Australasia, Eurasia, and the Canadian Domain. Some animals are displayed indoors in pavilions and " +
                                    "outdoors in what would be their naturalistic environments, with viewing at many levels. It also has areas such as " +
                                    "the Kids Zoo, Waterside Theatre, and Splash Island."
                        )
                        startActivity(intent)
                    }
                    4 -> {
                        Toast.makeText(this, "Description", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("name", "Yonge-Dundas Square")
                        intent.putExtra(
                            "desc",
                            "Yonge–Dundas Square, or Dundas Square, is a public square at the southeast corner of the intersection of Yonge Street " +
                                    "and Dundas Street East in Downtown Toronto, Ontario, Canada. Designed by Brown and Storey Architects, the square was " +
                                    "conceived in 1997 as part of revitalizing the intersection. Since its completion in 2002, the square has hosted " +
                                    "many public events, performances and art displays, establishing itself as a prominent landmark in Toronto and one of " +
                                    "the city's prime tourist attractions."
                        )
                        startActivity(intent)
                    }
                }
            }
        }
    }

    private fun addDataToListSuggested() {
        locationList.add(
            Location(
                "Casa Loma",
                R.drawable.casa_loma,
                "A prime example of modern Toronto’s commitment to its rich history ..."
            )
        )

        locationList.add(
            Location(
                "University College",
                R.drawable.university_college,
                "University College, popularly referred to as UC ..."
            )
        )

        locationList.add(
            Location(
                "Queen's Park",
                R.drawable.queens_park,
                "Queens Park is a smaller urban park in Downtown Toronto and ..."
            )
        )

        locationList.add(
            Location(
                "Royal Ontario Museum",
                R.drawable.royal_ontario_museum,
                "The Royal Ontario Museum is a museum of art, world culture and ..."
            )
        )

        locationList.add(
            Location(
                "Ontario Science Centre",
                R.drawable.ontarios_cience_centre,
                "The Ontario Science Centre is one of the first interactive science museums in the world ..."
            )
        )

        locationList.add(
            Location(
                "Rogers Centre",
                R.drawable.rogers_centre,
                "Rogers Centre (originally SkyDome) is a multi-purpose retractable roof stadium in Downtown Toronto ..."
            )
        )

        locationList.add(
            Location(
                "Scotiabank Arena",
                R.drawable.scotiabank_arena,
                "Scotiabank Arena (French: Aréna Scotiabank), formerly known as Air Canada Centre (ACC), is a multi-purposed arena ..."
            )
        )

        locationList.add(
            Location(
                "Coca-Cola Coliseum",
                R.drawable.scotiabank_arena,
                "Coca-Cola Coliseum is an arena at Exhibition Place in Toronto ..."
            )
        )

        locationList.add(
            Location(
                "CN Tower",
                R.drawable.cn_tower,
                "The CN Tower (French: Tour CN) is a 553.3 m-high (1,815.3 ft) concrete communications and observation tower in downtown Toronto ..."
            )
        )

        locationList.add(
            Location(
                "Ripley's Aquarium of Canada",
                R.drawable.ripleys_aquarium_of_canada,
                "Ripley's Aquarium of Canada is a public aquarium in Toronto ..."
            )
        )

        locationList.add(
            Location(
                "Toronto Zoo",
                R.drawable.toronto_zoo,
                "The Toronto Zoo is a zoo located in Toronto. Encompassing 287 hectares, the Toronto Zoo is the largest zoo in Canada...."
            )
        )
    }

    private fun addDataToListHistoric() {
        locationList.add(
            Location(
                "Casa Loma",
                R.drawable.casa_loma,
                "A prime example of modern Toronto’s commitment to its rich history ..."
            )
        )

        locationList.add(
            Location(
                "University College",
                R.drawable.university_college,
                "University College, popularly referred to as UC ..."
            )
        )

        locationList.add(
            Location(
                "Gooderham Building",
                R.drawable.gooderham_building,
                "The Gooderham Building, is an historic office building ..."
            )
        )

        locationList.add(
            Location(
                "Queen's Park",
                R.drawable.queens_park,
                "Queens Park is a smaller urban park in Downtown Toronto and ..."
            )
        )

        locationList.add(
            Location(
                "St. Michael's Cathedral",
                R.drawable.st_michaels_athedral,
                "St. Michael's Cathedral Basilica is the cathedral church of the Roman Catholic Archdiocese of Toronto ..."
            )
        )
    }

    private fun addDataToListMuseums() {
        locationList.add(
            Location(
                "Royal Ontario Museum",
                R.drawable.royal_ontario_museum,
                "The Royal Ontario Museum is a museum of art, world culture and ..."
            )
        )

        locationList.add(
            Location(
                "Art Gallery of Ontario",
                R.drawable.art_gallery_of_ontario,
                "The Art Gallery of Ontario is an art museum in Toronto, Ontario, Canada ..."
            )
        )

        locationList.add(
            Location(
                "Gardiner Museum",
                R.drawable.gardiner_museum,
                "The Gardiner Museum presents original and thought-provoking exhibitions of ..."
            )
        )

        locationList.add(
            Location(
                "Spadina Museum",
                R.drawable.gardiner_museum,
                "Spadina Museum offers a glimpse of Toronto during the 1900-1930 period ..."
            )
        )

        locationList.add(
            Location(
                "Ontario Science Centre",
                R.drawable.ontarios_cience_centre,
                "The Ontario Science Centre is one of the first interactive science museums in the world ..."
            )
        )
    }

    private fun addDataToListStadiums() {
        locationList.add(
            Location(
                "Rogers Centre",
                R.drawable.rogers_centre,
                "Rogers Centre (originally SkyDome) is a multi-purpose retractable roof stadium in Downtown Toronto ..."
            )
        )

        locationList.add(
            Location(
                "Scotiabank Arena",
                R.drawable.scotiabank_arena,
                "Scotiabank Arena (French: Aréna Scotiabank), formerly known as Air Canada Centre (ACC), is a multi-purposed arena ..."
            )
        )

        locationList.add(
            Location(
                "BMO Field",
                R.drawable.rogers_centre,
                "BMO Field is an outdoor stadium located at Exhibition Place in Toronto ..."
            )
        )
        locationList.add(
            Location(
                "Coca-Cola Coliseum",
                R.drawable.scotiabank_arena,
                "Coca-Cola Coliseum is an arena at Exhibition Place in Toronto ..."
            )
        )
    }

    private fun addDataToListAttractions() {
        locationList.add(
            Location(
                "CN Tower",
                R.drawable.cn_tower,
                "The CN Tower (French: Tour CN) is a 553.3 m-high (1,815.3 ft) concrete communications and observation tower in downtown Toronto ..."
            )
        )

        locationList.add(
            Location(
                "Ripley's Aquarium of Canada",
                R.drawable.ripleys_aquarium_of_canada,
                "Ripley's Aquarium of Canada is a public aquarium in Toronto ..."
            )
        )

        locationList.add(
            Location(
                "High Park Toronto",
                R.drawable.high_park,
                "High Park is a municipal park in Toronto, Ontario, Canada. High Park is a mixed recreational and ..."
            )
        )

        locationList.add(
            Location(
                "Toronto Zoo",
                R.drawable.toronto_zoo,
                "The Toronto Zoo is a zoo located in Toronto. Encompassing 287 hectares, the Toronto Zoo is the largest zoo in Canada...."
            )
        )

        locationList.add(
            Location(
                "Yonge-Dundas Square",
                R.drawable.yonge_dundas_square,
                "Yonge–Dundas Square, or Dundas Square, is a public square at the southeast corner of the intersection of Yonge Street and Dundas Street East in Downtown Toronto ..."
            )
        )
    }
}