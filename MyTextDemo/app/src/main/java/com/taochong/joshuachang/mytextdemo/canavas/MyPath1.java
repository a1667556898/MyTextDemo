package com.taochong.joshuachang.mytextdemo.canavas;

import android.content.Context;
import android.graphics.*;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * 常守达  2016/12/19 10:19
 * joshuachang0823@gmail.com
 */

public class MyPath1 extends View {
    private Paint mPaint;

    public MyPath1(Context context) {
        super(context);
        init();
    }

    public MyPath1(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);//设置画布模式为填充模式
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //奇数偶数规则
        //反奇数偶数规则
        canvas.translate(getWidth() / 2, getHeight() / 2);//移到画布中英
//        Path path = new Path();
//        path.setFillType(Path.FillType.EVEN_ODD);//设置填充模式为奇数偶数规则
//        path.setFillType(Path.FillType.INVERSE_EVEN_ODD);//设置填充模式为反奇数偶数规则
//        path.addRect(-200, -200, 200, 200, Path.Direction.CW);
//        canvas.drawPath(path, mPaint);

        Path path=new Path();
        //添加小正方形 （通过这两行代码来控制小正方形的方向，从而演示不同的效果）
//        path.addRect(-200,-200,200,200, Path.Direction.CW);
        path.addRect(-200,-200,200,200, Path.Direction.CCW);
        //添加大正方形
        path.addRect(-400,-400,400,400, Path.Direction.CCW);
        path.setFillType(Path.FillType.WINDING);//设置path为非0环绕法则
        canvas.drawPath(path,mPaint);//绘制path
    }
}
