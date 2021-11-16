package com.gmail.devpelegrino.moplim.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gmail.devpelegrino.moplim.databinding.ItemMovieListBinding
import com.gmail.devpelegrino.moplim.model.Movie

class MovieListAdapter(private val _context: Context) :
    RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>() {

    private var _movies: List<Movie> = emptyList()

    fun setMovies(movies: List<Movie>) {
        _movies = movies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieListBinding.inflate(inflater, parent, false)

        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(_movies[position])
    }

    override fun getItemCount(): Int = _movies.size

    class MovieViewHolder(private val binding: ItemMovieListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {

        }
    }
}

