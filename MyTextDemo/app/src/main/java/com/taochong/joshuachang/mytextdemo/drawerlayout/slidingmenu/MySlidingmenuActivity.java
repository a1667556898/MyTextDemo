package com.taochong.joshuachang.mytextdemo.drawerlayout.slidingmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.taochong.joshuachang.mytextdemo.R;

/**
 * 常守达  2017/1/5 13:29
 * joshuachang0823@gmail.com
 */

public class MySlidingmenuActivity extends Activity implements View.OnClickListener{
    private Button btn_basic,btn_click,btn_click2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slidingmenu);
        btn_basic= (Button) findViewById(R.id.btn_basic);
        btn_click= (Button) findViewById(R.id.btn_click);
        btn_click2= (Button) findViewById(R.id.btn_click2);
        btn_basic.setOnClickListener(this);
        btn_click.setOnClickListener(this);
        btn_click2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_basic:
                startActivity(new Intent(this, BasicSlidingActivity.class));
                break;
            case R.id.btn_click:
                startActivity(new Intent(this, SlidingUse2Activity.class));
            case R.id.btn_click2:
                startActivity(new Intent(this, SlideFragActivity.class));
                break;
        }
    }
}
