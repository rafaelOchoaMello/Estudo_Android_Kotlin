package com.curso.primeiroapp.recyclerViewAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.dynamicanimation.R
import androidx.recyclerview.widget.RecyclerView
import com.curso.primeiroapp.model.Jogos

//O Adaptar vai como o nome diz 'adaptar' o RecyclerView para que ele mostre a nossa
//lista do modo como quisermos, para isto, utilizamos dentro dele um holder, que
//de fato terá como função, conter cada um dos elementos.

//É nele que também vamos receber a lista de dados que devem ser mostrados
class RecyclerViewAdapter(
    val listaJogos: ArrayList<Jogos> = arrayListOf()
) : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    //Aqui vem a viewHolder :: Conterá os dados a serem exibidos
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titulo: TextView = itemView.findViewById(com.curso.primeiroapp.R.id.textTitulo)
        val ano: TextView = itemView.findViewById(com.curso.primeiroapp.R.id.textAno)
        val genero: TextView = itemView.findViewById(com.curso.primeiroapp.R.id.textGenero)
        var itemPosition: Int = -1

        //Supostamente aqui podemos definir o click listener, vou tentar um Toast
        init {
            itemView.setOnClickListener {
                Toast.makeText(
                    itemView.context,
                    "${titulo.text} -  ${itemPosition}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    //Estes métodos são nativos e necessítam ser implementados

    //onCreateViewHolder :: Aqui vamos usar um layout  XML que representa um elemento da lista
    //criando(mas não exibindo) a visualização
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //Precisamos converter o xml 'recycler_list_item'
        val itemLista: View = LayoutInflater.from(parent.context)
            .inflate(com.curso.primeiroapp.R.layout.recyclerview_list_item, parent, false)

        return MyViewHolder(itemLista)
    }

    //onBindViewHolder :: É aqui que a exibição ocorre
    //É importante notar, que os dados podem ser dinâmicos, vindos por exemplo de uma lista
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.titulo.setText(listaJogos[position].titulo)
        holder.genero.setText(listaJogos[position].genero)
        holder.ano.setText(listaJogos[position].ano)
        holder.itemPosition = position
    }

    //getItemCount :: Retorna a quantidade de elementos que serão exibidos
    override fun getItemCount(): Int {
        return listaJogos.size
    }

}