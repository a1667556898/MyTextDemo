package com.taochong.joshuachang.mytextdemo.nightmode;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.TextView;

import com.taochong.joshuachang.mytextdemo.R;


/**
 * Created by chenzhihong on 2017/9/22.
 * 实现白天黑夜模式的注意点
 * 1 如果你要实现的比较复杂，就不单单是在valuse-night中设置不同的颜色了，也可以建不同的style给不同的view引用
 * 2 需要注意的俩个地方 一个是app或者activity必须要引用的style是Theme.AppCompat.DayNight，或者它的子类
 * 二是调用getDelegate().setLocalNightMode()你的Activity必须是继承AppCompatActivity的。
 * 然后调用recreate();
 * 但是会出现闪一下的的不好体验，可以通过设置activity的淡入淡出进入退出动画来优化这个效果
 *
 */

public class MyNightModeActivity extends AppCompatActivity {
    private TextView tv_day;
    private TextView tv_night;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_night);

        tv_day = (TextView) findViewById(R.id.tv_day);
        tv_night = (TextView) findViewById(R.id.tv_night);
        tv_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                recreate();
            }
        });
        tv_night.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                recreate();
            }
        });
    }
    public void setNightMode(){
        //获取当前模式
        int currentNightMode=getResources().getConfiguration().uiMode& Configuration.UI_MODE_NIGHT_MASK;

    }
}