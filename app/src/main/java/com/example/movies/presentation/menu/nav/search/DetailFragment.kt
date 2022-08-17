package com.example.movies.presentation.menu.nav.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.movies.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.topAppBar.setOnClickListener{
            activity?.onBackPressed()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvGirl.text = args.movie.title
        binding.topAppBar.title = args.movie.title
        binding.tvInfo.text = args.movie.original_title
        binding.tvYear.text = args.movie.release_date
        binding.tvInformation.text = args.movie.overview
        Picasso.get().load(args.movie.posterUrlPath).into(binding.ivCenter)
        Picasso.get().load(args.movie.backdrop_path).into(binding.ivGambit)
        args.movie
    }
}