package com.bj.kotlinproject.net

import android.util.Log
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by 郑文杰 on 2017/12/27.
 */
class RetrofitUtil {
    companion object {
        private var retrofitUtil: RetrofitUtil? = null
        fun getInstance(): RetrofitUtil? {
            if (retrofitUtil == null) {
                synchronized(RetrofitUtil::class.java) {
                    if (retrofitUtil == null) {
                        retrofitUtil = RetrofitUtil()
                    }
                }
            }
            return retrofitUtil
        }
    }

    private var retrofit: Retrofit? = null
    fun getRetrofit(url: String): Retrofit? {
        val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Log.e("xxx", message) })
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        var okHttpClient = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).connectTimeout(3000, TimeUnit.SECONDS).build()
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .baseUrl(url)
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
        return retrofit
    }

    fun <T> getApiService(url: String, cl: Class<T>): T {
        val retrofit = getRetrofit(url)
        return retrofit!!.create(cl)
    }


}