package com.barichara.baricharasitios.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.barichara.baricharasitios.model.SitioItem
import com.barichara.baricharasitios.databinding.ActivityDetalleBinding
import com.squareup.picasso.Picasso

class DetalleActivity : AppCompatActivity() {

    private lateinit var detalleBinding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBinding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(detalleBinding.root)

        val Sitio: SitioItem = intent.extras?.getSerializable("Sitio") as SitioItem

        with(detalleBinding){
            nameTextView.text = Sitio.nombre
            powersTextView.text = Sitio.descripcion
            Picasso.get().load(Sitio.urlFoto).into(pictureImageView)
        }
    }
}