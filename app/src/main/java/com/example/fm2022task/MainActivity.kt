package com.example.fm2022task

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val wordsInput = findViewById<EditText>(R.id.wordsET)
        val run = findViewById<Button>(R.id.runBtn)
        run.setOnClickListener { v: View? ->
            if (!wordsInput.text.toString().isEmpty()) {
                val words = wordsInput.text.toString().toInt()
                if (words < 5 || words > 20) {
                    Toast.makeText(
                        this,
                        "Data not in range! Correct range: 5-20",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val intent = Intent(this@MainActivity, PresentDataActivity::class.java)
                    intent.putExtra("numberOfWords", words)
                    startActivity(intent)
                }
            } else {
                Toast.makeText(this, "Input data!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}