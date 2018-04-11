package com.taochong.joshuachang.mytextdemo.recycleview.RecycAddheadandfoot;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.taochong.joshuachang.mytextdemo.R;

/**
 * 常守达  2017/1/4 11:30
 * joshuachang0823@gmail.com
 */

public class MyAddHeadRecycAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //item类型
    public static final int ITEM_TYPE_HEADER = 0;
    public static final int ITEM_TYPE_CONTENT = 1;
    public static final int ITEM_TYPE_BOTTOM = 2;
    public static final int ITEM_TYPE_CONTENT1 = 3;
    //模拟数据
    public String[] texts = {"java", "python", "C++", "Php", ".NET", "js", "Ruby", "Swift", "OC", "sdsds", "C++", "Php", ".NET", "js", "Ruby", "Swift", "OC", "sdsds"};
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    private int mHeaderCount = 1;//头部View个数
    public static int mBottomCount = 1;//底部View个数

    public MyAddHeadRecycAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    //内容长度
    public int getContentItemCount() {
        return texts.length;
    }

    //判断当前item是否是HeadView
    public boolean isHeaderView(int position) {
        return mHeaderCount != 0 && position < mHeaderCount;
    }

    //判断当前item是否是FooterView
    public boolean isBottomView(int position) {
        return mBottomCount != 0 && position >= (mHeaderCount + getContentItemCount());
    }
    //判断当前item类型

    @Override
    public int getItemViewType(int position) {
        int dataItemCount = getContentItemCount();
        if (mHeaderCount != 0 && position < mHeaderCount) {
            //头部
            return ITEM_TYPE_HEADER;
        } else if (mBottomCount != 0 && position >= (mHeaderCount + dataItemCount)) {
            //底部VIew
            return ITEM_TYPE_BOTTOM;
        } else if (position % 3 == 1) {
            //多类型Item
            return ITEM_TYPE_CONTENT1;
        } else {
            //内容
            return ITEM_TYPE_CONTENT;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE_HEADER) {
            View view = mLayoutInflater.inflate(R.layout.recyc_addheadview, parent, false);
            return new HeaderViewHolder(view);
        } else if (viewType == ITEM_TYPE_CONTENT) {
            View view = mLayoutInflater.inflate(R.layout.item_recycleview, parent, false);
            return new ContentViewHolder(view);
        } else if (viewType == ITEM_TYPE_BOTTOM) {
            View view = mLayoutInflater.inflate(R.layout.recycle_addfooter, parent, false);
            return new BottomViewHolder(view);
        }else if (viewType == ITEM_TYPE_CONTENT1){
            View view = mLayoutInflater.inflate(R.layout.recycle_morekinds, parent, false);
            return new BottomViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) holder).tv_head.setText("我是头部");
            ((HeaderViewHolder) holder).tv_head.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "点击头部" + position, Toast.LENGTH_SHORT).show();

                }
            });
        } else if (holder instanceof ContentViewHolder) {
            ((ContentViewHolder) holder).textView.setText("哈哈哈");
        } else if (holder instanceof BottomViewHolder) {

        } else if (holder instanceof Content1ViewHolder) {

        }
    }

    //内容ViewHolder
    public static class ContentViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public ContentViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv1);
        }
    }

    //多类型内容ViewHolder
    public static class Content1ViewHolder extends RecyclerView.ViewHolder {
        public Content1ViewHolder(View itemView) {
            super(itemView);
        }
    }

    //头部ViewHolder
    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_head;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            tv_head = (TextView) itemView.findViewById(R.id.tv_head);
        }
    }

    //底部ViewHolder
    public static class BottomViewHolder extends RecyclerView.ViewHolder {

        public BottomViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public int getItemCount() {
        return mHeaderCount + getContentItemCount() + mBottomCount;
    }
}
