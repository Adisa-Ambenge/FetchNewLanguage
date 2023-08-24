package com.angela.mylanguage.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.angela.mylanguage.API.APIService
import com.angela.mylanguage.Model.LanguageData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class LanguageViewModel: ViewModel() {
    val languages = MutableLiveData<List<LanguageData>>()
    val language: LiveData<List<LanguageData>> = languages
 init {
     fetchlanguages()
 }
    fun fetchlanguages(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/posts")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val apiService = retrofit.create(APIService::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiService.getPosts()
            if (response.isSuccessful){
                languages.postValue(response.body())
            }
        }
    }

}
