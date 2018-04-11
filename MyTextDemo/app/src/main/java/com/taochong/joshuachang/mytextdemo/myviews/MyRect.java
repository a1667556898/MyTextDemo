package com.taochong.joshuachang.mytextdemo.myviews;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * 常守达  2016/11/16 09:36
 * View 绘制实际的Rect对象
 * 拥有动态的移动算法
 */
public class MyRect {
    private Paint paint;
    private Rect rect;
    //定义起始的坐标点
    private int myX;
    private int myY;
    //矩形框的宽和高
    private int rectWidth = 200;
    private int rectHeight = 50;
    //定义方向的变量（制订当前 王座还是网友）
    private boolean isToRight;
    private boolean isToDown;
    public MyRect() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        myX = myY = 0;
        rect = new Rect(myX, myY, myX + rectWidth, myY + rectHeight);
        isToRight = true;
        isToDown=true;
    }

    public void drawSelf(Canvas canvas) {
        canvas.drawRect(rect, paint);
        //移动
        moveHRuturn2();
    }

    //横行移动的算法
    public void moveH() {
        myX += 20;
        //重新设置rect的4个坐标
        rect.set(myX, myY, myX + rect.width(), myY + rectHeight);
    }

    //横向往返的算法
    public void moveHReturn() {
//        int sreenWidth = MainActivity.SCREENWIDTH;
        if (isToRight || myX <= 0) {
            isToRight = true;
            myX += 20;
        }
//        if (!isToRight||myX+rectWidth>=sreenWidth){
//            isToRight=false;
//            myX-=20;
//        }
        rect.set(myX,myY,myX+rectWidth,myY+rectHeight);
    }
    public void moveHRuturn2(){
//        int sreenWidth = MainActivity.SCREENWIDTH;
        int screenHeight=400;
        if (isToRight){
            myX+=20;
        }else {
            myX-=20;
        }
//        if (myX+rectWidth>=sreenWidth){
//            isToRight=false;
//        }
        if (myX<=0){
            isToRight=true;
        }
        //往下
        if (isToDown){
            myY+=40;
        }else {
            myY-=40;
        }
        if (myY+rectHeight>screenHeight){
            isToDown=false;
        }
        if(myY<=0) {
            isToDown=true;
        }


        rect.set(myX, myY, myX + rectWidth, myY + rectHeight);
    }
}
