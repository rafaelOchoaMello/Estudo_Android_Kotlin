package com.curso.primeiroapp.cardView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.curso.primeiroapp.R
import com.curso.primeiroapp.cardViewAdapter.CardViewAdapter

class CardViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_view)

        //RecyclerView para os Cards ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
        val recViewCard: RecyclerView = findViewById(R.id.recyclerViewCard)
        recViewCard.setHasFixedSize(true)

        //Layout
        recViewCard.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        //Adapter
        val cardAdapter: CardViewAdapter = CardViewAdapter()
        recViewCard.adapter = cardAdapter
    }
}