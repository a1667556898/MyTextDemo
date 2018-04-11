package com.taochong.joshuachang.mytextdemo.drawerlayout;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.taochong.joshuachang.mytextdemo.R;

/**
 * 常守达  2017/1/5 11:55
 * joshuachang0823@gmail.com
 * drawerlayout的使用
 */

public class MyDrawerLayoutActivity extends Activity {
    private DrawerLayout drawerLayout;
    private TextView tv_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtiy_drawerlayout);
        tv_main= (TextView) findViewById(R.id.tv_main);
        drawerLayout= (DrawerLayout) findViewById(R.id.drawer);

        tv_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyDrawerLayoutActivity.this, "Main page click!!", Toast.LENGTH_SHORT).show();
            }
        });
        drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            /**
             * 抽屉滑动的回调方法
             * @param drawerView
             * @param slideOffset
             * slideoffset   0.0-1.0
             */
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                Log.i("tag", "slide##" + slideOffset);
            }

            /**
             * 抽屉打开的回调方法
             * @param drawerView
             */
            @Override
            public void onDrawerOpened(View drawerView) {
                Log.i("tag", "opened");
            }

            /**
             * 抽屉关闭时的回调方法
             * @param drawerView
             */
            @Override
            public void onDrawerClosed(View drawerView) {
                Log.i("tag", "closed");
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                Log.i("tag", "state" + newState);
//                DrawerLayout.STATE_DRAGGING
//                DrawerLayout.STATE_IDLE
//                DrawerLayout.STATE_SETTLING
            }
        });
    }
}
