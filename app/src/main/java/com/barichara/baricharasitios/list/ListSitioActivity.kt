package com.barichara.baricharasitios.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.barichara.baricharasitios.R
import com.barichara.baricharasitios.detalle.DetalleActivity
import com.barichara.baricharasitios.model.Sitio
import com.barichara.baricharasitios.model.SitioItem
import com.google.gson.Gson

class ListSitioActivity : AppCompatActivity() {

    private lateinit var listSitio: ArrayList<SitioItem>
    private lateinit var sitioAdapter: SitioAdapter
    private lateinit var sitioRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_sitio)

        sitioRecyclerView = findViewById(R.id.sitio_recycler_view)

    //    listSitio = createMockSitio()
        listSitio = loadMockSitioFromJson()
        sitioAdapter = SitioAdapter(listSitio, onItemClicked = { onSitioClicked(it) } )

        sitioRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = sitioAdapter
            setHasFixedSize(false)
        }
    }

    private fun onSitioClicked(Sitio: SitioItem) {
        val intent = Intent(this, DetalleActivity::class.java)
        intent.putExtra("Sitio",Sitio)
        startActivity(intent)
    }

    private fun loadMockSitioFromJson(): ArrayList<SitioItem> {
        val sitioString: String = applicationContext.assets.open("sitio.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val sitioList = gson.fromJson(sitioString, Sitio::class.java)
        return sitioList
    }

   /* private fun createMockSitio(): ArrayList<Sitio> {
        /* Crear Sitio uno a uno
        var lista: ArrayList<Sitio> = arrayListOf()
         var Sitio = Sitio(
             name = "Superman",
             powers = "Super strength, flight, invulnerability, super speed, heat vision, freeze breath, x-ray vision, superhuman hearing, healing factor",
             alias = "Clark Kent, Kal-El",
             city = "Metropolis",
             facebook = "https://www.facebook.com/superman",
             occupation = "Reporter"
         )
         lista.add(Sitio)
         return lista*/

        return arrayListOf(
            Sitio(
                name = "Superman",
                powers = "Super strength, flight, invulnerability, super speed, heat vision, freeze breath, x-ray vision, superhuman hearing, healing factor",
                alias = "Clark Kent, Kal-El",
                city = "Metropolis",
                facebook = "https://www.facebook.com/superman",
                occupation = "Reporter",
                urlPicture = "https://www.sitio.com/sites/default/files/styles/character_thumb_160x160/public/Char_Profile_Superman_20190116_5c3fc2758f6a12.25513240.jpg"
            ),
            Sitio(
                name = "Batman",
                powers = "Exceptional martial artist, combat strategy, inexhaustible wealth, brilliant deductive skill, advanced technology",
                alias = "Bruce Wayne",
                city = "Gotham",
                facebook = "https://www.facebook.com/batman",
                occupation = "CEO of Wayne Enterprises",
                urlPicture = "https://www.sitio.com/sites/default/files/styles/character_thumb_160x160/public/Char_Profile_Batman_20190116_5c3fc4b40faec2.47318964.jpg"
            ),
            Sitio(
                name = "Wonder Woman",
                powers = "Super strength, invulnerability, flight, combat skill, combat strategy, superhuman agility, healing factor, magic weaponry",
                alias = "Diana Prince",
                city = "Temiscira",
                facebook = "https://www.facebook.com/wonderwoman",
                occupation = "Secretary",
                urlPicture = "https://www.sitio.com/sites/default/files/styles/character_thumb_160x160/public/Char_Profile_WonderWoman_20190116_5c3fc6aa51d0e3.49076914.jpg"
            ),
            Sitio(
                name = "Flash",
                powers = "Super speed, intangibility, superhuman agility",
                alias = "Barry Allen, Jay Garrick, Wally West",
                city = "Central City",
                facebook = "https://www.facebook.com/theflash",
                occupation = "Forensic scientist",
                urlPicture = "https://www.sitio.com/sites/default/files/styles/character_thumb_160x160/public/Char_Profile_Flash_20190116_5c3fcaaa18f0e8.03668117.jpg"
            ),
            Sitio(
                name = "Green Lantern",
                powers = "Hard light constructs, instant weaponry, force fields, flight, durability, alien technology",
                alias = "Hal Jordan",
                city = "Coast City",
                facebook = "",
                occupation = "Test pilot",
                urlPicture = "https://www.sitio.com/sites/default/files/styles/character_thumb_160x160/public/Char_Profile_GreenLantern_20200721_5f173ad01724e2.92436411.jpg"
            )
        )
    }*/
}