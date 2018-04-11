package com.taochong.joshuachang.mytextdemo.recycleview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.taochong.joshuachang.mytextdemo.R;

import java.util.ArrayList;
import java.util.List;


/**
 * 常守达  2016/12/28 10:36
 * joshuachang0823@gmail.com
 * scrollview嵌套recycleview
 */

public class MyRecycleViewActivtiy extends Activity {
    private RecyclerView my_recycle;

    private List<String> mDatas;
    private MyAdapter myAdapter;

    private Button bt_add;
    private Button bt_del;
    private LinearLayout ll_report;
private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);
        initView();
        initData();

    }

    //初始化数据 添加监听器 填充布局
    private void initData() {
        for (int i = 0; i < 50; i++) {
            mDatas.add(30000 + 1000 * i + "");
        }
        myAdapter = new MyAdapter(this, mDatas);
        my_recycle.setAdapter(myAdapter);
        //设置布局管理器
        //LayoutManger:RecycleView 显示的效果
        //GridLayoutManger:网格的效果
        //LinearlayoutManger:线下的效果
        //StaggeredGridlayoutManger:瀑布流的效果
        /**
         * Scrollview嵌套recycleview linelayoutmanger
         */
//        final FullyLinearLayoutManager manager = new FullyLinearLayoutManager(this);
//        manager.setOrientation(LinearLayoutManager.VERTICAL);
//        manager.setSmoothScrollbarEnabled(true);
//        scrollView.smoothScrollTo(0,0);//确保scrollview在顶部
//        my_recycle.setNestedScrollingEnabled(false);
//        my_recycle.setLayoutManager(manager);
/**
 * Scrollview嵌套recycleview gridlayoutmanger
 */
        final FullyGridLayoutManager manager = new FullyGridLayoutManager(this,2);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        manager.setSmoothScrollbarEnabled(true);
        scrollView.smoothScrollTo(0,0);//确保scrollview在顶部
        my_recycle.setNestedScrollingEnabled(false);
        my_recycle.setLayoutManager(manager);

//        my_recycle.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
//        my_recycle.setLayoutManager(new GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false));
//        my_recycle.setLayoutManager(new GridLayoutManager(this,3,GridLayoutManager.HORIZONTAL,false));
//        my_recycle.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        //设置动画效果
        my_recycle.setItemAnimator(new DefaultItemAnimator());
        //添加分割线
        my_recycle.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAdapter.addItem(1, "添加的数据");
            }
        });
        bt_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAdapter.deleteItem(1);
            }
        });
        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, View view) {
                Toast.makeText(MyRecycleViewActivtiy.this, "数据sdd"+pos, Toast.LENGTH_SHORT).show();
            }
        });

        ll_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyRecycleViewActivtiy.this, "数据sdd", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        my_recycle = (RecyclerView) findViewById(R.id.my_recycle);
        bt_add = (Button) findViewById(R.id.bt_add);
        bt_del = (Button) findViewById(R.id.bt_del);
        mDatas = new ArrayList<>();
        ll_report = (LinearLayout) findViewById(R.id.ll_report);
        scrollView= (ScrollView) findViewById(R.id.scrollView);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
