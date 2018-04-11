package com.taochong.joshuachang.mytextdemo.drawerlayout.slidingmenu.fragments;

import android.view.View;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.taochong.joshuachang.mytextdemo.R;
import com.taochong.joshuachang.mytextdemo.drawerlayout.slidingmenu.SlideFragActivity;

/**
 * 常守达  2017/1/5 15:04
 * joshuachang0823@gmail.com
 */

public class ContentFrament extends BaseFragment {
    private TextView tv_showmenu;

    @Override
    protected View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_content, null);
        tv_showmenu = (TextView) view.findViewById(R.id.tv_showmenu);
        return view;
    }

    @Override
    protected void initData() {
        tv_showmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLeftMenu();
            }
        });
    }

    /**
     * 展示或关闭左边的抽屉
     */
    private void showLeftMenu() {
     SlidingMenu slidingmenu=((SlideFragActivity) mActivity).getSlidingMenu();
        if (slidingmenu.isMenuShowing()){
            slidingmenu.toggle();
        }else {
            slidingmenu.showMenu();
        }
    }
}
