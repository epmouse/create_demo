package com.create.user_definedmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.create.user_definedmenu.utils.AnimationUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class YouKuMenu extends AppCompatActivity implements View.OnClickListener {
    @InjectView(R.id.max)
    RelativeLayout max;
    @InjectView(R.id.middle)
    RelativeLayout middle;
    @InjectView(R.id.min)
    RelativeLayout min;
    @InjectView(R.id.ib_home)
    ImageButton ib_home;
    @InjectView(R.id.ib_menu)
    ImageButton ib_menu;
    @InjectView(R.id.btn_menuState)
    Button btn_menuState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_ku_menu);

        ButterKnife.inject(this);
        ib_home.setOnClickListener(this);
        ib_menu.setOnClickListener(this);
        btn_menuState.setOnClickListener(this);

    }
    private boolean isOpen1=true;
    private boolean isOpen2=true;
    private boolean isOpen3=true;
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.ib_home:
                if(!isOpen2){
                AnimationUtils.startUpAnimation(middle);
                    isOpen2=true;
                }else{
                    if(isOpen3){
                        AnimationUtils.startDownAnimation(max,100);
                        isOpen3=false;
                    }
                    AnimationUtils.startDownAnimation(middle);
                    isOpen2=false;
                }
                break;
            case R.id.ib_menu:
                if(!isOpen3){
                    AnimationUtils.startUpAnimation(max);
                    isOpen3=true;
                }else{
                    AnimationUtils.startDownAnimation(max);
                    isOpen3=false;
                }

                break;
            case R.id.btn_menuState:

                if(AnimationUtils.runnintAnimCount>0){
                    //说明还有动画在执行中
                     return;
                }
                if(isOpen1){
                    if(isOpen2){
                        if(isOpen3){
                           AnimationUtils.startDownAnimation(min);
                            AnimationUtils.startDownAnimation(middle,100);
                            AnimationUtils.startDownAnimation(max,200);
                            isOpen1=isOpen2=isOpen3=false;
                        }else{
                            AnimationUtils.startDownAnimation(min);
                            AnimationUtils.startDownAnimation(middle,100);
                            isOpen1=isOpen2=false;
                        }
                    }else{
                        AnimationUtils.startDownAnimation(min);
                        isOpen1=false;
                    }
                }else{
                    AnimationUtils.startUpAnimation(min);
                    isOpen1=true;
                }

                break;
        }
    }
}
