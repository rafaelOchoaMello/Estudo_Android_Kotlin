package com.curso.primeiroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.curso.primeiroapp.recyclerViewAdapter.RecyclerViewAdapter

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        //RECYCLERVIEW ::::
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        //Define e configura o Adapter com base na nossa classe 'RecyclerViewAdapter'
        val myAdapter: RecyclerViewAdapter = RecyclerViewAdapter()


        //CONFIGURAÇÕES RECYCLERVIEW ::::
        //Melhora o desempenho
        recyclerView.setHasFixedSize(true)
        //Define e configura o layout manager. Neste caso, definido somente como vertical
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //Define o adapter
        recyclerView.adapter = myAdapter

    }
}