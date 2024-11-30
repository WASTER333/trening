package com.example.trening3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TreningAdapter(private val listaTreningow: List<Trening>) :
    RecyclerView.Adapter<TreningAdapter.TreningViewHolder>() {

    class TreningViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textRodzaj: TextView = view.findViewById(R.id.textRodzaj)
        val textDystans: TextView = view.findViewById(R.id.textDystans)
        val textCzas: TextView = view.findViewById(R.id.textCzas)
        val textKalorie: TextView = view.findViewById(R.id.textKalorie)
        val textIntensywnosc: TextView = view.findViewById(R.id.textIntensywnosc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TreningViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_trening, parent, false)
        return TreningViewHolder(view)
    }

    override fun onBindViewHolder(holder: TreningViewHolder, position: Int) {
        val trening = listaTreningow[position]
        holder.textRodzaj.text = trening.rodzaj
        holder.textDystans.text = "Dystans: ${trening.dystans} km"
        holder.textCzas.text = "Czas: ${trening.czas} min"
        holder.textKalorie.text = "Kalorie: ${trening.kalorie}"
        holder.textIntensywnosc.text = "Intensywność: ${trening.intensywnosc}"
    }

    override fun getItemCount(): Int = listaTreningow.size
}
