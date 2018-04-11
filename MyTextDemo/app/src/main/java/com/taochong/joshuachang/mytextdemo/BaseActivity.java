package com.taochong.joshuachang.mytextdemo;

import android.app.Activity;
import android.os.Bundle;


public abstract class BaseActivity extends Activity {

    // public EventBus eventBus = EventBus.getDefault();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        initView();
        loadData();
        listener();

    }

    /**
     * 检查是否登录
     */






    protected void loadData() {
    }

    protected void initView() {
    }

    protected void listener(){

    }

    public abstract  int getLayoutId();

    @Override
    protected void onPause() {
        super.onPause();
    }




}
