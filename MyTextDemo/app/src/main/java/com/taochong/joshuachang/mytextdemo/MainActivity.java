package com.taochong.joshuachang.mytextdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.taochong.joshuachang.mytextdemo.db.Bean;
import com.taochong.joshuachang.mytextdemo.db.DBManager;

import java.util.List;

public class MainActivity extends Activity {
    DBManager dbManger;
    private TextView tv;
    private EditText et;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        MyApplication.getInstance().addActivity(this);

        img= (ImageView) findViewById(R.id.img);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"hahha",Toast.LENGTH_SHORT).show();
            }
        });
        tv= (TextView) findViewById(R.id.tv);
//        et= (EditText) findViewById(et);
//        et.setText("sfsfsfsfs");
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"hahha",Toast.LENGTH_SHORT).show();
//                et.setText(et.getText()+"\b"+"小鸡鸡");
                tv.setClickable(false);
                tv.setBackgroundResource(R.color.colorAccent);
            }
        });

    }

    private void init() {
         dbManger=DBManager.getmInstance(this);
        for (long i=1;i<6;i++){
            Bean user=new Bean();
            user.setId(i);
            user.setAge((int) (i*2));
            user.setName("第"+i+"人的");
            dbManger.insertBean(user);
        }
        List<Bean> users=dbManger.queryBeanList();
        for (Bean user:users) {
            Log.i("123","全部数据"+user.getId() + "--" + user.getName() +"--"+user.getAge());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
