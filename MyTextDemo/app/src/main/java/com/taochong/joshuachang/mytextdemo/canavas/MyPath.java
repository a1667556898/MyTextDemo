package com.taochong.joshuachang.mytextdemo.canavas;

import android.content.Context;
import android.graphics.*;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * 常守达  2016/12/19 09:58
 * joshuachang0823@gmail.com
 * Path的rXxx方法
 */

public class MyPath extends View {
    private Paint mPaint;

    public MyPath(Context context) {
        super(context);
        init();
    }

    public MyPath(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint=new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path=new Path();
        path.moveTo(100,100);
//        path.lineTo(100,200);
        path.rLineTo(100,200);
        canvas.drawPath(path,mPaint);
    }
}
