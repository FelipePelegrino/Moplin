package com.gmail.devpelegrino.moplim.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gmail.devpelegrino.moplim.databinding.ItemMovieListBinding
import com.gmail.devpelegrino.moplim.model.Movie

class MovieListAdapter() :
    RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>() {

    private var _movies: MutableList<Movie> = emptyList<Movie>().toMutableList()
    private var _lastMoviesRecyclerView = MutableLiveData<Boolean>(false)
    val lastMoviesRecyclerView: LiveData<Boolean>
        get() = _lastMoviesRecyclerView

    fun setMovies(movies: MutableList<Movie>) {
        _movies = movies
        notifyDataSetChanged()
    }

    fun setLastMoviesFalse() {
        _lastMoviesRecyclerView.value = false
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieListBinding.inflate(inflater, parent, false)

        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(_movies[position])
        checkLastItems(position)
    }

    override fun getItemCount(): Int = _movies.size

    private fun checkLastItems(position: Int) {
        if(position > _movies.size - 2) {
            _lastMoviesRecyclerView.value = true
        }
    }

    class MovieViewHolder(private val binding: ItemMovieListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            val BASE_URL = "https://image.tmdb.org/t/p/w400"

            Glide.with(binding.imageItemPoster.context)
                .load(BASE_URL + movie.posterPath)
                .into(binding.imageItemPoster)
        }
    }
}

