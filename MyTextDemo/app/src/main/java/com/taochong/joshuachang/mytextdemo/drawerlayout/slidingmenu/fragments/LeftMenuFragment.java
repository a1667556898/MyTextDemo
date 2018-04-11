package com.taochong.joshuachang.mytextdemo.drawerlayout.slidingmenu.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.taochong.joshuachang.mytextdemo.R;

/**
 * 常守达  2017/1/5 15:09
 * joshuachang0823@gmail.com
 */

public class LeftMenuFragment extends BaseFragment {
    TextView tv_left;
    @Override
    protected View initView() {
        View view=View.inflate(mActivity, R.layout.fragment_leftmenu,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_left= (TextView) view.findViewById(R.id.tv_left);
        tv_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mActivity,"我是左边的额",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void initData() {

    }
}
