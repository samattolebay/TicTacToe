package com.example.tictactoe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecordsAdapter(private val dataSet: List<Player>) :
    RecyclerView.Adapter<RecordsAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textName = view.findViewById<TextView>(R.id.tvName)
        var textWin = view.findViewById<TextView>(R.id.tvWin)
        var textLose = view.findViewById<TextView>(R.id.tvLose)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.player_info, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val player = dataSet[position]
        holder.textName.text = player.name
        holder.textWin.text = "   ${player.win}   "
        holder.textLose.text = "   ${player.lose}   "
    }

    override fun getItemCount() = dataSet.size
}