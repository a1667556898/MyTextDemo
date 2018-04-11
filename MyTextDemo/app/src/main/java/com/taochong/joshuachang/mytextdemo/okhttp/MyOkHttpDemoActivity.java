package com.taochong.joshuachang.mytextdemo.okhttp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.google.gson.Gson;
import com.taochong.joshuachang.mytextdemo.R;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 常守达  2016/12/27 09:20
 * joshuachang0823@gmail.com
 */

public class MyOkHttpDemoActivity extends Activity {
    //    private String URL = "https://hao.qq.com/?unc=o400493_1&s=o400493_1";
    private String URL = "http://api.taopet.com/beta/Cart/GetList";
    private String URL1 = "https://www.baidu.com/";


    private TextView tv_okhttp;
    private WebView web;
    Bean bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        tv_okhttp = (TextView) findViewById(R.id.tv_okhttp);
//        initOkhttp();
//        initokhttpPost();
//        initFileup();//文件上传
//        initFileDown();//文件下载
        initWeb();
//        initMyOk();
//        initMyPost();
    }

    private void initMyPost() {
        OkHttpUtils.post().url(URL).addParams("uid", "37").build().execute(new Callback() {
            @Override
            public Object parseNetworkResponse(Response response, int id) throws Exception {
                Log.i("123", "hahaww");
                bean = new Gson().fromJson(response.body().string(), Bean.class);
                Log.i("123", "haha" + bean.getCode());

                prity(bean);
                tv_okhttp.setText(bean.getMsg());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        tv_okhttp.setText(bean.getMsg());
                    }
                });

                return null;
            }

            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(Object response, int id) {

            }
        });
    }

    private void prity(Bean bean) {
        Log.i("123", "haha" + bean.getMsg());
    }

    private void initMyOk() {
        OkHttpUtils.get().url(URL1).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.i("123", "okhttputils测试" + e);
            }

            @Override
            public void onResponse(String response, int id) {
                Log.i("123", "okhttputils测试" + response);
            }
        });
    }

    private void initWeb() {
        web = (WebView) findViewById(R.id.web);
        //设置和WebView有关的属性,在WebSettings设置
        WebSettings settings = web.getSettings();
        //显示缩放控件
        settings.setBuiltInZoomControls(true);
        settings.setLoadWithOverviewMode(true);
        //加载的图片缩放至屏幕合适的大小
        settings.setUseWideViewPort(true);
        //支持JS语句
        settings.setJavaScriptEnabled(true);
        web.setWebChromeClient(new WebChromeClient());
        web.setWebViewClient(new WebViewClient());
        //加载本地的Html文件
//        web.loadUrl("file:///android_asset/order_info.html");
        web.loadUrl("http://api.taopet.com/web/order_list.html");

    }

    private void initFileup() {
//        File file = new File(Environment.getExternalStorageDirectory(), "balabala.mp4");//文件地址
//        OkHttpClient mokhttpClient = new OkHttpClient();
//        RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream"), file);
//        RequestBody requestBody = new MultipartBuilder()
//                .type(MultipartBuilder.FORM)
//                .addPart(Headers.of("Content-Disposition", "form-data;name=\"username\""), RequestBody.create(null, "站弘扬"))
//                .addPart(Headers.of("Content-Disposition", "form-data;name=\"mFile\";filename=\"wjd.mp4\""), fileBody).build();
//        Request request = new Request.Builder()
//                .url("http://192.168.1.103:8080/okHttpServer/fileUpload")
//                .post(requestBody)
//                .build();
//        Call call = mokhttpClient.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Request request, IOException e) {
//                Log.i("123", "okhttp测试" + e);
//            }
//
//            @Override
//            public void onResponse(Response response) throws IOException {
//                Log.i("123", "okhttp测试" + response.body().string());
//            }
//        });

    }

    private void initokhttpPost() {
//        OkHttpClient mokhttpClient = new OkHttpClient();
//        FormEncodingBuilder build = new FormEncodingBuilder();
//        build.add("uid", "37");
//        Request request = new Request.Builder().url(URL)
//                .post(build.build())
//                .build();
//        Call call = mokhttpClient.newCall(request);
//        //请求加入调度
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Request request, IOException e) {
//                Log.i("123", "okhttp测试" + e);
//            }
//
//            @Override
//            public void onResponse(Response response) throws IOException {
//                Log.i("123", "okhttp测试" + response.body().string());
//
//            }
//        });
    }

    private void initOkhttp() {
//        Log.i("123", "okhttp测试" + "demo");//创建okHttpClient对象
//        OkHttpClient mOkHttpClient = new OkHttpClient();
//        //创建一个Request
//        Request requst = new Request.Builder()
//                .url(URL)
//                .build();
////new call
//        Call call = mOkHttpClient.newCall(requst);
//        //请求加入调度
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Request request, IOException e) {
//                Log.i("123", "okhttp测试" + e);
//            }
//
//            @Override
//            public void onResponse(Response response) throws IOException {
////                Log.i("123", "okhttp测试" + response.body().string());
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        tv_okhttp.setText("挑梁小丑");
//                    }
//                });
//            }
//        });
    }
}
