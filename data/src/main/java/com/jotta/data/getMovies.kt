package com.jotta.data

import com.jotta.domain.Movie

fun getMovies() = (1..10).map{
    Movie(it, "Title $it", "https://loremflickr.com/200/400/cat")
}