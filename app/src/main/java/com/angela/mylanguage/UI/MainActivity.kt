package com.angela.mylanguage.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.angela.mylanguage.R
import com.angela.mylanguage.ViewModel.LanguageViewModel
import com.angela.mylanguage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: LanguageViewModel
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(LanguageViewModel::class.java)
        val adapter = LanguageAdapter(emptyList())
        binding.tvTitle.text= adapter.languages.toString()
        binding.tvBody.text= adapter.languages.toString()
        viewModel.languages.observe(this,{ languages ->
            adapter.submitList(languages)

        })

        }



    }

