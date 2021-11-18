package com.gmail.devpelegrino.moplim.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.gmail.devpelegrino.moplim.network.entity.Genre

class BindingAdapters {


    companion object {
        val BASE_URL = "https://image.tmdb.org/t/p/w400"

        @JvmStatic
        @BindingAdapter("imageUrl")
        fun loadImage(view: ImageView, url: String?) {
            if(url != null) {
                Glide.with(view.context).load(BASE_URL + url).into(view)
            }
        }

        @JvmStatic
        @BindingAdapter("time")
        fun loadTime(view: TextView, time: Int?) {
            if(time != null) {
                view.text = "${time/60} hora(s) ${time%60} minuto(s)"
            }
        }

        @JvmStatic
        @BindingAdapter("setVotes")
        fun loadVotes(view: TextView, votes: Float?) {
            if(votes != null) {
                view.text = "${votes.toString()} / 10 Média de Votos"
            }
        }

        @JvmStatic
        @BindingAdapter("genres")
        fun loadGenres(view: TextView, genres: List<Genre>?) {
            if(genres != null) {
                var genreFormatted = ""
                val iterator = genres.iterator()
                do {
                    var element = iterator.next()
                    genreFormatted += element.name + " • "
                } while (iterator.hasNext())

                if(genreFormatted.lastIndexOf("• ") != -1) {
                    genreFormatted = genreFormatted.substring(0, genreFormatted.length - 3)
                }

                view.text = genreFormatted
            }
        }
    }
}