package com.curso.primeiroapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.curso.primeiroapp.fragments.ContatosFragment
import com.curso.primeiroapp.fragments.ConversaFragment

class EstudoFragments : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estudo_fragments)


        //Bobabem, só vamos retirar a sombra da action bar por questões estéticas
        supportActionBar?.elevation = -1F

        //Instâncias dos fragments
        val conversaFragment: ConversaFragment = ConversaFragment()
        val contatosFragment: ContatosFragment = ContatosFragment()

        //Referência aos botões
        val buttonContatos: Button = findViewById(R.id.buttonContatos)
        val buttonConversa: Button = findViewById(R.id.buttonConversas)

        //Neste caso, como vamos ter que enviar fragments como parâmetros para os eventos
        //de click, não vai dar pra usar o evento 'onClick' do xml. Vamos ter que implementar
        //os listeners...

        //Listener dos contatos
        buttonContatos.setOnClickListener {
            loadFragmentWithData(contatosFragment)
        }

        //Listener das conversas
        buttonConversa.setOnClickListener {
            loadFragment(conversaFragment)
        }


    }

    fun loadFragment(fragment: Fragment) {
        //Configurações para os objetos de fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameConteudo, fragment)
        transaction.commit()
    }

    fun loadFragmentWithData(fragment: Fragment) {
        val bundle: Bundle = Bundle()
        bundle.putString("MSG", "Dados a serem recebidos")
        fragment.arguments = bundle

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameConteudo, fragment)
        transaction.commit()
    }
}
