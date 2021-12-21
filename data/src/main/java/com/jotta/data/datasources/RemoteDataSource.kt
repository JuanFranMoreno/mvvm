package com.jotta.data.datasources

import com.jotta.domain.Movie

interface RemoteDataSource{
    fun getPopularMovies(): List<Movie>
}