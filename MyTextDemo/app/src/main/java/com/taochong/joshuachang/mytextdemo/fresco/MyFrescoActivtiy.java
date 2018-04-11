package com.taochong.joshuachang.mytextdemo.fresco;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.taochong.joshuachang.mytextdemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 常守达  2016/12/27 09:18
 * joshuachang0823@gmail.com
 */

public class MyFrescoActivtiy extends Activity {


    @Bind(R.id.bt_showCach)
    Button btShowCach;
    @Bind(R.id.bt_cleanCach)
    Button btCleanCach;
    @Bind(R.id.img)
    SimpleDraweeView img;
    @Bind(R.id.bt_changeSize)
    Button btChangeSize;
    private String URL1 = "sdsds";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtiy_fresco);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        URL1 = getResources().getString(R.string.girl1);
        //动态改变图片大小
        int width = getWindowManager().getDefaultDisplay().getWidth();
        int height= (int) Math.abs(width*0.9);
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(width,height);
//        RoundingParams p=new RoundingParams();

        img.setLayoutParams(param);
        img.setImageURI(Uri.parse(URL1));//加载网络
//        img.setImageURI(Uri.parse("res:///"+R.mipmap.load));//加载资源文件
        //加载动图
//        Uri uri=Uri.parse("res:///"+R.mipmap.load);
//        DraweeController draweeControl=Fresco.newDraweeControllerBuilder()
//                .setUri(uri)
//                .setAutoPlayAnimations(true)
//                .build();
//        img.setController(draweeControl);
    }


    @OnClick({R.id.bt_showCach, R.id.bt_cleanCach, R.id.img})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_showCach:
                //显示缓存
                long cacheSize = Fresco.getImagePipelineFactory().getMainDiskStorageCache().getSize();
                Log.i("123", "缓存图片" + cacheSize);
                break;
            case R.id.bt_cleanCach:
                //清理缓存
                ImagePipeline imagePipeline = Fresco.getImagePipeline();
                imagePipeline.clearCaches();//耗时操作
                long cacheSize1 = Fresco.getImagePipelineFactory().getMainDiskStorageCache().getSize();
                Log.i("123", "缓存图片1" + cacheSize1);
                break;
            case R.id.img:
                //动态改变长宽
                break;
            case R.id.bt_changeSize:
                //动态改变长宽

                break;
        }
    }
}
