package com.create.user_definedmenu.utils;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

/**
 * Created by Administrator on 2016/3/31 0031.
 */
public class AnimationUtils {
    public static int runnintAnimCount=0;
   public static class MyAnimationListener implements Animation.AnimationListener {

        @Override
        public void onAnimationStart(Animation animation) {
            runnintAnimCount++;
        }
        @Override
        public void onAnimationEnd(Animation animation) {
            runnintAnimCount--;
        }
        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
    /**
     * 打开的动画
     * @param viewGroup
     */
    public static void startUpAnimation(ViewGroup viewGroup){
        //进来时设置所有的空件都可点
        for(int i=0;i<viewGroup.getChildCount();i++){
              viewGroup.getChildAt(i).setEnabled(true);
        }

        RotateAnimation rotateAnimation=new RotateAnimation(180,360,
                Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,1f);
        rotateAnimation.setDuration(500);
        rotateAnimation.setFillAfter(true);
        viewGroup.startAnimation(rotateAnimation);
        rotateAnimation.setAnimationListener(new MyAnimationListener());
    }

    /**
     * 重载一个演示的打开动画
     * @param viewGroup
     */
    public static void startUpAnimation(ViewGroup viewGroup,long delayTime){
        //进来时设置所有的空件都可点
        for(int i=0;i<viewGroup.getChildCount();i++){
              viewGroup.getChildAt(i).setEnabled(true);
        }

        RotateAnimation rotateAnimation=new RotateAnimation(180,360,
                Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,1f);
        rotateAnimation.setDuration(500);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setStartOffset(delayTime);
        viewGroup.startAnimation(rotateAnimation);
        rotateAnimation.setAnimationListener(new MyAnimationListener());
    }

    /**
     * 关闭的动画
     * @param viewGroup
     */
    public static void startDownAnimation(ViewGroup viewGroup){
        //进来时设置所有的空件都可点
        for(int i=0;i<viewGroup.getChildCount();i++){
              viewGroup.getChildAt(i).setEnabled(false);
        }

        RotateAnimation rotateAnimation=new RotateAnimation(0,180,
                Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,1f);
        rotateAnimation.setDuration(500);
        rotateAnimation.setFillAfter(true);
        viewGroup.startAnimation(rotateAnimation);
        rotateAnimation.setAnimationListener(new MyAnimationListener());
    }

    /**
     * 重载延时执行的关闭动画
     * @param viewGroup
     * @param delayTime
     */
    public static void startDownAnimation(ViewGroup viewGroup,long delayTime){
        //进来时设置所有的空件都可点
        for(int i=0;i<viewGroup.getChildCount();i++){
              viewGroup.getChildAt(i).setEnabled(false);
        }

        RotateAnimation rotateAnimation=new RotateAnimation(0,180,
                Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,1f);
        rotateAnimation.setDuration(500);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setStartOffset(delayTime);//设置掩饰开启
        viewGroup.startAnimation(rotateAnimation);
        rotateAnimation.setAnimationListener(new MyAnimationListener());
    }
}
