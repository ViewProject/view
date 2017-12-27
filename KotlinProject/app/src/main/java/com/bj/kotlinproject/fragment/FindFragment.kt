package com.bj.kotlinproject.fragment

import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.bj.kotlinproject.R
import com.bj.kotlinproject.base.BaseFragment
import com.bj.kotlinproject.bean.FindBean
import com.bj.kotlinproject.presenter.FindPresenter
import com.bj.kotlinproject.view.FindView

/**
 * Created by 郑文杰 on 2017/12/27.
 */
class FindFragment : BaseFragment<FindPresenter>(),FindView {


    override fun setView(): Int = R.layout.fragment_find

    override fun initView(view: View) {
        var text=view.findViewById<TextView>(R.id.tv) as TextView
        text.text="哈哈哈"

    }

    override fun initData() {
        val presenter = getPresenter()
        presenter.relevance("26868b32e808498db32fd51fb422d00175e179df",83)
    }

    override fun getPresenter(): FindPresenter {
        var presenter=FindPresenter(this)
        return presenter
    }

    override fun getFindData(findBean: List<FindBean>) {
        val name = findBean!!.get(0).name
        Log.e("kk",name)
        Toast.makeText(context,name, Toast.LENGTH_LONG).show()
    }
}