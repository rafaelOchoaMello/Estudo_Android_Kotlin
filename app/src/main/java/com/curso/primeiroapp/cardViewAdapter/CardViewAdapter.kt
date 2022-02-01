package com.curso.primeiroapp.cardViewAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.curso.primeiroapp.R

class CardViewAdapter() : RecyclerView.Adapter<CardViewAdapter.MyCardViewHolder>() {

    class MyCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titulo: TextView = itemView.findViewById(R.id.cardView_title)
        val postTime: TextView = itemView.findViewById(R.id.cardView_postTime)
        val image: ImageView = itemView.findViewById(R.id.cardView_image)
        val tag: TextView = itemView.findViewById(R.id.cardView_tag)
        val likeBtn: Button = itemView.findViewById(R.id.cardView_btnLike)
        val shareBtn: Button = itemView.findViewById(R.id.cardView_btnShare)
        var itemPosition: Int = -1

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

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyCardViewHolder {
        //Precisamos converter o xml 'recycler_list_item'
        val itemLista: View = LayoutInflater.from(parent.context)
            .inflate(com.curso.primeiroapp.R.layout.recyclerview_card_list_item, parent, false)

        return MyCardViewHolder(itemLista)
    }

    override fun onBindViewHolder(holder: CardViewAdapter.MyCardViewHolder, position: Int) {
        holder.titulo.setText("idasjdijas")
        holder.postTime.setText("Ontem")
        holder.tag.setText("#RapaduraDeGoiaba")
        holder.image.setImageResource(R.drawable.titulo)
        holder.itemPosition = position
    }

    override fun getItemCount(): Int {
        return 10
    }

}