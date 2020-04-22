package com.gmail.ameliemouillacpro.news.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.gmail.ameliemouillacpro.news.R
import com.gmail.ameliemouillacpro.news.models.Categorie
import com.gmail.ameliemouillacpro.recyclerview.models.Article

@GlideModule

class CategorieAdapter(
    private val dataset: List<Categorie>,
    private val callback: (categorie:Categorie) -> Unit
)
    : RecyclerView.Adapter<CategorieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.categorie_item, parent, false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(dataset[position])

    override fun getItemCount(): Int = dataset.size

    inner class ViewHolder(val root: View) : RecyclerView.ViewHolder(root) {
        fun bind(item: Categorie) {
            root.setOnClickListener {
                callback(item)
            }
            val txtTitle = root.findViewById<TextView>(R.id.categorie_name)
            val txtDesc = root.findViewById<TextView>(R.id.categorie_description)
            val img = root.findViewById<ImageView>(R.id.categorie_image)
            Glide.with(root.context).load(item.url).fitCenter().into(img)
            txtTitle.text = item.name
            txtDesc.text = item.description
        }
    }
}

