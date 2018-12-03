package com.pedromassango.crypto.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pedromassango.crypto.data.Symbol

import com.pedromassango.crypto.R
import com.pedromassango.crypto.data.SymbolDetails
import kotlinx.android.synthetic.main.row_item.view.*

class SymbolHolder(val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(symbol: SymbolDetails) {
        with(view){
            tv_details.text = symbol.append()
        }
    }
}

class SymbolsAdapter(
    private val data: MutableList<SymbolDetails> = mutableListOf()
) : RecyclerView.Adapter<SymbolHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SymbolHolder {
        return SymbolHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: SymbolHolder, position: Int) {
        holder.bind(data[position])
    }

    fun add(symbols: List<SymbolDetails>){
        data.clear()
        data.addAll(symbols)
        notifyDataSetChanged()
    }

    fun add(symbol: SymbolDetails){
        data.add(symbol)
        notifyDataSetChanged()
    }

    fun update(symbol: SymbolDetails){
        try {
            val item = data.find { it.assetId == symbol.assetId }
            val index = data.indexOf(item)
            notifyItemChanged(index, symbol)
        }catch (e: NoSuchElementException){
            e.printStackTrace()
            // Item not found, insert as first time
            add(symbol)

        }
    }
}