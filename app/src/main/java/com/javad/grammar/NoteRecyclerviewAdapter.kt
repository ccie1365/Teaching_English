package com.javad.grammar

import android.app.AlertDialog
import android.content.Context
import android.system.Os.close
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlin.system.exitProcess

class NoteRecyclerviewAdapter(
    val context: Context,
    val noteClickInterface: NoteClickInterface,
    val noteClickDeleteInterface: NoteClickDeleteInterface
) : RecyclerView.Adapter<NoteRecyclerviewAdapter.ViewHolder>() {

    private val allNotes = ArrayList<Note>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val noteTextView = itemView.findViewById<TextView>(R.id.noteTitle)
        val timeTextView = itemView.findViewById<TextView>(R.id.noteTime)
        val deleteView = itemView.findViewById<ImageView>(R.id.imageDelete)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.note_rv_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.noteTextView.text = allNotes[position].noteTitle
        holder.timeTextView.text = "Last updated : " + allNotes[position].timeStamp

        holder.deleteView.setOnClickListener {
            MaterialAlertDialogBuilder(context)
                .setTitle("Alert")
                .setMessage("Do you want to delete?")
                .setNegativeButton("No"){_,_-> }


                .setPositiveButton("Yes"){ _, _ ->
                    noteClickDeleteInterface.onDeleteIconClick(allNotes[position])
                }
                .show()

        }
        holder.itemView.setOnClickListener {
            noteClickInterface.onNoteClick(allNotes[position])
        }
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }



    fun updateList(newList: List<Note>) {
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }
}

interface NoteClickDeleteInterface {
    fun onDeleteIconClick(note: Note)
}

interface NoteClickInterface {
    fun onNoteClick(note: Note)
}
