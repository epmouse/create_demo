package com.create.user_definedmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 自定义控件相关例子
 */
public class MainActivity extends Activity {
    @InjectView(R.id.btn_1)
    Button btn1;
    @InjectView(R.id.btn_2)
    Button btn2;
    @InjectView(R.id.btn_3)
    Button btn3;
    @InjectView(R.id.btn_4)
    Button btn4;
    @InjectView(R.id.btn_5)
    Button btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }
    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5})
    public void onClick(View view) {
        Intent intent=null;
        switch (view.getId()) {
            case R.id.btn_1:
                intent=new Intent(this,Toggle_datepicker_timepicker_analog_dialogclockActivity.class);
                break;
            case R.id.btn_2:
                intent=new Intent(this,YouKuMenu.class);
                break;
            case R.id.btn_3:
                intent=new Intent(this,carouselActivity.class);
                break;
            case R.id.btn_4:
                break;
            case R.id.btn_5:
                break;
        }
        startActivity(intent);
    }
}
