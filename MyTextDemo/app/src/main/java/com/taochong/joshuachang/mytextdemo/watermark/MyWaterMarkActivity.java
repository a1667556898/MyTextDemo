package com.taochong.joshuachang.mytextdemo.watermark;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.taochong.joshuachang.mytextdemo.R;

/**
 * Created by chenzhihong on 2017/9/25.
 * 图片添加水印
 * 地址--Bitmap--添加水印--Bitmap--转化为Base64或者流上传服务器
 * 水印的旋转问题
 * 参考：http://blog.csdn.net/dawanganban/article/details/51148070
 */

public class MyWaterMarkActivity extends AppCompatActivity {
    private TextView tv_addwater;
    private ImageView img;
    private ImageView img1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mywatermark);
        tv_addwater = (TextView) findViewById(R.id.tv_addwater);
        img = (ImageView) findViewById(R.id.img);
        img1 = (ImageView) findViewById(R.id.img1);
        tv_addwater.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bitmap baseBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.retry);
                Bitmap baseBitmap1 = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                Bitmap waterBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ico_shuiyin);


/**
 * 对水印进行缩放处理的操作
 */
//                Bitmap newwaterBitmap = scaleWithWH(waterBitmap, baseBitmap.getWidth(), baseBitmap.getHeight());
//                Bitmap newwaterBitmap1 = scaleWithWH(waterBitmap, baseBitmap1.getWidth(), baseBitmap1.getHeight());
//                Bitmap bitmap = creatWaterMaskCenter(baseBitmap, newwaterBitmap);
//                Bitmap bitmap1 = creatWaterMaskCenter(baseBitmap1, newwaterBitmap1);
//                img.setImageBitmap(bitmap);
//                img1.setImageBitmap(bitmap1);
                /**
                 * 没有处理的操作
                 */
//                Bitmap bitmap = creatWaterMaskLeftTop(MyWaterMarkActivity.this, baseBitmap, waterBitmap, 10, 10);
//                Bitmap bitmap = creatWaterMaskRightBottom(MyWaterMarkActivity.this, baseBitmap, waterBitmap, 10, 10);
//                Bitmap bitmap = creatWaterMaskLeftBottom(MyWaterMarkActivity.this, baseBitmap, waterBitmap, 10, 10);
//                Bitmap bitmap = creatWaterMaskRightTop(MyWaterMarkActivity.this, baseBitmap, waterBitmap, 10, 10);

                //添加文字
