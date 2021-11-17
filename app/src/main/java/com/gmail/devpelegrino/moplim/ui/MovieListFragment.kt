package com.gmail.devpelegrino.moplim.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.gmail.devpelegrino.moplim.adapter.MovieListAdapter
import com.gmail.devpelegrino.moplim.databinding.MovieListFragmentBinding
import com.gmail.devpelegrino.moplim.factory.MovieListViewModelFactory
import com.gmail.devpelegrino.moplim.viewmodel.MovieListViewModel

class MovieListFragment : Fragment() {

    private lateinit var viewModel: MovieListViewModel
    private lateinit var binding: MovieListFragmentBinding
    private lateinit var adapterNowPlaying: MovieListAdapter
    private lateinit var adapterTopRated: MovieListAdapter
    private lateinit var adapterUpComing: MovieListAdapter
    private lateinit var adapterPopular: MovieListAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MovieListFragmentBinding.inflate(inflater)

        setConfigurations()

        return binding.root
    }

    private fun setConfigurations() {
        setViewModel()
        binding.viewModel = viewModel
        setRecyclerViews()
        setObservers()
    }

    private fun setViewModel() {
        viewModel = ViewModelProvider(this, MovieListViewModelFactory(viewLifecycleOwner)).get(
            MovieListViewModel::class.java
        )
    }

    private fun setRecyclerViews() {
        adapterNowPlaying = MovieListAdapter()
        adapterPopular = MovieListAdapter()
        adapterTopRated = MovieListAdapter()
        adapterUpComing = MovieListAdapter()
        binding.recyclerNowPlaying.adapter = adapterNowPlaying
        binding.recyclerPopular.adapter = adapterPopular
        binding.recyclerTopRated.adapter = adapterTopRated
        binding.recyclerUpcoming.adapter = adapterUpComing
    }

    private fun setObservers() {
        setObserverNowPlaying()
        setObserverPopular()
        setObserverTopRated()
        setObserverUpComing()
    }

    private fun setObserverNowPlaying() {
        viewModel.moviesNowPlaying.observe(viewLifecycleOwner,
            Observer {
                if(it.isNotEmpty()) {
                    adapterNowPlaying.setMovies(it)
                }
            })
        viewModel.callApiGetMoviesNowPlaying()
    }

    private fun setObserverPopular() {
        viewModel.moviesPopular.observe(viewLifecycleOwner,
            Observer {
                if(it.isNotEmpty()) {
                    adapterPopular.setMovies(it)
                }
            })
        viewModel.callApiGetMoviesPopular()
    }

    private fun setObserverTopRated() {
        viewModel.moviesTopRated.observe(viewLifecycleOwner,
            Observer {
                if(it.isNotEmpty()) {
                    adapterTopRated.setMovies(it)
                }
            })
        viewModel.callApiGetMoviesTopRated()
    }

    private fun setObserverUpComing() {
        viewModel.moviesUpComing.observe(viewLifecycleOwner,
            Observer {
                if(it.isNotEmpty()) {
                    adapterUpComing.setMovies(it)
                }
            })
        viewModel.callApiGetMoviesUpComing()
    }
}