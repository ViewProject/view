package com.bj.kotlinproject.presenter

import com.bj.kotlinproject.bean.FindBean
import com.bj.kotlinproject.model.FindModel
import com.bj.kotlinproject.net.OnFinish
import com.bj.kotlinproject.view.FindView

/**
 * Created by 郑文杰 on 2017/12/27.
 */
class FindPresenter(findView:FindView):OnFinish<List<FindBean>> {


    var findModel:FindModel?= FindModel()
    var findView:FindView?=findView
    fun relevance(udid:String,vc:Int){
        findModel!!.getData(this,udid,vc)
    }
    override fun onSuccess(t: List<FindBean>) {
        findView!!.getFindData(t!!)
    }

}