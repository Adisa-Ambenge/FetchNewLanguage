package com.angela.mylanguage.UI

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.angela.mylanguage.Model.LanguageData
import com.angela.mylanguage.databinding.ActivityMainBinding

class LanguageAdapter(private val languages: List<LanguageData>) :
    RecyclerView.Adapter<LanguageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ActivityMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val language = languages[position]
        holder.bindLanguage(language)
    }

    override fun getItemCount(): Int {
        return languages.size
    }

    inner class ViewHolder(private val binding: ActivityMainBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindLanguage(language: LanguageData) {
            binding.tvTitle.text = language.title
            binding.tvBody.text = language.body
        }
    }

    fun submitList(languages: List<LanguageData>?) {
        languages?.let {
            this.languages.clear()
            this.languages.addAll(it)
            notifyDataSetChanged()
        }
    }
}

private fun <E> List<E>.addAll(it: List<E>) {
    TODO("Not yet implemented")
}

private fun <E> List<E>.clear() {
    TODO("Not yet implemented")
}


