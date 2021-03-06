package com.taochong.joshuachang.mytextdemo.canavas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * 常守达  2016/12/12 17:48
 * joshuachang0823@gmail.com
 */

public class PieView extends View {
    //颜色表 注意：此处定义颜色使用的是Argb，带alpha通道
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};
    //饼状图初始绘制角度
    private float mStartAngle = 0;
    //数据
    private ArrayList<PieData> mData;
    //宽 高
    private int mWidth, mHeight;
    //画笔
    private Paint mPaint = new Paint();
//文字色块部分
    private PointF mStartPoint=new PointF(20,20);
    private PointF mCurrentPoint=new PointF(mStartPoint.x,mStartPoint.y);
    private float mColorRectSideLength=20;
    private float mTextInterval=10;
    private float mRowMaxLength;
    public PieView(Context context) {
        super(context,null);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    public PieView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (null == mData) {
            return;
        }
        float currentStartAngle = mStartAngle;//当前起始角度
        canvas.translate(mWidth / 2, mHeight / 2);//将画布坐标原点移到中心点位置
        float r = (float) (Math.min(mWidth, mHeight) / 2 * 0.8);//饼状圆半径
        RectF rectF = new RectF(-r, -r, r, r);
        for (int i = 0; i < mData.size(); i++) {
            PieData pie = mData.get(i);
            mPaint.setColor(pie.getColor());
            canvas.drawArc(rectF, currentStartAngle, pie.getAngle(), true, mPaint);
            currentStartAngle += pie.getAngle();

            canvas.save();
            canvas.translate(-mWidth/2,-mHeight/2);
//            RectF colorRect=new RectF(mCurrentPoint.x,mCurrentPoint.y,mCurrentPoint.x+mColorRectSideLength,mCurrentPoint.y + mColorRectSideLength);
//            canvas.drawText(pie.getName(),(int)mCurrentPoint.x,(int)mCurrentPoint.y,mCurrentPoint.x+mColorRectSideLength,mCurrentPoint.y + mColorRectSideLength,mPaint);
            canvas.restore();
        }
    }

    //设置起始角度
    public void setmStartAngle(int mStartAngle) {
        this.mStartAngle = mStartAngle;
        invalidate();//刷新
    }

    //设置数据
    public void setmData(ArrayList<PieData> mData) {
        this.mData = mData;
        initData(mData);
        invalidate();//刷新
    }

    //初始化数据
    private void initData(ArrayList<PieData> mData) {
        if (null == mData || mData.size() == 0) {//数据有问题直接返回
            return;
        }
        float sumValue = 0;
        for (int i = 0; i < mData.size(); i++) {
            PieData pieData = mData.get(i);
            sumValue += pieData.getValue();//计算数值和
            int j = i % mColors.length;//设置颜色
            pieData.setColor(mColors[j]);
        }
        float sumAngle = 0;
        for (int i = 0; i < mData.size(); i++) {
            PieData pie = mData.get(i);
            float percentage = pie.getValue() / sumValue;//百分比
            float angle = percentage * 360;//对应的角度
            pie.setPercentage(percentage);//记录百分比
            pie.setAngle(angle);//记录角度大小
            sumAngle += angle;
            Log.i("123", "angle" + pie.getAngle());
        }
    }
}
