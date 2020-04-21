package com.gmail.ameliemouillacpro.recyclerview;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gmail.ameliemouillacpro.recyclerview.adapters.ArticleAdapter
import com.gmail.ameliemouillacpro.recyclerview.models.Article

class ArticlesFragment: Fragment() {
    private lateinit var adapter: ArrayAdapter<String>

    private lateinit var spinner: Spinner
    private val planetes = listOf("Mer","Vé","Terre","Ma","Ju","Sat","Ur","Nept","Plu")

    private lateinit var recycler_view: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recycler_view,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        spinner = view.findViewById(R.id.spinner)

        adapter = ArrayAdapter(
            view.context,
            android.R.layout.simple_spinner_item,
            planetes
        )

        spinner.adapter = adapter


        recycler_view = view.findViewById(R.id.recycler_view)
        bindRecyclerView()

        var btn = view.findViewById<Button>(R.id.btn_categories_fragment)
        btn.setOnClickListener {
            activity?.change(Categoriesfragment())
        }

    }

    private fun bindRecyclerView() {
        val articles = listOf(
            Article(title = "Article1", description = "Description 1", image = "image 1"),
            Article(title = "Article1", description = "Description 1", image = "image 1"),
            Article(title = "Article1", description = "Description 1", image = "image 1"),
            Article(title = "Article1", description = "Description 1", image = "image 1"),
            Article(title = "Article1", description = "Description 1", image = "image 1"),
            Article(title = "Article1", description = "Description 1", image = "image 1"),
            Article(title = "Article1", description = "Description 1", image = "image 1"),
            Article(title = "Article1", description = "Description 1", image = "image 1"),
            Article(title = "Article1", description = "Description 1", image = "image 1"),
            Article(title = "Article1", description = "Description 1", image = "image 1"),
            Article(title = "Article1", description = "Description 1", image = "image 1"),
            Article("le titre","la description","l'image")
        )
        val adapterRecycler = ArticleAdapter(articles)
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.adapter = adapterRecycler
    }


}


