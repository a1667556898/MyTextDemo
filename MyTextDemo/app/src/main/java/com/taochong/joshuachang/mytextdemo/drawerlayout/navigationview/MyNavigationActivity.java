package com.taochong.joshuachang.mytextdemo.drawerlayout.navigationview;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.taochong.joshuachang.mytextdemo.R;

/**
 * 常守达  2017/1/5 15:46
 * joshuachang0823@gmail.com
 * name:DrawerLayout+navigationView的使用
 * overview:navigation 导航的意思
 * setp:
 * 0 引入design包
 * 1 布局文件中 引入Drawerlayout作为跟布局：Drawerlayout第二项 写成NavigationView
 * 2 android:layout_gravity=""添加这个属性 显示位置：left/right 显示左边 右边
 * 3 引入属性 menu：“”显示navigationview 的item项】
 * 4 引入属性 app;headerlayout 加载navigation的头部
 * 5 给每项添加监听 navigationView.setNavigationItemSelectedListener(OnNavigationItemSelectedListener)
 * 6 头部添加监听：View headerView=navigationview.getheadview(0)
 */

public class MyNavigationActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigationview);
        final DrawerLayout mDrawer = (DrawerLayout) findViewById(R.id.drawerlayout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);


        /**设置MenuItem的字体颜色**/
        Resources resource = (Resources) getBaseContext().getResources();
        ColorStateList csl = resource.getColorStateList(R.color.navigation_menu_item_color);
        navigationView.setItemTextColor(csl);
        /**设置MenuItem默认选中项**/
        navigationView.getMenu().getItem(0).setChecked(true);


        //点击navigationview的每一项
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                showItem(item);
                mDrawer.closeDrawers();//关闭抽屉
                return true;
            }
        });
        //头部的监听
        View headView = navigationView.getHeaderView(0);
        TextView tv = (TextView) headView.findViewById(R.id.tv_name);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyNavigationActivity.this, "点了铭少", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //展示NavigationView的每一项
    private void showItem(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(MyNavigationActivity.this, "点击了第一项", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sub_item1:
                Toast.makeText(MyNavigationActivity.this, "点击了下面第一项", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
