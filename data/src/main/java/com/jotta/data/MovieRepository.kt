package com.jotta.data

import com.jotta.data.datasources.RemoteDataSource
import com.jotta.domain.Movie

class MovieRepository(private val remoteDataSource: RemoteDataSource) {
    fun getPopularMovies() = remoteDataSource.getPopularMovies()

}

