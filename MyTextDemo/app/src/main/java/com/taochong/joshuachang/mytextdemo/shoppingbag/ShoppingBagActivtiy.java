package com.taochong.joshuachang.mytextdemo.shoppingbag;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.taochong.joshuachang.mytextdemo.R;

import java.util.ArrayList;
import java.util.List;


/**
 * 常守达  2016/12/29 14:33
 * joshuachang0823@gmail.com
 */

public class ShoppingBagActivtiy extends Activity {
    private ListView mListView;
    private MyShopBagAdapter mShoppingBagAdapter;
    private List<String> mdatas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingbag);
        initView();
        initData();
    }

    private void initData() {
        mdatas=new ArrayList<>();
        for (int i=0;i<20;i++){
            mdatas.add(i+"什么鬼");
        }
        mShoppingBagAdapter.setCartDataGroup(mdatas);
    }

    private void initView() {
        mListView = (ListView)findViewById(R.id.bag_goods_list);
        mShoppingBagAdapter = new MyShopBagAdapter(this, mListView);
        mListView.setAdapter(mShoppingBagAdapter);
    }
}
