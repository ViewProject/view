package com.bj.myapplication.presenter;


import com.bj.myapplication.bean.JavaBean;
import com.bj.myapplication.model.DataModel;
import com.bj.myapplication.net.OnFinish;
import com.bj.myapplication.view.DataView;

/**
 * Created by 郑文杰 on 2017/12/19.
 */

public class DataPresenter implements OnFinish {

    private DataView dataView;
    private final DataModel dataModel;

    public DataPresenter(DataView dataView) {
        this.dataView = dataView;
        dataModel = new DataModel();
    }

    public void relevance(){
        dataModel.getData(this);
    }
    @Override
    public void onSuccess(JavaBean javaBean) {
        dataView.getData(javaBean);
    }
}
