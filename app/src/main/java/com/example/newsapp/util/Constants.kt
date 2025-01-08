package com.example.newsapp.util

class Constants {

    companion object {

        const val API_KEY = "1f6fc57b1bcd4aa48397c89021b1a378"
        const val BASE_URL = "https://newsapi.org"
        const val SEARCH_NEWS_TIME_DELAY =
            500L // الاستخدام: يتم استخدامه لتأخير إرسال طلب البحث عندما يقوم المستخدم بإدخال نص في مربع البحث.
        const val QUERY_PAGE_SIZE: Int = 20 // الخادم يُعيد 20 خبرًا في كل صفحة
    }

}