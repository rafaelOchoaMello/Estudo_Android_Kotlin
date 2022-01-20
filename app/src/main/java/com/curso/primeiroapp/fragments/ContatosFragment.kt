package com.curso.primeiroapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.curso.primeiroapp.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

//  <<Nota>> Aqui são as assinaturas 'keys' para o nosso bundle
// utilizado no companion object para criar uma instância do fragment

//  <<Nota 2>> Const vals tem o mesmo uso de uma val comum, com a
//diferença que não pode receber seu valor via outras formas se não
//a de declaração direta, ou seja, não pode receber de métodos por exemplo.
//Como nesse caso o titulo da key para a bundle sempre será o mesmo, faz
//sentido usar o 'const val'
private const val MENSAGEM = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [ContatosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ContatosFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var mensagemParam: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mensagemParam = it.getString(MENSAGEM)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_contatos, container, false)

        val texto: TextView = view.findViewById(R.id.contatosText)

        //arguments é nativo
        val dados = arguments

        if (dados !== null)
            texto.setText(dados.getString("MSG", "No Data"))

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ContatosFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(msg: String, param2: String) =
            ContatosFragment().apply {
                arguments = Bundle().apply {
                    putString(MENSAGEM, msg)
                }
            }
    }
}