package com.taochong.joshuachang.mytextdemo.canavas;

import android.content.Context;
import android.graphics.*;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.taochong.joshuachang.mytextdemo.R;

/**
 * 常守达  2016/12/16 10:11
 * joshuachang0823@gmail.com
 * 动画对号
 */

public class CheckView extends View {
    private static final int ANIM_NULL = 0;
    private static final int ANIM_CHECK = 1;
    private static final int ANIM_UNCHECK = 2;

    private Context mContext;//上下文
    private int mWidth, mHeight;//宽高
    private Handler mHandler;//handler

    private Paint mPaint;
    private Bitmap okBitmap;

    private int animCurrentPage = -1;//当前页码
    private int animMaxPage = 13;//总页数
    private int animDuration = 500;//动画耗时
    private int animState = ANIM_NULL;//动画状态

    private boolean isCheck = false;//是否只选中状态

    public CheckView(Context context) {
        super(context);
    }

    public CheckView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        mPaint = new Paint();
        mPaint.setColor(0xffff5317);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        okBitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.check);
       mHandler=new Handler(){
           @Override
           public void handleMessage(Message msg) {
               super.handleMessage(msg);
               if (animCurrentPage<animMaxPage&&animCurrentPage>=0){
                   invalidate();
                   if (animState==ANIM_NULL){
                       return;
                   }
                   if (animState==ANIM_CHECK){
                       animCurrentPage++;
                   }else if(animState==ANIM_UNCHECK){
                       animCurrentPage--;
                   }
                   this.sendEmptyMessageDelayed(0,animDuration/animMaxPage);
                   Log.i("123","Count"+animCurrentPage);
               }else {
                   if (isCheck){
                       animCurrentPage=animMaxPage-1;
                   }else {
                       animCurrentPage=-1;
                   }
                   invalidate();
                   animState=ANIM_NULL;
               }
           }
       };
    }
    /**
     * view大小的确认
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth=w;
        mHeight=h;
    }
    /**
     * 绘制内容
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //移动坐标系到画布中央
        canvas.translate(mWidth/2,mHeight/2);
        //绘制背景图形
        canvas.drawCircle(0,0,240,mPaint);
//        得出图像边长
        int sideLength=okBitmap.getHeight();
//        得出图形选区和实际绘制位置
        Rect src=new Rect(sideLength*animCurrentPage,0,sideLength*(animCurrentPage + 1),sideLength);
        Rect dst=new Rect(-200,-200,200,200);
        //绘制
        canvas.drawBitmap(okBitmap,src,dst,null);
    }
    /**
     * 选择
     */
    public void check(){
        if (animState!=ANIM_NULL||isCheck) {
            return;
        }
            animState=ANIM_CHECK;
            animCurrentPage=0;
            mHandler.sendEmptyMessageDelayed(0,animDuration/animMaxPage);
            isCheck=true;
        }
/**
 * 取消选择
 */
    public void unCheck(){
        if (animState!=ANIM_NULL||(!isCheck)){
            return;
        }
        animState=ANIM_UNCHECK;
        animCurrentPage=animMaxPage-1;
        mHandler.sendEmptyMessageDelayed(0,animDuration/animMaxPage);
        isCheck=false;
    }
    /**
     * 设置动画=时长
     */
    public void setAnimDuration(int animDuration) {
        if (animDuration<=0) {
            return;
        }
            this.animDuration=animDuration;
        }
    /**
     * 设置背景行颜色
     */
    public void setBackgroundColor(int color){
        mPaint.setColor(color);
    }

}

