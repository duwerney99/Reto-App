package com.example.movies.presentation.menu.nav.profile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import com.example.movies.domain.model.InteractionModel

class ProfileAdapter(private val interactions:List<InteractionModel>): RecyclerView.Adapter<ProfileAdapter.ProfileHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileHolder {
        val layoutInflater =  LayoutInflater.from(parent.context)
        return ProfileHolder(layoutInflater.inflate(R.layout.profile_items, parent, false))
    }

    override fun onBindViewHolder(holder: ProfileHolder, position: Int) {
        holder.renderProfile(interactions[position])
    }

    override fun getItemCount(): Int = interactions.size


    class ProfileHolder(private val view: View): RecyclerView.ViewHolder(view) {
        private val tvRecomendation: TextView = view.findViewById(R.id.tvRecomendations)
        private val tvCalification: TextView = view.findViewById(R.id.tvCalifications)
        private val tvIdCalification: TextView = view.findViewById(R.id.tvIdCalification)

        fun renderProfile(interaction: InteractionModel) {
            tvRecomendation.text = interaction.recommendation
            tvCalification.text = interaction.interaction
            tvIdCalification.text = interaction.numberInteraction.toString()
        }

    }
}