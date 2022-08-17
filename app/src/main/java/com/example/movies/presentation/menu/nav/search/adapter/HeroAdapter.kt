package com.example.movies.presentation.menu.nav.search.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import com.example.movies.domain.model.MovieModel
import com.example.movies.presentation.menu.nav.search.SearchFragmentDirections
import com.squareup.picasso.Picasso

class HeroAdapter(private val movie:List<MovieModel>): RecyclerView.Adapter<HeroAdapter.HeroHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder { //Devuelve el objeto  holder que se le paso
        val layoutInflater =  LayoutInflater.from(parent.context)
        return HeroHolder(layoutInflater.inflate(R.layout.worlist_items, parent, false))
    }

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        holder.render(movie[position]) //Coge la posicion en la lista y la pasa al holder
    }

    override fun getItemCount(): Int = movie.size //Nos permite saber cuanto items hay




    inner class HeroHolder(private val view:View): RecyclerView.ViewHolder(view),
        View.OnClickListener {
        private val textViewName: TextView = view.findViewById(R.id.tvSuperHeroName)
        private val textPublisher: TextView = view.findViewById(R.id.tvPublisher)
        private val textView: TextView = view.findViewById(R.id.tvRealName)
        private val ivHero: ImageView = view.findViewById(R.id.ivHero)


        fun render(movie: MovieModel) {
            textViewName.text = movie.title
            textPublisher.text = movie.release_date
            textView.text = movie.original_title
            Picasso.get().load(movie.posterUrlPath).into(ivHero)
            view.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val action = SearchFragmentDirections.actionSearchFragmentToDetailFragment(movie[layoutPosition])
            view?.findNavController()?.navigate(action)
        }
    }
}