package com.taochong.joshuachang.mytextdemo.updownload;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.taochong.joshuachang.mytextdemo.R;
import com.taochong.joshuachang.mytextdemo.updownload.download.DownLoadUtils;
import com.taochong.joshuachang.mytextdemo.updownload.download.DownloadApk;
import com.taochong.joshuachang.mytextdemo.updownload.okhttpupdate.DownloadService;

/**
 * 常守达  2017/1/5 17:11
 * joshuachang0823@gmail.com
 */

public class MyUpdownLoadActivity extends Activity {
    private TextView tv_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updown);
        //1.注册下载广播接收器
        DownloadApk.registerBroadcast(this);
        //2.删除已存在的Apk
        DownloadApk.removeFile(this);
        tv_update = (TextView) findViewById(R.id.tv_update);
        tv_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //3.如果手机已经启动下载程序，执行downloadApk。否则跳转到设置界面
                if (DownLoadUtils.getInstance(getApplicationContext()).canDownload()) {
                    DownloadApk.downloadApk(getApplicationContext(), "http://www.huiqu.co/public/download/apk/huiqu.apk", "Hobbees更新", "Hobbees");
                } else {
                    DownLoadUtils.getInstance(getApplicationContext()).skipToDownloadManager();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        //4.反注册广播接收器
        DownloadApk.unregisterBroadcast(this);
        super.onDestroy();
    }


    //如果用okhttp下载的话
    //先判断版本号 然后执行下面的 没试过
    //参考网址http://blog.csdn.net/derbe/article/details/53197218
    public void okhttpupdate() {
        Intent intent = new Intent(this, DownloadService.class);
        intent.putExtra("apkUrl", "APK下载地址");
        startService(intent);
    }

}
