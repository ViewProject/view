package com.bj.kotlinproject.app

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

/**
 * Created by 郑文杰 on 2017/12/27.
 */
class MyApp :Application(){
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}