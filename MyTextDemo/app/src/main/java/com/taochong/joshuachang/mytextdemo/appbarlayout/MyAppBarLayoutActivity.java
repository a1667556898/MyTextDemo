package com.taochong.joshuachang.mytextdemo.appbarlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.taochong.joshuachang.mytextdemo.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by chenzhihong on 2017/9/1.
 */

public class MyAppBarLayoutActivity extends AppCompatActivity {
    @Bind(R.id.myViewpage)
    ViewPager myViewpage;
    @Bind(R.id.myTablayout)
    TabLayout myTablayout;
    private ArrayList<String> mTitles = new ArrayList<>();//标题集
    private ArrayList<Fragment> mFragments = new ArrayList<>();//fragmnet 集合
    private FragmentPagerAdapter mfragmentpageadapter;//适配器
    private int index = 0;//进来设置下标

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myappbarlayout);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {
        mTitles.add("标题1");
        mTitles.add("标题2");
        mTitles.add("标题3");
        for (int i = 0; i < mTitles.size(); i++) {
            mFragments.add(MyAppBarlayoutFragment.newInstance());
        }
        mfragmentpageadapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles.get(position);
            }
        };
        myViewpage.setAdapter(mfragmentpageadapter);
        myTablayout.setupWithViewPager(myViewpage);
        myTablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        myViewpage.setCurrentItem(index);
    }
}
