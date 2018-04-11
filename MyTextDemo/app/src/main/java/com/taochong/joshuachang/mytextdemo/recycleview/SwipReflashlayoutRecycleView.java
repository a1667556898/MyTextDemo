package com.taochong.joshuachang.mytextdemo.recycleview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.taochong.joshuachang.mytextdemo.R;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;


/**
 * 常守达  2017/1/3 16:16
 * joshuachang0823@gmail.com
 * 上拉加载 下拉刷新 swipreflishlayout 1 都用swip 2 加载更多添加尾部
 */

public class SwipReflashlayoutRecycleView extends Activity {
    public static final String TAG = "Swip";
    private SwipeRefreshLayout swipe_refresh_widget;
    private RecyclerView list;
    private SampleAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    private String URL = "https://www.baidu.com/";
    private String URL1 = "http://api.taopet.com/beta/Store/Pet/GetInfo";//pid=1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swiprecycleview);
        initView();
        initData();
    }

    private void initData() {
        swipe_refresh_widget.post(new Runnable() {
            @Override
            public void run() {
                swipe_refresh_widget.setRefreshing(true);
                    NetRequse(URL);//1 进去是加载
            }
        });

        swipe_refresh_widget.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //在这里联网请求  2 上拉刷新
                NetRequse(URL);
            }
        });
/**
 * 上拉加载
 */
        list.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int lastVisibleItem;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == mAdapter.getItemCount()) {
//                    swipe_refresh_widget.setRefreshing(true);//上拉是显示圈圈是方法之一 可以不显示 也可以显示脚部（这个不会写了）
                    //在这里联网请求
                    NetRequse(URL);//3 上拉刷新
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();

            }
        });
    }

    private void initView() {
        swipe_refresh_widget = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_widget);
        list = (RecyclerView) findViewById(R.id.list);
        swipe_refresh_widget.setColorSchemeResources(R.color.color1, R.color.color2, R.color.color3);
        //圈圈背景色
        swipe_refresh_widget.setProgressBackgroundColorSchemeResource(android.R.color.holo_orange_light);
        //圈圈的大小
        swipe_refresh_widget.setSize(SwipeRefreshLayout.LARGE);
        //这句话是为了 第一次进入页面时显示加载进度条
//        swipe_refresh_widget.setRefreshing(true);//直接进去加载没效果



        list.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(mLayoutManager);
        list.setItemAnimator(new DefaultItemAnimator());

        mAdapter = new SampleAdapter();
        list.setAdapter(mAdapter);
    }

    private void NetRequse(String url) {
        OkHttpUtils.get().url(URL).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.i(TAG, e.toString());
            }

            @Override
            public void onResponse(String response, int id) {
                Log.i(TAG, response);
            }
        });
        swipe_refresh_widget.setRefreshing(false);//取消旋转
    }

}
