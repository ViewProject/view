package com.bj.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.bj.myapplication.launcher.LauncherView;

public class MainActivity extends AppCompatActivity {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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


        launcherView = (LauncherView) findViewById(R.id.load_view);




    }




}
