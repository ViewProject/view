package com.bj.myapplication.lili;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.bj.myapplication.R;

import me.yifeiyuan.library.PeriscopeLayout;

/**
 * Created by 吴丽杰 on 2017/12/21.
 */

public class LiliActivity extends AppCompatActivity {
    private ImageView iv_shop_add;
    private ImageView iv_shop_cart;
    private ViewGroup mViewGroup;
    private int mShoppingCartWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lili);
        initView();
        getData();
        final PeriscopeLayout periscopeLayout = (PeriscopeLayout) findViewById(R.id.periscope);

        periscopeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                periscopeLayout.addHeart();
            }
        });
        ViewTreeObserver viewTreeObserver = iv_shop_cart.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onGlobalLayout() {
                iv_shop_cart.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                mShoppingCartWidth = iv_shop_cart.getMeasuredWidth();
            }
        });
    }
    private void getData() {
        iv_shop_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //获取商品坐标
                int[] goodsPoint = new int[2];
                iv_shop_add.getLocationInWindow(goodsPoint);

                //获取购物车坐标
                int[] shoppingCartPoint = new int[2];
                iv_shop_cart.getLocationInWindow(shoppingCartPoint);


                //生成商品View
                GoodsView goodsView = new GoodsView(LiliActivity.this);
                goodsView.setCircleStartPoint(goodsPoint[0], goodsPoint[1]);
                goodsView.setCircleEndPoint(shoppingCartPoint[0] + mShoppingCartWidth / 2, shoppingCartPoint[1]);
                //添加View并执行动画
                mViewGroup.addView(goodsView);
                goodsView.startAnimation();

            }
        });

    }

    private void initView() {
        iv_shop_add = (ImageView) findViewById(R.id.pingguo);
        iv_shop_cart = (ImageView) findViewById(R.id.guaiwu);
        mViewGroup = (ViewGroup) getWindow().getDecorView();

    }
}