package com.bj.kotlinproject.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bj.kotlinproject.R

/**
 * Created by 郑文杰 on 2017/12/27.
 */
class MySelfFragment  :Fragment(){

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_myself, container, false)
        return view
    }
}