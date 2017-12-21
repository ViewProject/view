package com.bj.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.bj.myapplication.launcher.LauncherView;
import com.bj.myapplication.lili.LiliActivity;
import com.bj.myapplication.xiding.ZwjActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int i=1;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (msg.what==0){
                launcherView.start();
            }

        }
    };
    private LauncherView launcherView;
    private TextView zwj;
    private TextView wlj;
    private TextView ymk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getqidong();


       initView();




    }

    private void initView() {


        zwj = (TextView) findViewById(R.id.zwj);
        zwj.setOnClickListener(this);

        wlj = (TextView) findViewById(R.id.wlj);
        wlj.setOnClickListener(this);

        ymk = (TextView) findViewById(R.id.ymk);
        ymk.setOnClickListener(this);

    }

    private void getqidong() {
        launcherView = (LauncherView) findViewById(R.id.load_view);

        new Thread(){
            @Override
            public void run() {
                super.run();
                while (i>0){
                    try {
                        i--;
                        sleep(1000);
                        handler.sendEmptyMessage(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }.start();
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.zwj:
                Intent intent1 = new Intent(MainActivity.this, ZwjActivity.class);
                startActivity(intent1);
                break;
            case R.id.wlj:
                Intent intent2 = new Intent(MainActivity.this, LiliActivity.class);
                startActivity(intent2);
                break;
            case R.id.ymk:
                
                break;
        }
    }
}
