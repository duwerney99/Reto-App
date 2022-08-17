package com.example.movies.presentation.menu.nav.init

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies.databinding.FragmentInitBinding
import com.example.movies.presentation.menu.nav.init.adapter.InitAdapter
import com.example.movies.domain.model.RandomModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InitFragment : Fragment() {

    private lateinit var binding: FragmentInitBinding
    private val randomModel : InitViewModel by viewModels()
    private lateinit var randoms : List<RandomModel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        randomModel.randomList.observe(this, Observer(::getRandomList))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInitBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        randomModel.getRandoms()
    }

    private fun recyclerInit() {
        binding.rvInit.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false )
        val adapter = InitAdapter(randoms)
        binding.rvInit.adapter = adapter
    }

    private fun getRandomList(randoms: List<RandomModel>) {
        this.randoms = randoms
        recyclerInit()
    }
}