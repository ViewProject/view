package com.bj.myapplication.net;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 郑文杰 on 2017/12/19.
 */

public class RetrofitUtil {
    private static RetrofitUtil retrofitUtil;

    public RetrofitUtil() {
    }
    public static RetrofitUtil getInstance(){
        if (retrofitUtil==null){
            synchronized (RetrofitUtil.class){
                if (retrofitUtil==null){
                    retrofitUtil=new RetrofitUtil();
                }
            }
        }
        return retrofitUtil;
    }

    private Retrofit retrofit;
    private synchronized Retrofit getRetrofit(String uri){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e("xxx", message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).connectTimeout(3000, TimeUnit.SECONDS).build();
        if (retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(uri)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient).build();
        }

        return retrofit;
    };

    public <T>T getApiService(String uri,Class<T> cl){
        Retrofit retrofit = getRetrofit(uri);
        return retrofit.create(cl);
    }
}
