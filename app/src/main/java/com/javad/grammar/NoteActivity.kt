package com.javad.grammar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NoteActivity : AppCompatActivity(), NoteClickInterface, NoteClickDeleteInterface {

    lateinit var noteRecyclerView: RecyclerView
    lateinit var floatingActionButton: FloatingActionButton
    lateinit var viewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        noteRecyclerView = findViewById(R.id.noteRecyclerView)
        floatingActionButton = findViewById(R.id.fabNote)
        noteRecyclerView.layoutManager = LinearLayoutManager(this)

        val noteAdapter = NoteRecyclerviewAdapter(this, this, this)
        noteRecyclerView.adapter = noteAdapter
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[NoteViewModel::class.java]
        viewModel.allNotes.observe(this, Observer { list ->
            list?.let {
                noteAdapter.updateList(it)
            }
        })
        floatingActionButton.setOnClickListener {
            val intent = Intent(this@NoteActivity, AddEditNoteActivity::class.java)
            startActivity(intent)
            this.finish()
        }

    }

    override fun onNoteClick(note: Note) {
        val intent = Intent(this@NoteActivity, AddEditNoteActivity::class.java)
        intent.putExtra("noteType","Edit")
        intent.putExtra("noteTitle",note.noteTitle)
        intent.putExtra("noteDescription",note.noteDescription)
        intent.putExtra("noteID",note.id)
        startActivity(intent)
        this.finish()
    }

    override fun onDeleteIconClick(note: Note) {
viewModel.deleteNote(note)
        Toast.makeText(this,"${note.noteTitle} Deleted!",Toast.LENGTH_SHORT).show()
    }
}