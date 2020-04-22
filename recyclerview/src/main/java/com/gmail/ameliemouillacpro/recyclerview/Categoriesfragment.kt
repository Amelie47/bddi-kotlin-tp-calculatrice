package com.gmail.ameliemouillacpro.recyclerview;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gmail.ameliemouillacpro.recyclerview.adapters.CategorieAdapter
import com.gmail.ameliemouillacpro.recyclerview.models.Categorie

class Categoriesfragment: Fragment() {

    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var recycler_view: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.categories_view,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var btn = view.findViewById<Button>(R.id.btn_articles_fragment)
        btn.setOnClickListener {
            activity?.change(ArticlesFragment())
        }

        recycler_view = view.findViewById(R.id.recycler_view)
        bindRecyclerView()

    }

    private fun bindRecyclerView() {
        val categories = listOf(
            Categorie("Politique", "C'est ça la politique", "https://cdn.1min30.com/wp-content/uploads/2018/12/shutterstock_1075959185-copie.jpg"),
            Categorie("Economie","c'est l'économie", "https://lobservateur.info/wp-content/uploads/2019/04/5b02e7a498cdc.jpg"),
            Categorie("Education","c'est l'éducation", "https://www.touteleurope.eu/fileadmin/_processed_/0/7/politique-euro-formation-education-a387ed0502.jpg"),
            Categorie("Pandémie","c'est la pandémie", "https://cdn.futura-sciences.com/buildsv6/images/wide1920/5/5/a/55adb6fe27_50161581_pandemie-denisismagilov-adobe-stock.jpg"),
            Categorie("Sciences","c'est la sciences", "https://cdn.futura-sciences.com/buildsv6/images/wide1920/a/0/2/a0269d7a2e_50155960_science-20e-siecle-artinspiring-fotolia.jpg"),
            Categorie("Ecologie","c'est l'écologie", "https://youmatter.world/app/uploads/sites/3/2018/08/ecologie-solutions.jpg")
        )
        val adapterRecycler = CategorieAdapter(categories)
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.adapter = adapterRecycler
    }
}


