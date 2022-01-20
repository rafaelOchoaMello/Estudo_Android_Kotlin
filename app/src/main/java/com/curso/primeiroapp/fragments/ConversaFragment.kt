package com.curso.primeiroapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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

// Por padrão os fragments vem como 'FrameLayout', neste caso eu modifiquei
//como contraint, funciona normal.

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ConversaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ConversaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_conversa, container, false)
        val texto: TextView = view.findViewById(R.id.conversaText)

        //Teste de utilizalção de métodos dentro do fragment
        val testeMetodo_btn: Button = view.findViewById(R.id.conversaFragment_btnTeste)

        testeMetodo_btn.setOnClickListener{
            texto.setText("Rapadura de Goiaba")
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ConversaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ConversaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}