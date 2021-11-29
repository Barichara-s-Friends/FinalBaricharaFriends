package com.barichara.sitio.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SitioItem(
    @SerializedName("calificacion")
    val calificacion: String,
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("urlFoto")
    val urlFoto: String
) : Serializable