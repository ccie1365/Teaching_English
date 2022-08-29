package com.javad.grammar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var grammarList: ArrayList<Grammar>
    private lateinit var grammarAdapter: GrammarAdapter
    private lateinit var description: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        description = arrayOf(
            getString(R.string.simple_present),
            getString(R.string.present_continuous),
            getString(R.string.present_perfect),
            getString(R.string.present_perfect_continuous),
            getString(R.string.simple_past),
            getString(R.string.past_continuous),
            getString(R.string.past_perfect),
            getString(R.string.past_perfect_continuous),
            getString(R.string.simple_future),
            getString(R.string.future_continuous),
            getString(R.string.future_perfect),
            getString(R.string.future_perfect_continuous)

        )

        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        grammarList = ArrayList()

        grammarList.add(Grammar(R.drawable.alice, "Simple Present Tense"))
        grammarList.add(Grammar(R.drawable.bear, "Present Continuous Tense"))
        grammarList.add(Grammar(R.drawable.buzz, "Present Perfect Tense"))
        grammarList.add(Grammar(R.drawable.cat, "Present Perfect Continuous Tense"))
        grammarList.add(Grammar(R.drawable.chicken, "Simple Past Tense"))
        grammarList.add(Grammar(R.drawable.duck, "Past Continuous Tense"))
        grammarList.add(Grammar(R.drawable.goofy, "Past Perfect Tense"))
        grammarList.add(Grammar(R.drawable.jerry, "Past Perfect Continuous Tense"))
        grammarList.add(Grammar(R.drawable.hug, "Simple Future Tense"))
        grammarList.add(Grammar(R.drawable.snow, "Future Continuous Tense"))
        grammarList.add(Grammar(R.drawable.rabbit, "Future Perfect Tense"))
        grammarList.add(Grammar(R.drawable.sonic, "Future Perfect Continuous Tense"))

        grammarAdapter = GrammarAdapter(grammarList)
        recyclerView.adapter = grammarAdapter
        grammarAdapter.setOnItemClickListener(object : GrammarAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
            val intent = Intent(this@MainActivity,DescriptionActivity::class.java)
                intent.putExtra("image",grammarList[position].image)
                intent.putExtra("description",description[position])
                startActivity(intent)
            }

        })

    }
}