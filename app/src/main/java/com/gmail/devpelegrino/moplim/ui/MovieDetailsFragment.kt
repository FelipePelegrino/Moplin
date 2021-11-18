package com.gmail.devpelegrino.moplim.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.gmail.devpelegrino.moplim.R
import com.gmail.devpelegrino.moplim.adapter.MovieListAdapter
import com.gmail.devpelegrino.moplim.adapter.MovieReviewAdapter
import com.gmail.devpelegrino.moplim.databinding.MovieDetailsFragmentBinding
import com.gmail.devpelegrino.moplim.factory.MovieDetailsViewModelFactory
import com.gmail.devpelegrino.moplim.util.internetIsConnected
import com.gmail.devpelegrino.moplim.util.isNetworkConnected
import com.gmail.devpelegrino.moplim.viewmodel.MovieDetailsViewModel

class MovieDetailsFragment : Fragment() {

    private lateinit var args: MovieDetailsFragmentArgs
    private lateinit var viewModel: MovieDetailsViewModel
    private lateinit var bindingFragment: MovieDetailsFragmentBinding
    private lateinit var adapterSimilarMovies: MovieListAdapter
    private lateinit var adapterReviews: MovieReviewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bindingFragment = MovieDetailsFragmentBinding.inflate(inflater)
        bindingFragment.lifecycleOwner = viewLifecycleOwner
        bindingFragment.headerDetails.lifecycleOwner = viewLifecycleOwner
        bindingFragment.listReviews.lifecycleOwner = viewLifecycleOwner

        initVariables()
        setConfigurations()

        return bindingFragment.root
    }

    override fun onStart() {
        super.onStart()
        if(!isNetworkConnected(requireContext())) {
            Toast.makeText(requireContext(), R.string.error_network_not_connected, Toast.LENGTH_SHORT).show()
        } else if(!internetIsConnected()) {
            Toast.makeText(requireContext(), R.string.error_network_not_connected, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setViewModel() {
        viewModel = ViewModelProvider(this, MovieDetailsViewModelFactory(viewLifecycleOwner, requireContext())).get(
            MovieDetailsViewModel::class.java
        )
    }

    private fun initVariables() {
        args = MovieDetailsFragmentArgs.fromBundle(requireArguments())
    }

    private fun setConfigurations() {
        setViewModel()
        bindingFragment.viewModel = viewModel
        bindingFragment.headerDetails.viewModel = viewModel
        setRecyclerViews()
        setObservers()
        backButtonAction()
    }

    private fun setRecyclerViews() {
        adapterSimilarMovies = MovieListAdapter { position -> actionClickSimilarMovies(position) }
        adapterReviews = MovieReviewAdapter()
        bindingFragment.recyclerSimilarMovies.adapter = adapterSimilarMovies
        bindingFragment.listReviews.recyclerComments.adapter = adapterReviews
    }

    private fun actionClickSimilarMovies(position: Int) {
        //TODO: tratar atualizar fragment
        adapterSimilarMovies.getMovieId(position)
    }

    private fun setObservers() {
        setObserverSimilarMovies()
        setObserverDetailsMovie()
        setObserverMovieReview()
    }

    private fun setObserverDetailsMovie() {
        viewModel.callApiGetDetailsMovie(args.movieId)
    }

    private fun setObserverSimilarMovies() {
        viewModel.similarMovies.observe(viewLifecycleOwner,
            Observer {
                if (it.isNotEmpty()) {
                    adapterSimilarMovies.setMovies(it)
                }
            })
        viewModel.callApiGetSimilarMovies(args.movieId)

        adapterSimilarMovies.lastMoviesRecyclerView.observe(viewLifecycleOwner,
            Observer {
                if (it) {
                    adapterSimilarMovies.setLastMoviesFalse()
                    viewModel.updatePageSimilarMovies()
                    viewModel.callApiGetSimilarMovies(args.movieId)
                }
            })
    }

    fun setObserverMovieReview() {
        viewModel.movieReview.observe(viewLifecycleOwner,
            Observer {
                if (it.results.isNotEmpty()) {
                    adapterReviews.setMovieReview(it)
                }
            })
        viewModel.callApiGetMovieReview(args.movieId)

        adapterReviews.lastMovieReviewRecyclerView.observe(viewLifecycleOwner,
            Observer {
                if (it) {
                    adapterReviews.setLastMovieReviewRecyclerView()
                    viewModel.updatePageMovieReview()
                    viewModel.callApiGetMovieReview(args.movieId)
                }
            })
    }

    private fun backButtonAction() {
        bindingFragment.headerDetails.imageBackButton.setOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }
    }
}