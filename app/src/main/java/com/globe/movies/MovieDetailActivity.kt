package com.globe.movies

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MovieDetailActivity: AppCompatActivity() {

    private lateinit var ivDMoviePoster: ImageView
    private lateinit var tvDMovieTitle: TextView
    private lateinit var rbDMovieRating: RatingBar
    private lateinit var tvPlot: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        ivDMoviePoster = findViewById(R.id.ivDMoviePoster)
        tvDMovieTitle = findViewById(R.id.tvDMovieTitle)
        rbDMovieRating = findViewById(R.id.rbDMovieRating)
        tvPlot = findViewById(R.id.tvPlot)


        val title = intent.getStringExtra(Constants.TITLE)
        val poster = intent.getIntExtra(Constants.POSTER,0)
        val plot = intent.getStringExtra(Constants.PLOT)
        val rating = intent.getFloatExtra(Constants.RATING,0.0F)

        tvDMovieTitle.setText(title!!)
        tvPlot.setText(plot!!)
        ivDMoviePoster.setImageResource(poster!!)
        rbDMovieRating.rating = rating
    }
}