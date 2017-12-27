package com.bj.kotlinproject.net

import com.bj.kotlinproject.bean.FindBean
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by 郑文杰 on 2017/12/27.
 */
interface ApiService {

    //每日精选  http://baobab.wandoujia.com/api/v2/feed?num=2&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83
    @GET("v2/feed")
    fun getJXData(@Query("num") num: Int, @Query("udid") udid: String, @Query("vc") vc: Int)

    //发现更多 http://baobab.wandoujia.com/api/v2/categories?udid=26868b32e808498db32fd51fb422d00175e179df&vc=83
    @GET("v2/categories")
    fun getFindData(@Query("udid") udid: String, @Query("vc") vc: Int) :Flowable<List<FindBean>>

}