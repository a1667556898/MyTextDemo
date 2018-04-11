package com.taochong.joshuachang.mytextdemo.countdowntime;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.taochong.joshuachang.mytextdemo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 常守达  2017/1/3 11:33
 * joshuachang0823@gmail.com
 */

public class MyDaojishiActivtiy extends Activity {
    private ListView my_list;
    private List<String> mDatas;
    private MyCountDownAdapter myAdapter;
    private Timer timer = new Timer();
    private TimerTask timerTask;
private Button bt;
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 1:
                    //1 其实这块需要精确计算时间 算出现在时间到结束时间的时间差值long类型
                    for (int index = 0; index < mDatas.size(); index++) {
                        long time = Long.parseLong(mDatas.get(index));
                        if (time > 1000) {//判断是否有条目能够倒计时 如果能够倒计时的话延迟一秒接着让他倒计时
                            mDatas.set(index, (time - 1000) + "");
                        } else {
                            mDatas.set(index, 0 + "");
                        }
                    }
                    myAdapter.notifyDataSetChanged();
            }

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);
        initView();
        initData();
    }
    //初始化数据 添加监听器 填充布局
    private void initData() {
        for (int i = 0; i < 50; i++) {
            mDatas.add(300000 + 1000 * i + "");
        }
        myAdapter = new MyCountDownAdapter( mDatas,this);
        my_list.setAdapter(myAdapter);
        timerTask=new TimerTask() {
            @Override
            public void run() {
                Message message=Message.obtain();
                message.what=1;
                mHandler.sendMessage(message);
            }
        };
        timer.schedule(timerTask,1000,1000);
    }

    private void initView() {
        my_list= (ListView) findViewById(R.id.my_list);
        mDatas = new ArrayList<>();
        bt= (Button) findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAdapter.notifyDataSetChanged();
            }
        });

    }
    @Override
    protected void onDestroy() {
        if (null != timer) {
            timer.cancel();
        }
        super.onDestroy();
    }
}
