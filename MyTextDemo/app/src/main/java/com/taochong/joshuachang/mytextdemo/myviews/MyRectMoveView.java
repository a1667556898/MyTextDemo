package com.taochong.joshuachang.mytextdemo.myviews;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * 常守达  2016/11/16 10:02
 * joshuachang0823@gmail.com
 */
public class MyRectMoveView extends View {
    private MyRect myRect;
    public MyRectMoveView(Context context) {
        super(context);
        init();
    }

    public MyRectMoveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyRectMoveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        myRect.drawSelf(canvas);
    }

    /**
     * 主线程刷新view用invalidate
     * 子线程刷新view用postInvalidate
     */
    public void init(){
        myRect=new MyRect();
      new Thread(new Runnable() {
          @Override
          public void run() {
              while (true){
                  try {
                      Thread.sleep(600);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  postInvalidate();
              }
          }
      }).start();
    }
}
