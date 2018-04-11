package com.taochong.joshuachang.mytextdemo.drawerlayout.slidingmenu;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.taochong.joshuachang.mytextdemo.R;
import com.taochong.joshuachang.mytextdemo.drawerlayout.slidingmenu.fragments.ContentFrament;
import com.taochong.joshuachang.mytextdemo.drawerlayout.slidingmenu.fragments.LeftMenuFragment;

/**
 * 常守达  2017/1/5 13:51
 * joshuachang0823@gmail.com
 * slidingmenu和Fragment结合使用 常用这种方法
 */

public class SlideFragActivity extends SlidingFragmentActivity {
    private static final String FRAGMENT_CONTENT = "fragment_content";
    private static final String FRAGMENT_LEFT_MENU = "fragment_left_menu";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slidefrag);
        initSlidingMenu();

        initFragmnet();
    }

    private void initFragmnet() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fl_content, new ContentFrament(), FRAGMENT_CONTENT);
        ft.replace(R.id.fl_menu_left, new LeftMenuFragment(), FRAGMENT_LEFT_MENU);
        ft.commit();
    }

    private void initSlidingMenu() {
        setBehindContentView(R.layout.slidingmenu_left);
        //初始化slidingmenu对象
        SlidingMenu slidingmenu = getSlidingMenu();
        //设置模式
        slidingmenu.setMode(SlidingMenu.LEFT);
        //设置抽屉的宽度
        slidingmenu.setBehindWidth(300);
        //设置触摸模式
        slidingmenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);

    }

}
