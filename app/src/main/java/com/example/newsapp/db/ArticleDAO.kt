package com.example.newsapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsapp.model.Article

@Dao
interface ArticleDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE) // onConflict = OnConflictStrategy.REPLACE
                                                     // يمنع وجود تكرار
    suspend fun upsert(article: Article): Long

    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<Article>> //  LiveData -> بتحديث واجهة المستخدم تلقائيًا عند حدوث أي تغييرات في البيانات

    @Delete
    suspend fun deleteArticle(article: Article)

}