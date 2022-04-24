package com.example.fm2022task.wordRecording

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext

class SongViewModel : ViewModel (){
    private var songs = ArrayList<SongModel?>()
    private val service = SongService()

    fun getSongs(count: Int, words:List<String>,context:Context, callback: (songs:List<SongModel?>) -> Unit) {
        val loadingExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            Toast.makeText(context,"Network error!",Toast.LENGTH_SHORT).show()
        }
        viewModelScope.launch(Dispatchers.IO + loadingExceptionHandler) {
            val temporarySongs = ArrayList<SongModel?>()
            for (i in 0 until count) {

                var song = service.getSong(words[i])
                if(!temporarySongs.contains(song)){
                    temporarySongs.add(song)
                }
                else {
                    temporarySongs.add(null)
                }


            }
            songs = temporarySongs
            withContext(Dispatchers.Main){
                callback(songs)
            }
        }

    }

    fun getSongsList(): List<SongModel?> = songs

}