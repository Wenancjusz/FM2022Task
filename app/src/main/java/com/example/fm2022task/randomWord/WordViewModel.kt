package com.example.fm2022task.randomWord

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WordViewModel : ViewModel() {
    private var words = ArrayList<String>()
    private val service = WordService()

    fun getWords(count: Int, callback: (words:List<String>) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
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