package com.gmail.devpelegrino.moplim.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.gmail.devpelegrino.moplim.adapter.MovieListAdapter
import com.gmail.devpelegrino.moplim.databinding.MovieListFragmentBinding
import com.gmail.devpelegrino.moplim.factory.MovieListViewModelFactory
import com.gmail.devpelegrino.moplim.model.Movie
import com.gmail.devpelegrino.moplim.viewmodel.MovieListViewModel

class MovieListFragment : Fragment() {

    private lateinit var viewModel: MovieListViewModel
    private lateinit var binding: MovieListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val activity = requireNotNull(this.activity) {}
        viewModel = ViewModelProvider(this, MovieListViewModelFactory(activity.application)).get(
            MovieListViewModel::class.java
        )

        binding = MovieListFragmentBinding.inflate(inflater)

        binding.viewModel = viewModel

        var adapter = MovieListAdapter(requireContext())
        adapter.setMovies(
            listOf(
                Movie(null, null),
                Movie(null, null),
                Movie(null, null),
                Movie(null, null),
                Movie(null, null),
                Movie(null, null),
                Movie(null, null),
                Movie(null, null),
                Movie(null, null),
                Movie(null, null),
                Movie(null, null)
            )
        )

        binding.recyclerNowPlaying.adapter = adapter
        binding.recyclerPopular.adapter = adapter
        binding.recyclerTopRated.adapter = adapter
        binding.recyclerUpcoming.adapter = adapter


//        binding.buttonTest.setOnClickListener {
//            val action = MovieListFragmentDirections.actionMovieListFragmentToMovieDetailsFragment()
//            Navigation.findNavController(it).navigate(action)
//        }

        return binding.root
    }
}