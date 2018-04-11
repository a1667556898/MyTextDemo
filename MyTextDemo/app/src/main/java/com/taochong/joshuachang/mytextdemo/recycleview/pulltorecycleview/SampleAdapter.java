package com.taochong.joshuachang.mytextdemo.recycleview.pulltorecycleview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.taochong.joshuachang.mytextdemo.R;

/**
 * 常守达  2017/1/3 18:12
 * joshuachang0823@gmail.com
 */

public class SampleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static int Num=50;

    public SampleAdapter() {

    }

    @Override
    public int getItemCount() {
        return Num;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recyc_addheadview, null);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }


    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ItemViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.text);
        }
    }
}
