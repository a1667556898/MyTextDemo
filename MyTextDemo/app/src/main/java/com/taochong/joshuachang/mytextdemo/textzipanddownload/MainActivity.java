package com.taochong.joshuachang.mytextdemo.textzipanddownload;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import com.taochong.joshuachang.mytextdemo.R;

/**
 * 常守达  2017/1/3 14:24
 * joshuachang0823@gmail.com
 */

public class MainActivity extends Activity {
    private final String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Environment.getExternalStorageDirectory()="+ Environment.getExternalStorageDirectory());
        Log.d(TAG, "getCacheDir().getAbsolutePath()="+getCacheDir().getAbsolutePath());

        showDownLoadDialog();
        //doZipExtractorWork();
        //doDownLoadWork();
    }


    private void showDownLoadDialog(){
        new AlertDialog.Builder(this).setTitle("确认")
                .setMessage("是否下载？")
                .setPositiveButton("是", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        Log.d(TAG, "onClick 1 = "+which);
                        doDownLoadWork();
                    }
                })
                .setNegativeButton("否", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        Log.d(TAG, "onClick 2 = "+which);
                    }
                })
                .show();
    }

    public void showUnzipDialog(){
        new AlertDialog.Builder(this).setTitle("确认")
                .setMessage("是否解压？")
                .setPositiveButton("是", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        Log.d(TAG, "onClick 1 = "+which);
                        doZipExtractorWork();
                    }
                })
                .setNegativeButton("否", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        Log.d(TAG, "onClick 2 = "+which);
                    }
                })
                .show();
    }

    public void doZipExtractorWork(){
        //ZipExtractorTask task = new ZipExtractorTask("/storage/usb3/system.zip", "/storage/emulated/legacy/", this, true);
        ZipExtractorTask task = new ZipExtractorTask("/storage/emulated/legacy/testzip.zip", "/storage/emulated/legacy/", this, true);
        task.execute();
    }

    private void doDownLoadWork(){
        DownLoaderTask task = new DownLoaderTask("http://192.168.9.155/johnny/testzip.zip", "/storage/emulated/legacy/", this);
        //DownLoaderTask task = new DownLoaderTask("http://192.168.9.155/johnny/test.h264", getCacheDir().getAbsolutePath()+"/", this);
        task.execute();
    }


}
