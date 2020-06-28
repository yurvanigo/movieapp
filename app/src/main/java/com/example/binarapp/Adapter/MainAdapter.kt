package com.example.binarapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.binarapp.Model.Genre
import com.example.binarapp.R
import com.example.binarapp.viewmodel.ItemMovieViewModel
import com.example.binarapp.databinding.ItemMovieBinding

class MainAdapter(val context: Context): RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    protected var genres: MutableList<Genre> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemMovieBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_movie, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
      return genres.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(genres[holder.adapterPosition])
    }

    fun setData(genre: MutableList<Genre>){
        this.genres = genre
    }

    class ViewHolder (private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: Genre){
            val viewModel = ItemMovieViewModel(model)
            binding.itemGenre = viewModel

        }
    }

}