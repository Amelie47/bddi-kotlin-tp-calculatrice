package com.gmail.ameliemouillacpro.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.gmail.ameliemouillacpro.news.fragments.Categoriesfragment
import com.gmail.ameliemouillacpro.news.fragments.ListArticleFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        change(Categoriesfragment())
    }
}

fun FragmentActivity.change(fragment: Fragment) {
    supportFragmentManager.beginTransaction().apply {
        replace(R.id.container, fragment)
        addToBackStack(null)
    }.commit()
}