package com.barichara.sitio.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.barichara.sitio.R
import com.barichara.sitio.model.SitioItem
import com.squareup.picasso.Picasso

class SitioAdapter(
    private val sitioList: ArrayList<SitioItem>,
    private val onItemClicked: (SitioItem) -> Unit
) : RecyclerView.Adapter<SitioAdapter.SitioViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SitioViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_sitio_item, parent, false)
        return SitioViewHolder(view)
    }

    override fun onBindViewHolder(holder: SitioViewHolder, position: Int) {
        val Sitio = sitioList[position]
        holder.itemView.setOnClickListener { onItemClicked(sitioList[position]) }
        holder.bind(Sitio)
    }

    override fun getItemCount(): Int = sitioList.size
    class SitioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
        private var aliasTextView: TextView = itemView.findViewById(R.id.alias_text_view)
        private var pictureImageView: ImageView = itemView.findViewById(R.id.picture_image_view)

        fun bind(Sitio: SitioItem) {
            nameTextView.text = Sitio.nombre
            aliasTextView.text = Sitio.descripcion
            Picasso.get().load(Sitio.urlFoto).into(pictureImageView)
        }
    }
}