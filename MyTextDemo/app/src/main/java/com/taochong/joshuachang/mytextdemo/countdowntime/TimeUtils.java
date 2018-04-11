package com.taochong.joshuachang.mytextdemo.countdowntime;

import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * 常守达  2016/12/30 17:42
 * joshuachang0823@gmail.com
 */

public class TimeUtils extends CountDownTimer {
    private TextView tv;

    public TimeUtils(long millisInFuture, long countDownInterval, TextView tv) {
        super(millisInFuture, countDownInterval);
        this.tv=tv;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        tv.setText(millisUntilFinished / 1000+"");
    }

    @Override
    public void onFinish() {

    }
}
