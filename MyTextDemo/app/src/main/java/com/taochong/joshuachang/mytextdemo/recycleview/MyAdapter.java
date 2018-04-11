package com.taochong.joshuachang.mytextdemo.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.taochong.joshuachang.mytextdemo.R;

import java.util.List;

/**
 * 常守达  2016/12/28 13:18
 * joshuachang0823@gmail.com
 * 1 继承RecyclerView.Adapter<自定义ViewHolder></>
 * 2 在Adapter中创建自定义ViewHolder 继承Recycleview.ViewHolder
 * 3 实现三个方法
 * oncreatViewHolder:初始化每个Item的View 并创建返回自定义ViewHolder
 * onBindViewHolder:绑定每个item中的数据
 * getItemCount:返回多少条目
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<String> mDatas;

    public MyAdapter(Context context, List<String> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
    }

    /**
     * 初始化每个item的view
     * 并返回自定义的ViewHolder
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_myslidingmenu, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    /**
     * 绑定数据 设置每个item中的控件的数据
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
      holder.tv1.setText("什么鬼");
        if (position%2==1){
            holder.tv2.setText(mDatas.get(position));
        }else {
            holder.tv2.setVisibility(View.GONE);
        }

        if (mListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(position,holder.itemView);
                }
            });
//            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View v) {
//                    return false;
//                }
//            });
        }
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv1,tv2;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.tv1);
            tv2 = (TextView) itemView.findViewById(R.id.tv2);
        }
    }
    /**
     * 添加一个条目
     */
    public void addItem(int pos,String str){
        mDatas.add(pos,str);
        notifyDataSetChanged();
    }
    /**
     * 删除一个条目
     */
public void deleteItem(int pos){
    mDatas.remove(pos);
    notifyDataSetChanged();
}
    /**
     * 写个item监听的接口
     */
interface OnItemClickListener{
        void onItemClick(int pos,View view);
        // void onLongItemClick(int pos,View view);
    }
    private OnItemClickListener mListener;
    public void setOnItemClickListener(OnItemClickListener listener){
        this.mListener=listener;
    }


}
