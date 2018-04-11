package com.taochong.joshuachang.mytextdemo.canavas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 常守达  2016/12/20 11:41
 * joshuachang0823@gmail.com
 */

public class MyPathMeasure extends View {
    private Paint mPaint;
    private int mWidth, mHeight;

    public MyPathMeasure(Context context) {
        super(context);
    }

    public MyPathMeasure(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getWidth() / 2, getHeight() / 2);
//        Path path = new Path();
////        path.lineTo(0, 200);
////        path.lineTo(200, 200);
////        path.lineTo(200, 0);
////
////        PathMeasure measure1 = new PathMeasure(path, false);
////        PathMeasure measure2 = new PathMeasure(path, true);
////        Log.i("123", "measure1" + measure1.getLength() + "--measure2" + measure2.getLength());
////        canvas.drawPath(path, mPaint);
//        path.addRect(-200,-200,200,200, Path.Direction.CW);
//        Path dst=new Path();//创建用于截取后的path
//        dst.lineTo(-300,-300);
//        PathMeasure measure=new PathMeasure(path,false);//将path和pathmeasure关联起来
////截取一部分存入dst中 并使用moveTo保持截取到到path 第一点位置不变
//        measure.getSegment(200,600,dst,false);
//        canvas.drawPath(dst,mPaint);//绘制dst
        Path path = new Path();
        path.addRect(-100, -100, 100, 100, Path.Direction.CW);//添加小矩形
        canvas.drawPath(path, mPaint);//绘制path
        path.addRect(-200, -200, 200, 200, Path.Direction.CW);//添加大矩形
        canvas.drawPath(path, mPaint);//绘制path

        PathMeasure measure = new PathMeasure(path, false);//将path和pathmeasure联系起来
        float len1 = measure.getLength();//获得第一条路径的长度
        measure.nextContour();//跳转到下一条路径
        float len2 = measure.getLength();//获取第二条路径的长度
        Log.i("123", "len1" + len1 + "len2" + len2);
    }
}
