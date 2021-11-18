package com.gmail.devpelegrino.moplim.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.gmail.devpelegrino.moplim.databinding.ItemCommentsBinding
import com.gmail.devpelegrino.moplim.network.entity.ItemReview
import com.gmail.devpelegrino.moplim.network.entity.ReviewListEntity

class MovieReviewAdapter : RecyclerView.Adapter<MovieReviewAdapter.MovieReviewViewHolder>() {

    private var _movieReview = emptyList<ItemReview>().toMutableList()
    private var _lastMovieReviewRecyclerView = MutableLiveData<Boolean>(false)
    val lastMovieReviewRecyclerView: LiveData<Boolean>
        get() = _lastMovieReviewRecyclerView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieReviewViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCommentsBinding.inflate(inflater, parent, false)

        return MovieReviewViewHolder(binding)
    }

    fun setMovieReview(movies: ReviewListEntity) {
        if (_movieReview.isEmpty()) {
            _movieReview = movies.results as MutableList<ItemReview>
        } else {
            var iterator = movies.results.iterator()
            do {
                _movieReview.add(iterator.next())
            } while (iterator.hasNext())
        }
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MovieReviewViewHolder, position: Int) {
        holder.bind(_movieReview[position])
        checkLastItems(position)
    }

    override fun getItemCount(): Int {
        var count = 0
        if (_movieReview != null) {
            count = _movieReview.size
        }

        return count
    }

    fun setLastMovieReviewRecyclerView() {
        _lastMovieReviewRecyclerView.value = false
    }

    private fun checkLastItems(position: Int) {
        if (position > _movieReview.size - 4) {
            _lastMovieReviewRecyclerView.value = true
        }
    }

    class MovieReviewViewHolder(private val binding: ItemCommentsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(review: ItemReview) {
            binding.itemCommentUsername.text = review.author
            binding.itemComment.text = review.content
        }
    }
}