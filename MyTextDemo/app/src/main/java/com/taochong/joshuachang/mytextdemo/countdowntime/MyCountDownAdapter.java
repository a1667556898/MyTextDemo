package com.taochong.joshuachang.mytextdemo.countdowntime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.taochong.joshuachang.mytextdemo.R;

import java.util.List;

/**
 * 常守达  2017/1/3 11:37
 * joshuachang0823@gmail.com
 */

public class MyCountDownAdapter extends BaseAdapter {
    private List<String> mDatas;
    private Context context;
    public MyCountDownAdapter(List<String> mDatas,Context context){
        this.mDatas=mDatas;
        this.context=context;
    }
    @Override
    public int getCount() {
        return mDatas==null?0:mDatas.size();
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
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_myslidingmenu,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (position%3==1){
            holder.tv2.setText(getTimeFromInt(Long.parseLong(mDatas.get(position))));
        }else {
            holder.tv2.setText("hahaah");
        }

        return convertView;
    }
    public class ViewHolder{
        TextView tv1;
        TextView tv2;
        protected ViewHolder(View view){
            tv2= (TextView) view.findViewById(R.id.tv2);
            tv1= (TextView) view.findViewById(R.id.tv1);
        }

    }
    public String getTimeFromInt(long time) {
        if (time <= 0) { return "已结束"; }
        long day = time / (1000 * 60 * 60 * 24);
        long hour = time / (1000 * 60 * 60) % 24;
        long minute = time / (1000 * 60) % 60;
        long second = time / (1000) % 60;
        return "还剩：" + day + "天" + hour + "小时" + minute + "分" + second + "秒";
    }

}
