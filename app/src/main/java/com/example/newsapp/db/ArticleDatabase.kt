package com.example.newsapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.newsapp.model.Article

@Database(
    entities = [Article::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase() {

    abstract fun getArticleDAO(): ArticleDAO

    companion object {

        @Volatile
        private var instance: ArticleDatabase? = null
        private val LOCK = Any()  // تغيير الاسم إلى LOCK لتجنب التضارب

        operator fun invoke(context: Context): ArticleDatabase = instance ?: synchronized(LOCK) {  // استخدام synchronized مع LOCK
                instance ?: createDatabase(context).also { instance = it }
            }

        private fun createDatabase(context: Context): ArticleDatabase =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "article_db.db").build()
    }
}
