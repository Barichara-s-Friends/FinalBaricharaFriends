package com.barichara.baricharasitios.detalle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.barichara.baricharasitios.databinding.ActivityDetalleBinding
import com.barichara.baricharasitios.model.SitioItem
import com.squareup.picasso.Picasso

class DetalleActivity : AppCompatActivity() {
    private lateinit var detalleBinding: ActivityDetalleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBinding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(detalleBinding.root)
        val sitio: SitioItem = intent.extras?.getSerializable("sitio") as SitioItem
        with(detalleBinding) {
            nameTextView.text = sitio.nombre
            powersTextView.text = sitio.descripcion
            Picasso.get().load(sitio.urlFoto).into(pictureImageView)
        }
    }
}