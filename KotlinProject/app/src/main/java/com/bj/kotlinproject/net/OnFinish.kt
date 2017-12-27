package com.bj.kotlinproject.net

/**
 * Created by 郑文杰 on 2017/12/27.
 */
interface OnFinish<T> {
    abstract fun onSuccess(t:T)
}