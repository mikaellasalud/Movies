package com.globe.movies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvMovies: RecyclerView
    private val movieAdapter = MovieAdapter()

    private val movies: ArrayList<Movie> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMovies = findViewById(R.id.rvMovies)
        rvMovies.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        movieAdapter.onItemClickListener = object:OnItemClickListener{

            override fun onItemClicked(position: Int) {
                Log.d("MainActivity", "$position")
                val selectedMovie = movieAdapter.movies.get(position)
                Log.d("MainActivity", "Selected Movie: $selectedMovie")
                showMovieDetails(position)
            }
        }

        initializeMovies()


    }

    private fun showMovieDetails(moviePosition: Int) {
        val selectedMovie = movieAdapter.movies.get(moviePosition)

        val movieDetailIntent = Intent(this, MovieDetailActivity::class.java)
        movieDetailIntent.putExtra(Constants.TITLE, selectedMovie.title)
        movieDetailIntent.putExtra(Constants.POSTER, selectedMovie.poster)
        movieDetailIntent.putExtra(Constants.RATING, selectedMovie.rating)
        movieDetailIntent.putExtra(Constants.PLOT, selectedMovie.plot)

        startActivity(movieDetailIntent)


        Log.d("MainActivity", "Selected Movie:$selectedMovie")
    }

    private fun initializeMovies(){
        movies.add(Movie("Thor",R.drawable.thor,3.0F, "Thor embarks on a journey unlike anything he's ever faced -- a quest for inner peace. However, his retirement gets interrupted by Gorr the God Butcher, a galactic killer who seeks the extinction of the gods. To combat the threat, Thor enlists the help of King Valkyrie, Korg and ex-girlfriend Jane Foster, who -- to his surprise -- inexplicably wields his magical hammer. Together, they set out on a harrowing cosmic adventure to uncover the mystery of the God Butcher's vengeance.\n" ))
        movies.add(Movie("Captain America",R.drawable.captainamerica,4.5F, "It is 1941 and the world is in the throes of war. Steve Rogers (Chris Evans) wants to do his part and join America's armed forces, but the military rejects him because of his small stature. Finally, Steve gets his chance when he is accepted into an experimental program that turns him into a supersoldier called Captain America. Joining forces with Bucky Barnes (Sebastian Stan) and Peggy Carter (Hayley Atwell), Captain America leads the fight against the Nazi-backed HYDRA organization."))
        movies.add(Movie("Captain Marvel",R.drawable.captainmarvel,4.0F, "Captain Marvel is an extraterrestrial Kree warrior who finds herself caught in the middle of an intergalactic battle between her people and the Skrulls. Living on Earth in 1995, she keeps having recurring memories of another life as U.S. Air Force pilot Carol Danvers. With help from Nick Fury, Captain Marvel tries to uncover the secrets of her past while harnessing her special superpowers to end the war with the evil Skrulls.\n"))
        movies.add(Movie("SpiderMan",R.drawable.spiderman,5.0F, "With Spider-Man's identity now revealed, our friendly neighborhood web-slinger is unmasked and no longer able to separate his normal life as Peter Parker from the high stakes of being a superhero. When Peter asks for help from Doctor Strange, the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.\n"))
        movies.add(Movie("Iron Man",R.drawable.ironman,5.0F, "With the world now aware that he is Iron Man, billionaire inventor Tony Stark (Robert Downey Jr.) faces pressure from all sides to share his technology with the military. He is reluctant to divulge the secrets of his armored suit, fearing the information will fall into the wrong hands. With Pepper Potts (Gwyneth Paltrow) and \"Rhodey\" Rhodes (Don Cheadle) by his side, Tony must forge new alliances and confront a powerful new enemy.\n"))
        movies.add(Movie("Ant Man",R.drawable.antman,4.0F, "Forced out of his own company by former protégé Darren Cross, Dr. Hank Pym (Michael Douglas) recruits the talents of Scott Lang (Paul Rudd), a master thief just released from prison. Lang becomes Ant-Man, trained by Pym and armed with a suit that allows him to shrink in size, possess superhuman strength and control an army of ants. The miniature hero must use his new skills to prevent Cross, also known as Yellowjacket, from perfecting the same technology and using it as a weapon for evil.\n"))
        movies.add(Movie("Avengers",R.drawable.avengers,5.0F, "Adrift in space with no food or water, Tony Stark sends a message to Pepper Potts as his oxygen supply starts to dwindle. Meanwhile, the remaining Avengers -- Thor, Black Widow, Captain America and Bruce Banner -- must figure out a way to bring back their vanquished allies for an epic showdown with Thanos -- the evil demigod who decimated the planet and the universe.\n"))
        movies.add(Movie("ShangChi",R.drawable.shangchi,4.0F, "Martial-arts master Shang-Chi confronts the past he thought he left behind when he's drawn into the web of the mysterious Ten Rings organization.\n"))
        movies.add(Movie("Doctor Strange",R.drawable.doctorstrange,3.0F, "Doctor Strange teams up with a mysterious teenage girl from his dreams who can travel across multiverses, to battle multiple threats, including other-universe versions of himself, which threaten to wipe out millions across the multiverse.\n"))
        movies.add(Movie("Black Panther",R.drawable.blackpanther,4.0F, "After the death of his father, T'Challa returns home to the African nation of Wakanda to take his rightful place as king. When a powerful enemy suddenly reappears, T'Challa's mettle as king -- and as Black Panther -- gets tested when he's drawn into a conflict that puts the fate of Wakanda and the entire world at risk. Faced with treachery and danger, the young king must rally his allies and release the full power of Black Panther to defeat his foes and secure the safety of his people.\n"))

        movieAdapter.movies = movies

        rvMovies.adapter = movieAdapter
    }
}