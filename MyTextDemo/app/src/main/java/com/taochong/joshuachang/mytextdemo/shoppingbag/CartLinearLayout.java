package com.taochong.joshuachang.mytextdemo.shoppingbag;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.taochong.joshuachang.mytextdemo.R;

import java.util.List;


/**
 * Created by zhangwentao on 2015/12/24.
 * <p/>
 * 购物车子项
 */
public class CartLinearLayout extends LinearLayout {

    //true 编辑状态    false 非编辑状态
    private boolean mIsEdit;

    private List<String> mDatas;
    private MyShopBagAdapter mShoppingBagAdapter;

    private int mFlag;

    private Button mSubmitBtm;
    private TextView mSelectNum;

    public CartLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(VERTICAL);
    }

    public void setCartGroup(final List<String> mDatas, boolean isEdit
            , ListView listView, MyShopBagAdapter shoppingBagAdapter, final int flag) {
        mFlag = flag;
        mShoppingBagAdapter = shoppingBagAdapter;
        this.mDatas = mDatas;
        mIsEdit = isEdit;
        removeAllViews();
        final View childView = LayoutInflater.from(getContext()).inflate(R.layout.shopping_list_child_item, null);
        childView.findViewById(R.id.delete).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "删除某一项", Toast.LENGTH_SHORT).show();
                mDatas.remove(flag);
                mShoppingBagAdapter.notifyDataSetChanged();
            }
        });
        childView.findViewById(R.id.content).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "跳转商品详情", Toast.LENGTH_SHORT).show();
            }
        });

        new FrontViewToMove(childView.findViewById(R.id.content), listView,getContext());
        addView(childView);

        View bottomView = LayoutInflater.from(getContext()).inflate(R.layout.shopping_cart_bottom, null);
        mSubmitBtm = (Button) bottomView.findViewById(R.id.bt_submit);
        mSelectNum = (TextView) bottomView.findViewById(R.id.product_count);
        mSubmitBtm.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {//点击跳转商品详情
                Toast.makeText(getContext(), "点击跳转商品详情", Toast.LENGTH_SHORT).show();
            }
        });
        addView(bottomView);
    }


}
