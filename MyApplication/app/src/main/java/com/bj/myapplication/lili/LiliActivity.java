package com.bj.myapplication.lili;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bj.myapplication.R;

import me.yifeiyuan.library.PeriscopeLayout;

/**
 * Created by 吴丽杰 on 2017/12/21.
 */

public class LiliActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lili);
        final PeriscopeLayout periscopeLayout = (PeriscopeLayout) findViewById(R.id.periscope);

        periscopeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                periscopeLayout.addHeart();
            }
        });
    }
}