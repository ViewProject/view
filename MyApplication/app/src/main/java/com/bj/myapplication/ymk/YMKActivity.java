package com.bj.myapplication.ymk;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Window;
import android.widget.ImageView;

import com.bj.myapplication.R;

import java.util.Timer;
import java.util.TimerTask;

public class YMKActivity extends AppCompatActivity {

    private FlowerView mFlowerview;
    private ImageView mIv;
    // 屏幕宽度
    public static int screenWidth;
    // 屏幕高度
    public static int screenHeight;
    Timer myTimer = null;
    TimerTask mTask = null;
    private static final int SNOW_BLOCK = 1;
    private static final int translation=2;
    private Handler mHandler = new Handler() {
        public void dispatchMessage(Message msg) {
            mFlowerview.inva();
        };
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_ymk);
        initView();
        screenWidth = getWindow().getWindowManager().getDefaultDisplay()
                .getWidth();//获取屏幕宽度
        screenHeight = getWindow().getWindowManager().getDefaultDisplay()
                .getHeight();//获取屏幕高度

        DisplayMetrics dis = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dis);
        float de = dis.density;
        mFlowerview.setWH(screenWidth, screenHeight, de);
        mFlowerview.loadFlower();
        mFlowerview.addRect();

        myTimer = new Timer();
        mTask = new TimerTask() {

            @Override
            public void run() {
                Message msg = new Message();
                msg.what = SNOW_BLOCK;
                mHandler.sendMessage(msg);
            }
        };
        myTimer.schedule(mTask, 1000, 10);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                runOnUiThread(new Runnable() {
                    public void run() {
                        showAnimation();
                    }


                });
            }
        };
        timer.schedule(task,2000, 1000);
    }
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        mFlowerview.recly();
    }
    private void showAnimation() {
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(
                mIv, "translationX", 400);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(
                mIv, "translationX", -300);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animator1).before(animator2);
        animatorSet.start();
    }

    private void initView() {
        mFlowerview = (FlowerView) findViewById(R.id.flowerview);
        mIv = (ImageView) findViewById(R.id.iv);
    }
}
