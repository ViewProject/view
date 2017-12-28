package com.bj.myapplication.xiding;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

import com.bj.myapplication.R;
import com.bj.myapplication.adapter.MyAdapter;
import com.bj.myapplication.bean.JavaBean;
import com.bj.myapplication.presenter.DataPresenter;
import com.bj.myapplication.view.DataView;

import java.util.List;

public class ZwjActivity extends AppCompatActivity implements  MyScrollView.OnScrollListener, DataView{

    private MyScrollView mScrollView;
    private LinearLayout top;
    private LinearLayout topInclude;
    private List<String> data;
    private RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zwj);
        DataPresenter presenter = new DataPresenter(this);
        presenter.relevance();
        mScrollView = (MyScrollView) findViewById(R.id.scrollView);
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        top = (LinearLayout) findViewById(R.id.top);
        topInclude = (LinearLayout) findViewById(R.id.top_include);

        mScrollView.setOnScrollListener(this);

        findViewById(R.id.parent_layout).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                onScroll(mScrollView.getScrollY());
            }
        });
    }
    @Override
    public void onScroll(int scrollY) {
        int mBuyLayout2ParentTop = Math.max(scrollY, top.getTop());
        topInclude.layout(0, mBuyLayout2ParentTop, topInclude.getWidth(), mBuyLayout2ParentTop + topInclude.getHeight());
    }

    @Override
    public void getData(JavaBean javaBean) {
        List<JavaBean.DataBean.ComingBean> list = javaBean.data.coming;
        MyAdapter myAdapter = new MyAdapter(this, list);
        rv.setAdapter(myAdapter);
    }
}
