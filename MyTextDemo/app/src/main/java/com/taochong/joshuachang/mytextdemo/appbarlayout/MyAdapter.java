package com.taochong.joshuachang.mytextdemo.appbarlayout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.taochong.joshuachang.mytextdemo.R;

import java.util.ArrayList;

/**
 * Created by chenzhihong on 2017/9/2.
 */

public class MyAdapter extends BaseAdapter {
    private ArrayList<String> mdatas = new ArrayList<>();
    private Context mContext;

    public MyAdapter(ArrayList<String> mdatas, Context mContext) {

        this.mdatas = mdatas;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mdatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mdatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(mContext, R.layout.item_mytest, null);
        return view;
    }
}
