package com.taochong.joshuachang.mytextdemo.myviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.EditText;

import com.taochong.joshuachang.mytextdemo.R;

/**
 * 常守达  2016/11/16 10:40
 * 属性的使用流程
 * 1 value中定义（declare-styleable>标签 还有<attr></attr>
 * 2 layout.xml使用（1 命名名称空间 2 通过名称空间名字使用对应的attr属性
 * 3 动态代码通过2个参数的构造方法解析Context Attributeset解析获得实际设置的值
 * 获取属性的值 实现绘制，设置的逻辑
 *
 */
public class MyNoteBookView extends EditText {
    //默认边距为0
    private int padding=0;
    //默认颜色为黑色
    private int underline_color= Color.BLACK;
    private Paint paint;
    public MyNoteBookView(Context context) {
        super(context);
    }
//使用attrs解析自定义属性
    public MyNoteBookView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context,attrs);
        init();
    }

    public MyNoteBookView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void initAttrs(Context context,AttributeSet attrs){
//调用obtainStyledAttributes解析属性的方法
        TypedArray array=context.obtainStyledAttributes(attrs, R.styleable.MyNoteAtrrs);
        padding= (int) array.getDimension(R.styleable.MyNoteAtrrs_padding,padding);
        underline_color=array.getColor(R.styleable.MyNoteAtrrs_underline_color,underline_color);
        array.recycle();
    }
    private void init(){
        //移动光标默认起始位置
setGravity(Gravity.LEFT|Gravity.TOP);
        paint=new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(2);
        //画笔颜色就是属性设置的颜色
        paint.setColor(underline_color);
        //改padding 是设置自定义Edittext的左右边距
        setPadding(padding,0,padding,0);
    }
    /**
     * 绘制下划线 设置边距
     *
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int viewHeight=getMeasuredHeight();
        int viewWidth=getMeasuredWidth();
        //EditText提供行高
        int lineHeight=getLineHeight();
        int lineCount=viewHeight/lineHeight;
        //循环遍历划线
        for(int i=0;i<lineCount;i++){
            //其实x坐标padding
            //其实y坐标行高 每一行都要累计加高度
            //终止x坐标点
            canvas.drawLine(padding,lineHeight*(i+1),viewWidth-padding,lineHeight*(i+1),paint);
        }
    }
}
