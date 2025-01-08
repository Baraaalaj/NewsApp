package com.example.newsapp.Api

import com.example.newsapp.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object{

        /*  (by lazy)
         التي تعني أن object سيتم إنشاؤه عند أول استخدام فقط.

         هذه الطريقة تجعل Retrofit يتم إنشاؤه مرة واحدة فقط، مما يزيد من كفاءة الأداء ويقلل من استهلاك الذاكرة.
        */
        private val retrofit by lazy {

            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY // يعني أنه سيتم تسجيل الطلبات والاستجابات بالكامل
            val clint = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(clint)
                .build()
        }

        val api by lazy {
            retrofit.create(NewsAPI::class.java)
        }
    }
}