//                Bitmap bitmap = drawTextToLeftTop(MyWaterMarkActivity.this, baseBitmap, "这不是演习", 20, getResources().getColor(R.color.black), 30, 20);
//                Bitmap bitmap = drawTextToRightTop(MyWaterMarkActivity.this, baseBitmap, "这不是演习", 20, getResources().getColor(R.color.black), 30, 20);
//                Bitmap bitmap = drawTextToLeftBottom(MyWaterMarkActivity.this, baseBitmap, "这不是演习", 20, getResources().getColor(R.color.black), 30, 20);
//                Bitmap bitmap = drawTextToRightBottom(MyWaterMarkActivity.this, baseBitmap, "这不是演习", 20, getResources().getColor(R.color.black), 30, 20);
                Bitmap bitmap = drawTextToCenter(MyWaterMarkActivity.this, baseBitmap, "这不是演习", 20, getResources().getColor(R.color.black));
                img.setImageBitmap(bitmap);

            }
        });
    }

    /**
     * 水印在左上角
     */


    public Bitmap creatWaterMaskLeftTop(Context context, Bitmap src, Bitmap watermark, int paddingLeft, int paddingTop) {
        return createWaterMaskBitmap(src, watermark, dp2px(context, paddingLeft), dp2px(context, paddingTop));
    }

    /**
     * 右下角
     */

    public Bitmap creatWaterMaskRightBottom(Context context, Bitmap src, Bitmap waterMark, int paddingRight, int paddingBottom) {
        return createWaterMaskBitmap(src, waterMark, src.getWidth() - dp2px(context, paddingRight) - waterMark.getWidth(), src.getHeight() - dp2px(context, paddingBottom) - waterMark.getHeight());
    }

    /**
     * 左下角
     */

    public Bitmap creatWaterMaskLeftBottom(Context context, Bitmap src, Bitmap waterMark, int paddingLeft, int paddingBottom) {
        return createWaterMaskBitmap(src, waterMark, dp2px(context, paddingLeft), src.getHeight() - dp2px(context, paddingBottom) - waterMark.getHeight());
    }

    /**
     * 右上角
     */
    public Bitmap creatWaterMaskRightTop(Context context, Bitmap src, Bitmap waterMark, int paddingRight, int paddingTop) {
        return createWaterMaskBitmap(src, waterMark, src.getWidth() - dp2px(context, paddingRight) - waterMark.getWidth(), dp2px(context, paddingTop));
    }

    /**
     * 中间
     */
    public Bitmap creatWaterMaskCenter(Bitmap src, Bitmap waterMark) {
        return createWaterMaskBitmap(src, waterMark, (src.getWidth() - waterMark.getWidth()) / 2, (src.getHeight() - waterMark.getHeight()) / 2);
    }

    private Bitmap createWaterMaskBitmap(Bitmap src, Bitmap watermark,
                                         int paddingLeft, int paddingTop) {
        if (src == null) {
            return null;
        }
        int width = src.getWidth();
        int height = src.getHeight();
        //创建一个bitmap
        Bitmap newb = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);// 创建一个新的和SRC长度宽度一样的位图
        //将该图片作为画布
        Canvas canvas = new Canvas(newb);
        //在画布 0，0坐标上开始绘制原始图片
        canvas.drawBitmap(src, 0, 0, null);
        //在画布上绘制水印图片
        canvas.drawBitmap(watermark, paddingLeft, paddingTop, null);
        // 保存
        canvas.save(Canvas.ALL_SAVE_FLAG);
        // 存储
        canvas.restore();
        return newb;
    }

    /**
     * 给图片添加文字到左上角
     */
    public Bitmap drawTextToLeftTop(Context context, Bitmap bitmap, String text, int size, int color, int paddingLeft, int paddingTop) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);//抗锯齿
        paint.setColor(color);
        paint.setTextSize(dp2px(context, size));
        Rect bounds = new Rect();
        paint.getTextBounds(text, 0, text.length(), bounds);
        return drawTextToBitmap(context, bitmap, text, paint, bounds, dp2px(context, paddingLeft),
                dp2px(context, paddingTop) + bounds.height());

    }

    /**
     * 给图片添加文字到右上角
     */
    public Bitmap drawTextToRightTop(Context context, Bitmap bitmap, String text, int size, int color, int paddingRight, int paddingTop) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);//抗锯齿
        paint.setColor(color);
        paint.setTextSize(dp2px(context, size));
        Rect bounds = new Rect();
        paint.getTextBounds(text, 0, text.length(), bounds);
        return drawTextToBitmap(context, bitmap, text, paint, bounds, bitmap.getWidth() - bounds.width() - dp2px(context, paddingRight),
                dp2px(context, paddingTop) + bounds.height());

    }

    /**
     * 绘制文字到左下方
     *
     * @param context
     * @param bitmap
     * @param text
     * @param paddingLeft
     * @return
     */
    public Bitmap drawTextToLeftBottom(Context context, Bitmap bitmap, String text, int size, int color, int paddingLeft, int paddingBottom) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setTextSize(dp2px(context, size));
        Rect bounds = new Rect();
        paint.getTextBounds(text, 0, text.length(), bounds);
        return drawTextToBitmap(context, bitmap, text, paint, bounds, dp2px(context,paddingLeft), bitmap.getHeight()-dp2px(context,paddingBottom));
    }
    /**
     * 绘制文字到右下方
     *
     * @param context
     * @param bitmap
     * @param text
     * @return
     */
    public Bitmap drawTextToRightBottom(Context context, Bitmap bitmap, String text, int size, int color, int paddingRight, int paddingBottom) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setTextSize(dp2px(context, size));
        Rect bounds = new Rect();
        paint.getTextBounds(text, 0, text.length(), bounds);
        return drawTextToBitmap(context, bitmap, text, paint, bounds, bitmap.getWidth()-bounds.width()-dp2px(context,paddingRight), bitmap.getHeight()-dp2px(context,paddingBottom));
    }
    /**
     * 绘制文字到中间
     *
     * @param context
     * @param bitmap
     * @param text
     * @return
     */
    public Bitmap drawTextToCenter(Context context, Bitmap bitmap, String text, int size, int color) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setTextSize(dp2px(context, size));
        Rect bounds = new Rect();
        paint.getTextBounds(text, 0, text.length(), bounds);
        return drawTextToBitmap(context, bitmap, text, paint, bounds, (bitmap.getWidth()-bounds.width())/2, (bitmap.getHeight()+bounds.height())/2);
    }
    private Bitmap drawTextToBitmap(Context context, Bitmap bitmap, String text, Paint paint, Rect bounds, int paddingLeft, int paddingTop) {
        Bitmap.Config bitmapConfig = bitmap.getConfig();
        paint.setDither(true);//获取更清晰的图像采样
        paint.setFilterBitmap(true);//过滤一些
        if (bitmapConfig == null) {
            bitmapConfig = Bitmap.Config.ARGB_8888;
        }
        bitmap = bitmap.copy(bitmapConfig, true);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawText(text, paddingLeft, paddingTop, paint);
        return bitmap;
    }

    public static int dp2px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    /**
     * 因为有的图像 可能像素大小不一样 所以如果有多个图片需要加水印的话 ，可能会导致水印大小不一样
     * 目前我的解决方法是对水印相对于图pain进行缩放，如果底图差别太大会导致水印严重失真而相差太大
     * 并且给原始的水印不太一样，但基本上可以满足需求
     *
     * @param src
     * @param w
     * @param h
     * @return
     */
    public static Bitmap scaleWithWH(Bitmap src, double w, double h) {
        if (w == 0 || h == 0 || src == null) {
            return src;
        } else {
            // 记录src的宽高
            int width = src.getWidth();
            int height = src.getHeight();
            // 创建一个matrix容器
            Matrix matrix = new Matrix();
            // 计算缩放比例
            float scaleWidth = (float) (w / width);
            float scaleHeight = (float) (h / height);
            // 开始缩放
            matrix.postScale(scaleWidth, scaleHeight);
            // 创建缩放后的图片
            return Bitmap.createBitmap(src, 0, 0, width, height, matrix, true);
        }
    }
}
