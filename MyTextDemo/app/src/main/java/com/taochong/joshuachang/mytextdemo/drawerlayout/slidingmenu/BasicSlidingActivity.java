package com.taochong.joshuachang.mytextdemo.drawerlayout.slidingmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.taochong.joshuachang.mytextdemo.R;

/**
 * 常守达  2017/1/5 13:51
 * joshuachang0823@gmail.com
 * usages:1 初始化slidingmenu对象
 * 2 设置滑出模式
 * 3 设置触摸的程度
 * 4 设置抽屉的宽度
 * 5 依附于Activity的形式
 * 6 设置抽屉的布局
 */

public class BasicSlidingActivity extends Activity {
    TextView tv_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slidingbasic);
        tv_main= (TextView) findViewById(R.id.tv_main);
        tv_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BasicSlidingActivity.this, "我是主界面", Toast.LENGTH_SHORT).show();
            }
        });
        //1 初始化Slidingmenu
        SlidingMenu menu = new SlidingMenu(this);
        //设置slidingmenu 的模式 从哪出来
        menu.setMode(SlidingMenu.LEFT);
        //3 设置触摸程度 三种方式
        //第一种：Slidingmenu.TouchMode_FullSreen 主界面从全屏都可以滑出抽屉
        //第二种：SlidingMenu.TouchModer_None 主界面全屏都滑不出来抽屉
        //第三种：SlidingMenu.TouchMArgin 只能从主界面边缘滑出抽屉
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        //中间间隔的宽度
        menu.setShadowWidth(80);
        //中间间隔的图像资源
        menu.setShadowDrawable(R.mipmap.timg);
        //4 设置抽屉距离边缘的宽度 offset偏移 剩余
        menu.setBehindOffset(100);
        // 4 设置抽屉的宽度
//        menu.setBehindWidth(100);
        //设置抽屉渐变程度
        menu.setFadeDegree(0.5f);
        //加载到activity的方式
        //两种方式
        //1 Slidingmenu。Sliding_window 默认在标题上滑出
        //2 SlidingMenu.Sliding_content 默认从标题下滑出
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        //设置抽屉的布局
        menu.setMenu(R.layout.menu_left);
        TextView tv_menu = (TextView)findViewById(R.id.tv_menu);
        tv_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BasicSlidingActivity.this, "点击我了", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
