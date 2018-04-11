package com.taochong.joshuachang.mytextdemo.recycleview.pulltorecycleview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.chanven.lib.cptr.PtrClassicFrameLayout;
import com.chanven.lib.cptr.PtrDefaultHandler;
import com.chanven.lib.cptr.PtrFrameLayout;
import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;
import com.taochong.joshuachang.mytextdemo.R;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * 常守达  2017/1/4 14:55
 * joshuachang0823@gmail.com
 * <p>
 * 能不能添加头部和分割线呢？
 */

public class MyPulltoRecycleViewActivity extends Activity {
    public static final String TAG = "MyPullto";
    private PtrClassicFrameLayout ptrClassicFrameLayout;
    private RecyclerView my_pullRecyc;
    private SampleAdapter Adapter;
    private RecyclerAdapterWithHF mAdapter;
    private LinearLayoutManager layoutManger;
    private String URL = "https://www.baidu.com/";
    private String URL1 = "http://www.163.com/";
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulltorecycleview);
        initView();
        initData();
    }

    private void initData() {
        Adapter = new SampleAdapter();
        layoutManger = new LinearLayoutManager(this);
        layoutManger.setOrientation(LinearLayoutManager.VERTICAL);
        my_pullRecyc.setLayoutManager(layoutManger);
        mAdapter = new RecyclerAdapterWithHF(Adapter);
        my_pullRecyc.setAdapter(mAdapter);
        //1 进入就刷新的操作
        ptrClassicFrameLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                ptrClassicFrameLayout.autoRefresh(true);
//                NetRequse(URL);这里不需要再进行网络请求 因为已经设置刷新了所以会调用下面的方法
            }
        }, 0);
        //2 下拉刷新的操作在刷新前进行网络下载
        ptrClassicFrameLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                NetRequse(URL);
                ptrClassicFrameLayout.refreshComplete();
                ptrClassicFrameLayout.setLoadMoreEnable(true);
            }
        });

        //3 上拉加载刷新 网络请求太快 上拉动画看不到 如果要看动画可以按下面方法延时几秒才刷新 另外：没有数据时最后一个会出来不下去 可以弹框提示
        ptrClassicFrameLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void loadMore() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        NetRequse(URL1);
                        ptrClassicFrameLayout.loadMoreComplete(true);
                    }
                }, 200);
            }
        });

    }

    private void initView() {
        my_pullRecyc = (RecyclerView) findViewById(R.id.my_pullRecyc);
        ptrClassicFrameLayout = (PtrClassicFrameLayout) findViewById(R.id.test_list_view_frame);
        TextView tv_skip = (TextView) findViewById(R.id.tv_skip);
        tv_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyPulltoRecycleViewActivity.this, MyPulltoScrollviewActivity.class);
                startActivity(intent);
            }
        });
    }

    private void NetRequse(String url) {
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.i(TAG, e.toString());
            }

            @Override
            public void onResponse(String response, int id) {
                Log.i(TAG, response);
            }
        });

    }
}
