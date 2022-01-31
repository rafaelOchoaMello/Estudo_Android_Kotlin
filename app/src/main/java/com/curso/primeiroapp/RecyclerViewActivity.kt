package com.curso.primeiroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.curso.primeiroapp.model.Jogos
import com.curso.primeiroapp.recyclerViewAdapter.RecyclerViewAdapter

class RecyclerViewActivity : AppCompatActivity() {

    private val jogos: ArrayList<Jogos> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        //Carrega os filmes que serão passados para o nosso RecyclerView
        loadJogos()

        //RECYCLERVIEW ::::
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        //Define e configura o Adapter com base na nossa classe 'RecyclerViewAdapter'
        //É na nossa classe que vamos passar a lista de jogos
        val myAdapter: RecyclerViewAdapter = RecyclerViewAdapter(jogos)


        //CONFIGURAÇÕES RECYCLERVIEW ::::
        //Melhora o desempenho
        recyclerView.setHasFixedSize(true)
        //Define e configura o layout manager. Neste caso, definido somente como vertical
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //Define o adapter
        recyclerView.adapter = myAdapter

    }

    private fun loadJogos(){
        this.jogos.add(Jogos("Super Mario Bros", "Plataforma", "1985"))
        this.jogos.add(Jogos("Super Mario Bros 2", "Plataforma", "1986"))
        this.jogos.add(Jogos("Super Mario Bros", "Plataforma", "1988"))
        this.jogos.add(Jogos("Pokémon Yellow", "RPG", "1998"))
        this.jogos.add(Jogos("Pokémon Gold", "RPG", "1999"))
    }
}