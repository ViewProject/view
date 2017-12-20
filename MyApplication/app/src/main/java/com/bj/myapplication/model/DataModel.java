package com.bj.myapplication.model;

import com.bj.myapplication.bean.JavaBean;
import com.bj.myapplication.net.Api;
import com.bj.myapplication.net.ApiService;
import com.bj.myapplication.net.OnFinish;
import com.bj.myapplication.net.RetrofitUtil;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by 郑文杰 on 2017/12/19.
 */

public class DataModel {
    public void getData(final OnFinish onFinish){
        ApiService apiService = RetrofitUtil.getInstance().getApiService(Api.BaseUrl, ApiService.class);
        Flowable<JavaBean> javaBeanFlowable = apiService.getData();
        javaBeanFlowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<JavaBean>() {
                    @Override
                    public void onNext(JavaBean javaBean) {
                        onFinish.onSuccess(javaBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
