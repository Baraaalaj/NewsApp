package com.example.newsapp.Repository

import com.example.newsapp.Api.RetrofitInstance
import com.example.newsapp.db.ArticleDatabase
import com.example.newsapp.model.Article

class NewsRepository(val db: ArticleDatabase) {

    suspend fun getHeadlines(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getHeadlines(countryCode, pageNumber)

    suspend fun searchForNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDAO().upsert(article)

    fun getFavoriteNews() = db.getArticleDAO().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDAO().deleteArticle(article)
}