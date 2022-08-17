package com.example.movies.presentation.menu.nav.init.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import com.example.movies.domain.model.RandomModel
import com.squareup.picasso.Picasso


class InitAdapter(private val random:List<RandomModel>): RecyclerView.Adapter<InitAdapter.InitHolder>() {


    class InitHolder(private val view: View): RecyclerView.ViewHolder(view){
        private val imageView: ImageView = view.findViewById(R.id.ivImage)
        private val titleView: TextView = view.findViewById(R.id.tvTitle)

        fun renderInit(random: RandomModel) {
            Picasso.get().load(random.posterUrlPath).into(imageView)
            titleView.text = random.original_title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InitHolder {
        val layoutInflater =  LayoutInflater.from(parent.context)
        return InitHolder(layoutInflater.inflate(R.layout.init_items, parent, false))
    }

    override fun onBindViewHolder(holder: InitHolder, position: Int) {
        holder.renderInit(random[position])
    }

    override fun getItemCount(): Int = random.size

}