package com.jotta.mvvm.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.jotta.mvvm.R

class MainActivity : AppCompatActivity() {

    //Acceder al ViewModel mediante un delegado
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Ahora nos tendríamos que suscribir a todos los ViewModel que hemos creado
        viewModel.onCreate()

        /*viewModel.movies.observe(this, {
            moviesAdapter.movies = it
        })*/

        viewModel.progressVisible.observe(this){

        }

        viewModel.showMessage.observe(this){
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
    }
}