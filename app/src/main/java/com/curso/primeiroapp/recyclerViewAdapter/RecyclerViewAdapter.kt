package com.curso.primeiroapp.recyclerViewAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.dynamicanimation.R
import androidx.recyclerview.widget.RecyclerView

//O Adaptar vai como o nome diz 'adaptar' o RecyclerView para que ele mostre a nossa
//lista do modo como quisermos, para isto, utilizamos dentro dele um holder, que
//de fato terá como função, conter cada um dos elementos.
class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    //Aqui vem a viewHolder :: Conterá os dados a serem exibidos
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titulo: TextView = itemView.findViewById(com.curso.primeiroapp.R.id.textTitulo)
        val ano: TextView = itemView.findViewById(com.curso.primeiroapp.R.id.textAno)
        val genero: TextView = itemView.findViewById(com.curso.primeiroapp.R.id.textGenero)
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
        holder.titulo.setText("Pokémon Yellow")
        holder.genero.setText("RPG")
        holder.ano.setText("199x")
    }

    //getItemCount :: Retorna a quantidade de elementos que serão exibidos
    override fun getItemCount(): Int {
        return 15
    }

}