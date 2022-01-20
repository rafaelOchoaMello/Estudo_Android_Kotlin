package com.curso.primeiroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class segundaTela : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_tela)

        //Referência aos campos a serem alterados
        val textoNome: TextView = findViewById(R.id.nomeReceber)
        val textoIdade: TextView = findViewById(R.id.idadeReceber)
        val textoPokemon: TextView = findViewById(R.id.pokemonName)

        val dados: Bundle? = intent.extras

        if (dados !== null) {
            textoNome.setText(dados.getString("nome", "Fulano").toString())
            textoIdade.setText(dados.getInt("idade", 0).toString())

            //Captura dos dados do objeto - repare no casting 'as'
            val pokemon: Pokemon = dados.getSerializable("pokemon") as Pokemon
            textoPokemon.setText(pokemon.name)

        }
    }

    fun voltar(view: View) {
        finish()
    }
}