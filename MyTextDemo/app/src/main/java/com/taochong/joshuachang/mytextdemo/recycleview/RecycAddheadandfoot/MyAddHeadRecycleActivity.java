package com.taochong.joshuachang.mytextdemo.recycleview.RecycAddheadandfoot;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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
 * 常守达  2017/1/4 10:27
 * joshuachang0823@gmail.com
 * 添加头部和尾部 添加有下拉刷新类似pulltoreflish
 */

public class MyAddHeadRecycleActivity extends Activity {
    public static final String TAG = "MyAddHead";
    private PtrClassicFrameLayout ptrClassicFrameLayout;
    private RecyclerAdapterWithHF Adapter;
    private RecyclerView My_Recycle;
    private MyAddHeadRecycAdapter mAdapter;

    GridLayoutManager gridLayoutManager;
    LinearLayoutManager layoutManger;

    private String URL = "https://www.baidu.com/";
    private String URL1 = "http://www.163.com/";
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycaddhead);
        initView();
        initData();
    }

    private void initView() {
        My_Recycle = (RecyclerView) findViewById(R.id.My_Recycle);
        ptrClassicFrameLayout = (PtrClassicFrameLayout) findViewById(R.id.test_list_view_frame);
        //List布局
//        layoutManger = new LinearLayoutManager(this);
//        layoutManger.setOrientation(LinearLayoutManager.VERTICAL);
//        My_Recycle.setLayoutManager(layoutManger);
//        mAdapter = new MyAddHeadRecycAdapter(this);
//        My_Recycle.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));//添加分割条
//      不要了这行  My_Recycle.setAdapter(mAdapter);
        //Grid布局
        gridLayoutManager=new GridLayoutManager(this,2);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);

        My_Recycle.setLayoutManager(gridLayoutManager);

        mAdapter=new MyAddHeadRecycAdapter(this);
        My_Recycle.setAdapter(mAdapter);

//        要不要头部
        mAdapter.mBottomCount=1;
        mAdapter.notifyDataSetChanged();

//        Grid布局需要添加的
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (mAdapter.isHeaderView(position)||mAdapter.isBottomView(position)||position%3==1)?gridLayoutManager.getSpanCount():1;
            }
        });
    }

    private void initData() {
        Adapter = new RecyclerAdapterWithHF(mAdapter);
        My_Recycle.setAdapter(Adapter);
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
