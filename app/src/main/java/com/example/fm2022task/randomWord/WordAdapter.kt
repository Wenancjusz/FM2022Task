package com.example.fm2022task.randomWord

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fm2022task.R

class WordAdapter(var wordList: List<String>, var context: Context) :
    RecyclerView.Adapter<WordAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_word, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.word.text = wordList[holder.adapterPosition]
        holder.count.text = (holder.adapterPosition + 1).toString()
    }

    override fun getItemCount(): Int {
        return wordList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var word: TextView = itemView.findViewById(R.id.adapterRandomWord)
        var count: TextView = itemView.findViewById(R.id.adapterWordCount)
    }
}