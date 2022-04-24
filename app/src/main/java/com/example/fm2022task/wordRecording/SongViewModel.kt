package com.example.fm2022task.wordRecording

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SongViewModel : ViewModel (){
    private val url = "https://musicbrainz.org/ws/2/recording/?query="
    private var songs = ArrayList<SongModel>()


    fun getSongs(count: Int, words:List<String>, callback: (songs:List<SongModel>) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val temporarySongs = ArrayList<SongModel>()
            for (i in 0 until count) {
                val service = SongService(url+words[i]+"&fmt=json")
                var song: SongModel
                do {
                    song = service.getSong()
                } while (temporarySongs.contains(song))

                temporarySongs.add(song)
            }
            songs = temporarySongs
            withContext(Dispatchers.Main){
                callback(songs)
            }
        }

    }

    fun getSongsList(): List<SongModel> = songs

}