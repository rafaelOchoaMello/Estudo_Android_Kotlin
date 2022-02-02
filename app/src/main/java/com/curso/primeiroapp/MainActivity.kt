package com.curso.primeiroapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.curso.primeiroapp.cardView.CardViewActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var jaClicou: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnTelaCapa: Button = findViewById(R.id.btn_TelaDeCapa)
        val btnTelaRecycler: Button = findViewById(R.id.recyclerBtn)
        val btnTelaRecCard: Button = findViewById(R.id.cardViewBtn)

        btnTelaCapa.setOnClickListener {
            changeToTelaDeCapa()
        }

        btnTelaRecycler.setOnClickListener {
            changeToRecycleActivity()
        }

        btnTelaRecCard.setOnClickListener{
            changeToCardRecActivity()
        }


    }

    fun changeToRecycleActivity() {
        val intent: Intent = Intent(this, RecyclerViewActivity::class.java)
        startActivity(intent)
    }

    fun changeToCardRecActivity() {
        val intent: Intent = Intent(this, CardViewActivity::class.java)
        startActivity(intent)
    }

    //Exemplo de criação de uma troca de activity e
    fun mudarDeActivity(view: View) {
        //instaciamento do objeto utilizado para troca de activities
        val intent: Intent = Intent(this, segundaTela::class.java)

        //Captura os dados recebidos via input de texto
        val inputNameValue: EditText = findViewById(R.id.editName)
        val name: String = inputNameValue.text.toString()

        //Objeto a ser enviado
        val poke: Pokemon = Pokemon("Bulbasaur", 7)

        //Envia os dados, caso o input não tenha nada (vazio), envia um valor padrão
        intent.putExtra("nome", if (name == "") "Fulano" else name)
        intent.putExtra("idade", 27)

        //Enviar um objeto, neste caso, uma instância de Pokemon
        intent.putExtra("pokemon", poke)


        startActivity(intent)
    }

    fun mudarParaEstudoFragments(view: View) {
        val intent: Intent = Intent(this, EstudoFragments::class.java)
        startActivity(intent)
    }

    fun changeToTelaDeCapa() {
        val intent: Intent = Intent(this, CapaActivity::class.java)
        startActivity(intent)
    }


    fun carregarInputNome(view: View) {
        val inputName: EditText = findViewById(R.id.editName)
        val nameDisplay: TextView = findViewById(R.id.loadedName)

        val inputNameText: String = inputName.text.toString()
        nameDisplay.setText(inputNameText)

        //Dá pra fazer assim também
        //nameDisplay.setText(inputName.text.toString())

    }

    fun alterarTexto(view: View) {
        //Próximo objetivo é alterar de findViewById para o viewBinding
        val texto: TextView = findViewById(R.id.onClickTextDisplay)
        val randomValues: Int = Random.nextInt(10)

        val nroMates = ajustaNumeroDeMates(randomValues)

        if (jaClicou)
            texto.setText("Boa piá, agora vai lá tomar um mate bem amargo...")
        else
            texto.setText("Agora que já tomou ${nroMates} ${textNroMates(nroMates)}, vai lá dar uma mijada!")

        jaClicou = !jaClicou
    }

    private fun ajustaNumeroDeMates(quantidade: Int): Int {
        if (quantidade == 0)
            return quantidade + 1
        else
            return quantidade
    }

    private fun textNroMates(quantidade: Int): String {
        if (quantidade > 1)
            return "mates"
        return "mate"
    }
}