package com.example.viewpager6;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.viewpager6.banner.SimpleImageBanner;
import com.example.viewpager6.banner.SimpleImageBannerString;
import com.example.viewpager6.entity.BannerItem;
import com.example.viewpager6.utils.ViewFindUtils;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "lll";
    private View decorView;
    List<BannerItem> list = new ArrayList<>();
    List<String> listString = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        decorView = getWindow().getDecorView();
        updateList();

        sib_simple_usage();
    }

    private void updateList() {
        listString.add("http://192.168.0.103/images/1.jpg");
        listString.add("http://192.168.0.103/images/2.jpg");
        listString.add("http://192.168.0.103/images/3.jpg");

    }


    private void sib_simple_usage() {
        SimpleImageBannerString sib = ViewFindUtils.find(decorView, R.id.sib_simple_usage);

        sib.setSource(listString)
                .startScroll();
        sib.getViewPager().addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("lll", "onPageScrolled: " + position);
            }

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected: " + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d(TAG, "onPageScrollStateChanged: " + state);
            }
        });
        sib.setOnItemClickL(new SimpleImageBanner.OnItemClickL() {
            @Override
            public void onItemClick(int position) {

            }
        });
    }
}
