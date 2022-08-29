package com.javad.grammar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GrammarAdapter(private val grammarList: ArrayList<Grammar>) :
    RecyclerView.Adapter<GrammarAdapter.GrammarViewHolder>() {

    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }

    class GrammarViewHolder(itemView: View, listener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GrammarViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        return GrammarViewHolder(view,mListener)
    }

    override fun onBindViewHolder(holder: GrammarViewHolder, position: Int) {

        val grammar = grammarList[position]
        holder.imageView.setImageResource(grammar.image)
        holder.textView.text = grammar.topic
    }

    override fun getItemCount(): Int {

        return grammarList.size
    }
}