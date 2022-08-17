package com.example.movies.presentation.menu.nav.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies.databinding.FragmentProfileBinding
import com.example.movies.presentation.menu.nav.profile.adapter.ProfileAdapter
import com.example.movies.domain.model.InteractionModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private val interactionModel : ProfileViewModel by viewModels()
    private lateinit var interactions: List<InteractionModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        interactionModel.interactionList.observe(this, Observer(::setInteractionsList))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        interactionModel.getInteractions()
    }


    private fun recyclerProfile() {
        binding.rvProfile.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false )
        val adapter = ProfileAdapter(interactions)
        binding.rvProfile.adapter = adapter
    }

    private fun setInteractionsList(interactions: List<InteractionModel>) {
        this.interactions = interactions
        recyclerProfile()
    }
}