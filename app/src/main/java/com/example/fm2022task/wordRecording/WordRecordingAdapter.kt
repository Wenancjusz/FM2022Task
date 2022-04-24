package com.example.fm2022task.wordRecording

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fm2022task.R

class WordRecordingAdapter(
    var wordRecordingList: List<SongModel?>,
    var wordList: List<String>
) : RecyclerView.Adapter<WordRecordingAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_word_recording_data, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val song = wordRecordingList[holder.adapterPosition]
        holder.count.text = (holder.adapterPosition + 1).toString()
        holder.word.text = wordList[holder.adapterPosition]
        if(song==null){
            holder.title.text = "No recording found!"
            holder.artist.text = "No recording found!"
            holder.album.text = "No recording found!"

        }else {
            holder.title.text = song.title
            holder.artist.text = song.artistCredit.firstOrNull()?.name ?: "No recording found!"
            holder.album.text = song.releases.firstOrNull()?.title ?: "No recording found!"
        }
    }

    override fun getItemCount(): Int {
        return wordRecordingList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var count: TextView = itemView.findViewById(R.id.adapterCount)
        var word: TextView = itemView.findViewById(R.id.wordTV)
        var title: TextView = itemView.findViewById(R.id.titleTV)
        var album: TextView = itemView.findViewById(R.id.albumTV)
        var artist: TextView = itemView.findViewById(R.id.artistTV)
    }

}
