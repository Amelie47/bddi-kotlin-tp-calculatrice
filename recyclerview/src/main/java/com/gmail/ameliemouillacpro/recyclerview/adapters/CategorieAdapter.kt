package com.gmail.ameliemouillacpro.recyclerview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.gmail.ameliemouillacpro.recyclerview.R
import com.gmail.ameliemouillacpro.recyclerview.models.Categorie


@GlideModule

class CategorieAdapter(private val dataset: List<Categorie>) :
    RecyclerView.Adapter<CategorieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(dataset[position])

    override fun getItemCount(): Int = dataset.size

    class ViewHolder(val root: View) : RecyclerView.ViewHolder(root) {

        fun bind(item: Categorie) {
            val txtTitle = root.findViewById<TextView>(R.id.categorie_name)
            val txtDesc = root.findViewById<TextView>(R.id.categorie_description)
            val img = root.findViewById<ImageView>(R.id.categorie_image)
            Glide.with(root.context).load(item.url).fitCenter().into(img)
            txtTitle.text = item.name
            txtDesc.text = item.description
        }
    }
}