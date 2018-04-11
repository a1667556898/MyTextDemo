package com.taochong.joshuachang.mytextdemo.canavas;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 常守达  2016/12/13 11:55
 * joshuachang0823@gmail.com
 */

public class Canvas extends View {
    private Paint mPaint;

    public Canvas(Context context) {
        super(context);
        init();
    }


    public Canvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint=new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        //1 在坐标原点绘制一个黑色的圆形
//        mPaint.setColor(Color.BLACK);
//        canvas.translate(200,200);
//        canvas.drawCircle(0,0,100,mPaint);
        //在坐标原点绘制一个蓝色的圆形
//        mPaint.setColor(Color.BLUE);
//        canvas.translate(200,200);
//        canvas.drawCircle(0,0,100,mPaint);
        //2 将坐标系原点移动到画布正中心
//        canvas.translate(getWidth()/2,getHeight()/2);
//        RectF rectF=new RectF(0,-400,400,0);//绘制黑色矩形
//        mPaint.setColor(Color.BLACK);
//        canvas.drawRect(rectF,mPaint);
//        canvas.scale(-0.5f,-0.5f);//画布缩放
//        mPaint.setColor(Color.BLUE);
//        canvas.drawRect(rectF,mPaint);
//        canvas.scale(-0.5f,-0.1f);//画布缩放
//        mPaint.setColor(Color.BLUE);
//        canvas.drawRect(rectF,mPaint);
        //做个有趣的图形
//        canvas.translate(getWidth()/2,getHeight()/2);
//        RectF rectF=new RectF(-400,-400,400,400);
//        mPaint.setColor(Color.BLACK);
//        for (int i=0;i<20;i++){
//            canvas.scale(0.9f,0.9f);
//            canvas.drawRect(rectF,mPaint);
//        }
        //多层圆环
//        canvas.translate(getWidth()/2,getHeight()/2);
//        canvas.drawCircle(0,0,400,mPaint);
//        for (int i=0;i<20;i++){
//            float r=400*(20-i)/20;
//            canvas.drawCircle(0,0,r,mPaint);
//        }
//        for (int i=0;i<360;i+=20){
//            canvas.drawLine(0,0,400,0,mPaint);
//            canvas.rotate(20);
//        }
        //3 旋转rotate
        //将坐标原点移到中心
//        canvas.translate(getWidth()/2,getHeight()/2);
//        //画矩形框
//        RectF rectF=new RectF(0,-200,200,0);
//        mPaint.setColor(Color.BLACK);
//        canvas.drawRect(rectF,mPaint);
//        //旋转
//        canvas.rotate(180,100,0);
//        mPaint.setColor(Color.BLUE);
//        canvas.drawRect(rectF,mPaint);
//4 错切skew
        //将坐标系原点移动到画布正中心
//        canvas.translate(getWidth()/2,getHeight()/2);
//        RectF rectF=new RectF(0,0,200,200);
//        mPaint.setColor(Color.BLACK);
//        canvas.drawRect(rectF,mPaint);
//        canvas.skew(1,0);
//        canvas.skew(0,1);//错切也是可以叠加的
//        mPaint.setColor(Color.BLUE);
//        canvas.drawRect(rectF,mPaint);
        //5 快照（save)和回滚（restore)

    }
}
