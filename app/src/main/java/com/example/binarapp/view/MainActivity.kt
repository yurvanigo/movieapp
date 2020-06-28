package com.example.binarapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.binarapp.Adapter.MainAdapter
import com.example.binarapp.R
import com.example.binarapp.viewmodel.MainViewModel
import com.example.binarapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.main = viewModel

        setupRecyclerView()
        observeLiveData()
        viewModel.getGenre()
    }

    private fun setupRecyclerView(){
        val layoutManager = LinearLayoutManager(this)
        binding.mainRecyclerView.layoutManager = layoutManager
        adapter = MainAdapter(this)
        binding.mainRecyclerView.adapter = adapter

    }
    private fun observeLiveData(){
        viewModel.genres.observe(this, Observer {
            adapter.setData(it?.results!!)
            adapter.notifyDataSetChanged()
        })
        viewModel.error.observe(this, Observer {
            //handle error
        })
    }
}
