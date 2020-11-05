package com.example.android.apiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.android.apiapp.repository.Repository
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TextView
        val textTitle : TextView = findViewById<TextView>(R.id.title_text_api)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response ->

            if(response.isSuccessful) {
                //Log.d("Response", response.userId.toString())
                //Log.d("Response", response.id.toString())
                //Log.d("Response", response.title)
                //Log.d("Response", response.body)

                // Display Text in App
                textTitle.text = response.body()?.title!!
            } else {
                Log.d("Response", response.errorBody().toString()) // 404 message
                textTitle.text = response.code().toString()
            }
        })
    }
}
