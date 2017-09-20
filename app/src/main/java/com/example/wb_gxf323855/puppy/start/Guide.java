package com.example.wb_gxf323855.puppy.start;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.wb_gxf323855.puppy.Adapter.AdapterGuideViewPager;
import com.example.wb_gxf323855.puppy.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wb-gxf323855 on 2017/9/20.
 */

public class Guide extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private List<View> viewList;
    private int[] dotIds = {R.id.dot1, R.id.dot2, R.id.dot3};
    private ImageView imageViews[] = new ImageView[3];
    private ViewPager viewPager;
    private AdapterGuideViewPager adapterGuideViewPager;
    private Button btn_enter_to_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gudie);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initView();
    }

    @SuppressLint("InflateParams")
    private void initView() {
        final LayoutInflater inflater = LayoutInflater.from(this);

        viewList = new ArrayList<>();
        viewList.add(inflater.inflate(R.layout.guide_viewpager1, null));
        viewList.add(inflater.inflate(R.layout.guide_viewpager2, null));
        viewList.add(inflater.inflate(R.layout.guide_viewpager3, null));

        //bind id with imageView
        for (int i = 0; i < dotIds.length; i++) {
            imageViews[i] = (ImageView) findViewById(dotIds[i]);
        }

        adapterGuideViewPager = new AdapterGuideViewPager(this, viewList);
        viewPager = (ViewPager) findViewById(R.id.viewPager_guide);
        viewPager.setAdapter(adapterGuideViewPager);
        viewPager.addOnPageChangeListener(this);

        btn_enter_to_login = (Button) (viewList.get(2)).findViewById(R.id.btn_enter_to_login);
        btn_enter_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Guide.this, Login.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < dotIds.length; i++) {
            if (i != position) {
                imageViews[i].setImageResource(R.drawable.dot_unselected);
            } else {
                imageViews[i].setImageResource(R.drawable.dot_selected);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
