package com.jotta.usecases

import com.jotta.data.MovieRepository
import com.jotta.data.getMovies
import com.jotta.domain.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

//import kotlinx.coroutines.Dispatchers

class LoadPopularMovies(repository: MovieRepository) {

    //Función de suspensión: Funcion que se puede pausar y reanudar en un momento posterior. Se
    suspend fun invoke(): List<Movie> = withContext(Dispatchers.IO) {
        delay(2000)
        getMovies()

    }
}