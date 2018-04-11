package com.taochong.joshuachang.mytextdemo.customview;

import android.app.Activity;
import android.os.Bundle;

import com.taochong.joshuachang.mytextdemo.R;

/**
 * 常守达  2016/12/29 11:16
 * joshuachang0823@gmail.com
 */

public class MySlidingMenuActivity extends Activity {
    public static int mWidth=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWidth=getWindowManager().getDefaultDisplay().getWidth();
        setContentView(R.layout.activity_myslidingmenu);

    }
}
