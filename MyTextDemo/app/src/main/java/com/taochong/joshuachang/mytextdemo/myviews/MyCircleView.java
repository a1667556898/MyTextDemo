package com.taochong.joshuachang.mytextdemo.myviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * 常守达  2016/11/15 15:59
 * joshuachang0823@gmail.com
 */
public class MyCircleView extends View {
    private Paint paint;
    private Rect rect;
    private int count = 10;
    public MyCircleView(Context context) {
        super(context);
        init();
    }

    public MyCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(2);
        paint.setAntiAlias(true);
        rect = new Rect();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
canvas.drawCircle(getWidth()/2,getHeight()/2,getWidth()/2,paint);

        paint.setColor(Color.BLACK);
        //血文字
        String text=count+"";
        paint.setTextSize(20);
        paint.getTextBounds(text,0,text.length(),rect);
        canvas.drawText(text,getWidth()/2-rect.width()/2,getHeight()/2+rect.height()/2,paint);
    }
}
