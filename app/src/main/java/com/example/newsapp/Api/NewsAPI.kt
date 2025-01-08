package com.example.newsapp.Api


import com.example.newsapp.model.NewsResponse
import com.example.newsapp.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("v2/top-headlines")
    suspend fun getHeadlines(

        /* هذا يعني أننا نرسل الطلب باسم country،
         والتي تحدد البلد الذي نريد الحصول منه على الأخبار.
          هنا القيمة الافتراضية هي "us" (الولايات المتحدة). */
        @Query("country")
        countryCode: String = "us",

        /*هذا يعني أننا نرسل رقم الصفحة الذي نريد الحصول منه على الأخبار.
         هنا القيمة الافتراضية هي 1 (الصفحة الأولى).
      */
        @Query("page")
        pageNumber: Int = 1,

        /*هذا يشير إلى أن المتغير apiKey سيتم تمريره كقيمة إلى المعلمة apiKey في الرابط.
        القيمة الافتراضية هي API_KEY،
         وهو عادة ثابت تم تخزينه في ملف Constants أو مكان آخر.*/
        @Query("apiKey")
        apiKey: String = API_KEY
    ):Response<NewsResponse>


    @GET("v2/everything")
    suspend fun searchForNews(

        //المعامل q يُستخدم بشكل عام في API البحث لتمثيل "query" أو "استعلام البحث" مثلما هو في العديد من الـ APIs
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ) : Response<NewsResponse>
}