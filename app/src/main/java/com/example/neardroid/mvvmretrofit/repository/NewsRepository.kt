package com.example.neardroid.mvvmretrofit.repository

import com.example.neardroid.mvvmretrofit.api.NewsWebservice

class NewsRepository {
    val api = NewsWebservice()

    suspend fun getNewsList() {
        api.getNews("th","c914619ecb3245f7a1fc8d9ef7df409c")
    }
}