package com.example.fm2022task

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fm2022task.randomWord.WordAdapter
import com.example.fm2022task.randomWord.WordViewModel
import com.example.fm2022task.wordRecording.SongViewModel
import com.example.fm2022task.wordRecording.WordRecordingAdapter

class PresentDataActivity : AppCompatActivity() {
    private val viewModel: WordViewModel by viewModels()
    private val recViewModel: SongViewModel by viewModels()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_present_data)
        val recyclerView: RecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val getSongsBTN: Button = findViewById<Button>(R.id.getSongsBTN)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val count: Int = intent.getIntExtra("numberOfWords", 0)
        var words: List<String> = emptyList()

        viewModel.getWords(count,this@PresentDataActivity){ wordsViewmodel ->
            progressBar.visibility = View.GONE
            words = wordsViewmodel
            val wordAdapter = WordAdapter(words, this@PresentDataActivity)

            val layoutManager: RecyclerView.LayoutManager =
                LinearLayoutManager(this@PresentDataActivity)

            recyclerView.adapter = wordAdapter
            recyclerView.layoutManager = layoutManager

            getSongsBTN.isEnabled=true
            wordAdapter.notifyDataSetChanged()

        }

        getSongsBTN.setOnClickListener { v: View? ->
            getSongsBTN.visibility = View.GONE
            words = words.toSortedSet().toList()
            progressBar.visibility = View.VISIBLE

            recViewModel.getSongs(count,words,this@PresentDataActivity){ songs ->
                progressBar.visibility = View.GONE
                val wordRecAdapter = WordRecordingAdapter(songs,words)

                val layoutManager: RecyclerView.LayoutManager =
                    LinearLayoutManager(this@PresentDataActivity)

                recyclerView.adapter = wordRecAdapter
                recyclerView.layoutManager = layoutManager

                wordRecAdapter.notifyDataSetChanged()

            }
        }
    }
}