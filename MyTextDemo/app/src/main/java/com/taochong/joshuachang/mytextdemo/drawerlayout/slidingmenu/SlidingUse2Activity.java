package com.taochong.joshuachang.mytextdemo.drawerlayout.slidingmenu;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.taochong.joshuachang.mytextdemo.R;

/**
 * 常守达  2017/1/5 13:51
 * joshuachang0823@gmail.com
 */

public class SlidingUse2Activity extends SlidingFragmentActivity {
    private TextView tv_left, tv_right, tv_main;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slidingbasic);
        //1 设置抽屉的布局
        setBehindContentView(R.layout.menu_left);
        //2 初始化Slidingmene的对象
        SlidingMenu slidingMenu = getSlidingMenu();
        //设置滑动出来的模式
        slidingMenu.setMode(SlidingMenu.LEFT_RIGHT);
        //4 设置抽屉的宽度
        slidingMenu.setBehindWidth(200);
        //5 设置第二个抽屉
        slidingMenu.setSecondaryMenu(R.layout.menu_right);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        tv_left = (TextView) findViewById(R.id.tv_menu);
        tv_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SlidingUse2Activity.this, "点击我了", Toast.LENGTH_SHORT).show();
            }
        });
        tv_right = (TextView) findViewById(R.id.tv_right);
        tv_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SlidingUse2Activity.this, "点击右侧", Toast.LENGTH_SHORT).show();
            }
        });
        tv_main = (TextView) findViewById(R.id.tv_main);
        tv_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SlidingUse2Activity.this, "我是主界面", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
