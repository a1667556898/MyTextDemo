package com.taochong.joshuachang.mytextdemo.shoppingbag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.taochong.joshuachang.mytextdemo.R;

import java.util.List;


/**
 * 常守达  2016/12/29 14:34
 * joshuachang0823@gmail.com
 */

public class MyShopBagAdapter extends BaseAdapter {
    private List<String> mDatas;
    private ListView mListView;
    private Context context;

    public MyShopBagAdapter(Context context, ListView listView) {
        this.context = context;
        this.mListView = listView;
    }

    public void setCartDataGroup(List<String> mDatas) {
        this.mDatas = mDatas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.shopping_list_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_warehouseName.setText(mDatas.get(position));
        holder.product_child.setCartGroup(mDatas, false, mListView, this, position);
        return convertView;
    }

    class ViewHolder {
        TextView tv_warehouseName;
       CartLinearLayout product_child;
        ViewHolder(View view) {
            tv_warehouseName = (TextView) view.findViewById(R.id.tv_warehouseName);
            product_child= (CartLinearLayout) view.findViewById(R.id.product_child);
        }
    }
}
