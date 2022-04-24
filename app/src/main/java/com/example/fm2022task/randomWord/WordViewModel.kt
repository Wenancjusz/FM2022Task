package com.example.fm2022task.randomWord

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WordViewModel : ViewModel() {
    private var words = ArrayList<String>()
    private val service = WordService()

    fun getWords(count: Int, context:Context, callback: (words:List<String>) -> Unit) {
        val loadingExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            Toast.makeText(context,"Network error!", Toast.LENGTH_SHORT).show()
        }
        viewModelScope.launch(Dispatchers.IO + loadingExceptionHandler) {
            val temporaryWords = ArrayList<String>()
            for (i in 0 until count) {
                var word: String
                do {
                    word = service.getWord().word
                } while (temporaryWords.contains(word))

                temporaryWords.add(word)
            }
            words = temporaryWords
            withContext(Dispatchers.Main){
            callback(words)
            }
        }

    }

    fun getWordsList(): List<String> = words

}