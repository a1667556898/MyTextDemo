package com.taochong.joshuachang.mytextdemo.canavas;

import android.content.Context;
import android.graphics.*;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * 常守达  2016/12/19 10:34
 * joshuachang0823@gmail.com
 */

public class MyPath2 extends View {
    private Paint mPaint;
    public MyPath2(Context context) {
        super(context);
        init();
    }

    public MyPath2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint=new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getWidth()/2,getHeight()/2);
        Path path1=new Path();
        Path path2=new Path();
        Path path3=new Path();
        Path path4=new Path();
mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);
        path1.addCircle(0,0,200, Path.Direction.CW);

        path2.addRect(0,-200,200,200, Path.Direction.CW);
        path3.addCircle(0,-100,100, Path.Direction.CW);
        path4.addCircle(0,100,100, Path.Direction.CW);

        path1.op(path2, Path.Op.DIFFERENCE);
        path1.op(path3, Path.Op.UNION);
        path1.op(path4, Path.Op.DIFFERENCE);

        canvas.drawPath(path1,mPaint);

    }
}
