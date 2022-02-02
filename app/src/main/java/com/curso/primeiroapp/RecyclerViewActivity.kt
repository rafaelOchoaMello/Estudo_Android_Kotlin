package com.curso.primeiroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
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


        //CONFIGURAÇÕES RECYCLERVIEW ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

        //Melhora o desempenho
        recyclerView.setHasFixedSize(true)

        //Define e configura o layout manager. Neste caso, definido somente como vertical
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        //Define o adapter do recycler com base no nosso próprio adapter
        recyclerView.adapter = myAdapter

        //Cria um divisor visual entre os elementos da lista - Neste caso uma simples linha
        //É passado o contexto, e também o sentido (não o da linha em si, mas do display dos elementos)
        recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))

    }

    private fun loadJogos() {
        this.jogos.add(Jogos("Super Mario Bros", "Plataforma", "1985"))
        this.jogos.add(Jogos("Super Mario Bros 2", "Plataforma", "1986"))
        this.jogos.add(Jogos("Super Mario Bros", "Plataforma", "1988"))
        this.jogos.add(Jogos("Pokémon Yellow", "RPG", "1998"))
        this.jogos.add(Jogos("Pokémon Gold", "RPG", "1999"))
        this.jogos.add(Jogos("Super Mario Sunshine", "Plataforma 3D", "-"))
        this.jogos.add(Jogos("Sonic Heroes", "Plataforma 3D", "-"))
        this.jogos.add(Jogos("Super Mario Strikers", "Esportes", "-"))
        this.jogos.add(Jogos("The Legend of Zelda WindWaker", "RPG", "-"))
        this.jogos.add(Jogos("Luigi's Mansion", "Aventura", "-"))
        this.jogos.add(Jogos("Donkey Kong Country Returns", "Plataforma", "-"))
        this.jogos.add(Jogos("Wario Land Shake It", "Exploração", "-"))
        this.jogos.add(Jogos("Kirby's Adventure Wii", "Plataforma", "-"))
        this.jogos.add(Jogos("Super Smash Bros Brawl", "Luta", "-"))
        this.jogos.add(Jogos("Advanced Wars", "Estratégia", "-"))
        this.jogos.add(Jogos("Metroid Fusion", "Aventura", "-"))
        this.jogos.add(Jogos("Final Fantasy Tatics Adv.", "Estratégia", "-"))
        this.jogos.add(Jogos("Dr.Mario", "Puzzle", "-"))
        this.jogos.add(Jogos("Ice Climber", "Arcade", "-"))
        this.jogos.add(Jogos("Alex Kidd in Miracle World", "Plataforma", "-"))
    }
}