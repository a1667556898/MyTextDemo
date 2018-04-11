package com.taochong.joshuachang.mytextdemo.canavas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * 常守达  2016/12/12 16:04
 * joshuachang0823@gmail.com
 */

public class DrawPoints extends View {
    private Paint mPaint = new Paint();

    public DrawPoints(Context context) {
        super(context);
        initPaint();
    }

    public DrawPoints(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    private void initPaint() {
        mPaint.setColor(Color.GRAY);//设置画笔的颜色
        mPaint.setStyle(Paint.Style.FILL);//设置画笔模式为填充fill 空心模式为stroke
        mPaint.setStrokeMiter(2);
        mPaint.setStrokeMiter(20f);//设置画笔宽度为10px
        mPaint.setAntiAlias(true);//消除锯齿
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawColor(Color.BLUE);//绘制颜色
//        canvas.drawPoint(200, 200, mPaint);//绘制一个点
//        canvas.drawPoints(new float[]{//绘制很多点
//                100, 200, 200, 300, 300, 400
//        }, mPaint);
//        canvas.drawLine(300, 300, 500, 600, mPaint);//绘制线
//        canvas.drawLines(new float[]{100, 200, 200, 200, 100, 300, 200, 300}, mPaint);//绘制多条线
        //绘制矩形的第一种方式
//        canvas.drawRect(100,200,500,500,mPaint);
//绘制矩形第二种方式
//        Rect rect=new Rect(100,200,500,500);
//        canvas.drawRect(rect,mPaint);
        //绘制矩形的第三种方式
//        RectF rectf=new RectF(100,200,500,500);
//        canvas.drawRect(rectf,mPaint);
        //绘制圆角矩形
        //第一种方式
//        RectF rectf=new RectF(100,200,400,400);
//        canvas.drawRoundRect(rectf,30,30,mPaint);
        //第二种方式
//        canvas.drawRoundRect(100,200,400,400,30,30,mPaint);
        //用矩形画椭圆
//        mPaint.setColor(Color.BLUE);
//        canvas.drawRoundRect(100,200,400,400,150,100,mPaint);
//画椭圆方式一
//        RectF rectf=new RectF(100,100,800,400);
//        canvas.drawOval(rectf,mPaint);
        //方式二
//        canvas.drawOval(100,100,500,400,mPaint);
        //绘制圆
//        canvas.drawCircle(100,100,50,mPaint);
        //绘制圆弧
//        RectF rectf=new RectF(100,100,400,400);
//        //绘制背景矩形
//        mPaint.setColor(Color.GRAY);
//        canvas.drawRect(rectf,mPaint);
//        //绘制圆弧不用中心点
//        mPaint.setColor(Color.BLUE);
//        canvas.drawArc(rectf,0,90,false,mPaint);
//        RectF rectf=new RectF(100,100,400,400);
//       // 绘制背景矩形
//        mPaint.setColor(Color.GRAY);
//        canvas.drawRect(rectf,mPaint);
//        //绘制圆弧用中心点
//        mPaint.setColor(Color.BLUE);
//        canvas.drawArc(rectf,0,90,true,mPaint);
        //使用正圆画圆弧
        RectF rectf=new RectF(100,100,600,600);
//        绘制背景矩形
        mPaint.setColor(Color.GRAY);
        canvas.drawRect(rectf,mPaint);
//        绘制圆弧
        mPaint.setColor(Color.BLUE);
        canvas.drawArc(rectf,0,90,true,mPaint);

    }
}
