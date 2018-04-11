package com.taochong.joshuachang.mytextdemo.appbarlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.taochong.joshuachang.mytextdemo.R;

import java.util.ArrayList;

/**
 * Created by chenzhihong on 2017/9/2.
 */

public class MyAppBarlayoutFragment extends Fragment {
    private ListView my_list;
    private MyAdapter madapter;
    private ArrayList<String> mDatas = new ArrayList<>();

    public static MyAppBarlayoutFragment newInstance() {

        Bundle args = new Bundle();

        MyAppBarlayoutFragment fragment = new MyAppBarlayoutFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_appbarlayout, container, false);
        my_list = (ListView) view.findViewById(R.id.my_list);
        for (int i = 0; i < 10; i++) {
            mDatas.add(i + "哈哈");
        }
        madapter = new MyAdapter(mDatas, getActivity());
        my_list.setAdapter(madapter);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}
