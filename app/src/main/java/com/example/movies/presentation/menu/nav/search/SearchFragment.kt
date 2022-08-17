package com.example.movies.presentation.menu.nav.search

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies.presentation.menu.nav.search.adapter.HeroAdapter
import com.example.movies.databinding.FragmentSearchBinding
import com.example.movies.domain.model.MovieModel
import com.example.movies.domain.usecase.movie.GetMoviesUseCase
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private val viewModel : SearchViewModel by viewModels()
    private lateinit var movies : List<MovieModel>

    @Inject lateinit var getMoviesUseCase: GetMoviesUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.moviesList.observe(this, Observer(::setMovieList))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getMovies()
        binding.svSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {

            @SuppressLint("NotifyDataSetChange")
            override fun onQueryTextSubmit(query: String): Boolean {
                binding.svSearch.clearFocus()
                if (movies.any{ movieModel -> movieModel.title.contains(query, ignoreCase = true) }){
                    val adapter = HeroAdapter(movies.filter { it.title.contains(query, ignoreCase = true) })
                    binding.reciclerView.adapter = adapter
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (movies.any { movieModel ->
                        movieModel.title.contains(
                            newText ?: "",
                            ignoreCase = true
                        )
                    }) {
                    val adapter = HeroAdapter(movies.filter {
                        it.title.contains(
                            newText ?: "",
                            ignoreCase = true
                        )
                    })
                    binding.reciclerView.adapter = adapter
                }
                return true
            }
        })
    }

    private fun initRecycler() {
       binding.reciclerView.layoutManager = LinearLayoutManager(activity)
       val adapter = HeroAdapter(movies)
       binding.reciclerView.adapter = adapter
    }

    private fun setMovieList(movies: List<MovieModel>) {
        this.movies = movies
        initRecycler()
    }
}

