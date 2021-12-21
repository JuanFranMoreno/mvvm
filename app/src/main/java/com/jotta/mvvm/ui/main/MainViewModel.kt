package com.jotta.mvvm.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jotta.domain.Movie
import com.jotta.usecases.LoadPopularMovies
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch



class MainViewModel : ViewModel() {

    private val loadPopularMovies = LoadPopularMovies()

    //El LiveData se utiliza para acceder a los elementos de la vista
    //Sólo 1 Live data por elemento.
    private val _progressVisible = MutableLiveData<Boolean>() //LiveData privado para usarlo solo en la clase
    val progressVisible: LiveData<Boolean> get() = _progressVisible //El get de solo lectura que podrán llamar desde fuera

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> get() = _movies

    private val _showMessage = MutableLiveData<String>()
    val showMessage: LiveData<String> get() = _showMessage


    //La pantalla se ha creado y estamos listos para hacer cosas
    fun onCreate(){

        viewModelScope.launch {
            _progressVisible.value = true
            _movies.value = loadPopularMovies.invoke()
            _progressVisible.value = false
        }


    }

    fun onMovieClicked(movie: Movie){
        _showMessage.value = movie.title
    }

}