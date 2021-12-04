package com.example.islamiapp.ui.suraDetails

import android.os.Bundle
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.R
import com.example.islamiapp.ui.Constants

class SuraDetailsActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: VersesAdapter
    lateinit var titleTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        titleTextView = findViewById(R.id.title_text_view)
        recyclerView = findViewById(R.id.recycler_view)
        adapter = VersesAdapter()
        recyclerView.adapter = adapter

        val suraName : String = intent.getStringExtra(Constants.EXTRA_SURA_NAME) as String
        val suraPosition  = intent.getIntExtra(Constants.EXTRA_SURA_POSITION,-1)
        titleTextView.setText(suraName)
        readSuraFile("${suraPosition+1}.txt")

    }

     fun readSuraFile(fileName : String) {
         val fileContent: String = assets.open(fileName).bufferedReader().use { it.readText() }
         val lines: List<String> = fileContent.split("\n")
         adapter.changeData(lines)
     }
    // logic back arrow
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}