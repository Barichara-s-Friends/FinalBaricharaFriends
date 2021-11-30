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
}