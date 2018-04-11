package com.taochong.joshuachang.mytextdemo.myviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 常守达  2016/11/15 17:35
 * joshuachang0823@gmail.com
 */
public class MyPaintView extends View {
    private Paint paint;
    private Path path;
    private int default_color= Color.BLACK;
    public MyPaintView(Context context) {
        super(context);
        init(default_color);
    }

    public MyPaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(default_color);
    }

    public MyPaintView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(default_color);
    }
    /**自定义初始化方法
     * **
     */
    private void init(int color){
        paint =new Paint();
        paint.setColor(color);
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        path=new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x=event.getX();
        float y=event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x,y);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x,y);
                break;
            default:
                break;
        }
        invalidate();
        return true;
    }
}
