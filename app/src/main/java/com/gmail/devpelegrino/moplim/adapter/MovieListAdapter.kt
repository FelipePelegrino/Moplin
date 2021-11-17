package com.gmail.devpelegrino.moplim.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gmail.devpelegrino.moplim.databinding.ItemMovieListBinding
import com.gmail.devpelegrino.moplim.model.Movie

class MovieListAdapter(private val _itemMovieListener: (position: Int) -> Unit) :
    RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>() {

    private var _movies: MutableList<Movie> = emptyList<Movie>().toMutableList()
    private var _lastMoviesRecyclerView = MutableLiveData<Boolean>(false)
    val lastMoviesRecyclerView: LiveData<Boolean>
        get() = _lastMoviesRecyclerView

    fun getMovieId(position: Int): Int {
        return _movies[position].id!!
    }

    fun setMovies(movies: MutableList<Movie>) {
        if (_movies.isEmpty()) {
            _movies = movies
        } else {
            var iterator = movies.iterator()
            do {
                _movies.add(iterator.next())
            } while (iterator.hasNext())
        }

        notifyDataSetChanged()
    }

    fun setLastMoviesFalse() {
        _lastMoviesRecyclerView.value = false
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieListBinding.inflate(inflater, parent, false)

        return MovieViewHolder(binding, _itemMovieListener)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(_movies[position])
        checkLastItems(position)
    }

    override fun getItemCount(): Int = _movies.size

    private fun checkLastItems(position: Int) {
        if (position > _movies.size - 4) {
            _lastMoviesRecyclerView.value = true
        }
    }

    class MovieViewHolder(
        private val binding: ItemMovieListBinding,
        private val onItemClicked: (id: Int) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            binding.imageItemPoster.setOnClickListener(this)
        }

        fun bind(movie: Movie) {
            val BASE_URL = "https://image.tmdb.org/t/p/w400"

            Glide.with(binding.imageItemPoster.context)
                .load(BASE_URL + movie.posterPath)
                .into(binding.imageItemPoster)
        }

        override fun onClick(v: View?) {
            onItemClicked(adapterPosition)
        }
    }
}

