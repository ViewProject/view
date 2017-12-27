package com.bj.kotlinproject.view

import com.bj.kotlinproject.bean.FindBean

/**
 * Created by 郑文杰 on 2017/12/27.
 */
interface FindView {
    abstract fun getFindData(findBean:List<FindBean>)
}