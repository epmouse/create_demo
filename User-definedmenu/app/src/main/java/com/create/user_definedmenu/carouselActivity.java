package com.create.user_definedmenu;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class carouselActivity extends Activity {

    @InjectView(R.id.viewpager)
    ViewPager viewpager;
    @InjectView(R.id.tv_pagerText)
    TextView tvPagerText;
    @InjectView(R.id.ll_addPoint)
    LinearLayout llAddPoint;
    private ArrayList<ImageView> imageViews;
    private ArrayList<ImageView> mPoints;
    private int prePosition=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carousel);
        ButterKnife.inject(this);

        final int[] imageIds=new int[]{R.drawable.a,R.drawable.b,
                R.drawable.c,R.drawable.d,R.drawable.e};
        imageViews = new ArrayList<>();
        for(int i=0;i<imageIds.length;i++){
            ImageView image= new ImageView(this);
            image.setBackgroundResource(imageIds[i]);
            imageViews.add(image);
          ImageView pointView = new ImageView(this);
            pointView.setBackgroundResource(R.drawable.point_selector_bg);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            if(i!=0){
                layoutParams.leftMargin=10;
                pointView.setEnabled(false);
            }else{
                pointView.setEnabled(true);
            }
            pointView.setLayoutParams(layoutParams);
            llAddPoint.addView(pointView);
        }
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
        //由于图片资源都来源于服务端，所以不能使用switch，因为我们并不知道返回来的是几张图片
               int newPosition =position%imageViews.size();
                llAddPoint.getChildAt(newPosition).setEnabled(true);
                llAddPoint.getChildAt(prePosition).setEnabled(false);
                prePosition=newPosition;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

//初始状态
        int m = (Integer.MAX_VALUE / 2) % imageViews.size();
        int currentPosition = Integer.MAX_VALUE / 2 - m;
        viewpager.setCurrentItem(currentPosition);
        pagerAdapter=new MyPagerAdapter();
       viewpager.setAdapter(pagerAdapter);



        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true){
                    SystemClock.sleep(2000);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            viewpager.setCurrentItem(viewpager.getCurrentItem()+1);
                        }
                    });
                }
            }
        }).start();
    }
    private MyPagerAdapter pagerAdapter;
    class MyPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }
        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            ImageView iv = imageViews.get(position % imageViews.size());
            container.addView(iv);
            // 在这个方法里面设置图片的点击事件
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 处理跳转逻辑
                    Toast.makeText(carouselActivity.this,"被点了"+position%imageViews.size(),Toast.LENGTH_SHORT).show();

                }
            });
            return iv;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(imageViews.get(position%imageViews.size()));
        }
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }
}
