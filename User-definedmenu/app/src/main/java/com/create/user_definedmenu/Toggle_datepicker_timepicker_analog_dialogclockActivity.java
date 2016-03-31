package com.create.user_definedmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import java.util.Calendar;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 实现了 Togglebutton  AnalogClock  DialogClock  DataPicker TimePicker
 */
public class Toggle_datepicker_timepicker_analog_dialogclockActivity extends AppCompatActivity {
    @InjectView(R.id.tv)
    TextView tv;
    @InjectView(R.id.toggle)
    ToggleButton toggle;
    @InjectView(R.id.et_date)
    EditText et_date;
    @InjectView(R.id.et_time)
    EditText et_time;
    @InjectView(R.id.date)
    DatePicker datePicker;
    @InjectView(R.id.time)
    TimePicker timePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_time_toggle_layout);
        ButterKnife.inject(this);
        initListener();//几个控件的状态监听


    }

    private void initListener() {
        /**
         * togglebutton状态改变的监听
         */
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tv.setText(isChecked ? "开了" : "关了");
            }
        });
        toggle.setChecked(true);//开关默认打开


        //初始化时显示当前日期
        Calendar calendar=Calendar.getInstance();
        int year= calendar.get(Calendar.YEAR);
         int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
               et_date.setText(year+"年"+monthOfYear+"月"+dayOfMonth+"天");
            }//月份显示出来少一个月，不明原因。
        });
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                et_time.setText(hourOfDay+"时"+minute+"分");
            }
        });

    }
}
