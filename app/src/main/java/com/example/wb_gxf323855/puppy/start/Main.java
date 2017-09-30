package com.example.wb_gxf323855.puppy.start;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import com.example.wb_gxf323855.puppy.Adapter.AdapterMainViewPager;
import com.example.wb_gxf323855.puppy.R;
import com.example.wb_gxf323855.puppy.main.Tab1Fragment;
import com.example.wb_gxf323855.puppy.main.Tab2Fragment;
import com.example.wb_gxf323855.puppy.main.Tab3Fragment;
import com.example.wb_gxf323855.puppy.main.Tab4Fragment;

import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {


    private long firstTime = 0;

    public static TabLayout tabLayout_main;
    private ViewPager viewPager_main;
    private AdapterMainViewPager adapterMainViewPager;
    private List<Fragment> fragmentList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        tabLayout_main = (TabLayout) findViewById(R.id.tabLayout_main);
        viewPager_main = (ViewPager) findViewById(R.id.viewPager_main);

        fragmentList = new ArrayList<>();
        fragmentList.add(new Tab1Fragment());
        fragmentList.add(new Tab2Fragment());
        fragmentList.add(new Tab3Fragment());
        fragmentList.add(new Tab4Fragment());

        adapterMainViewPager = new AdapterMainViewPager(getSupportFragmentManager(), this, fragmentList);
        viewPager_main.setAdapter(adapterMainViewPager);
        //bind
        tabLayout_main.setupWithViewPager(viewPager_main);
        for (int i = 0; i < tabLayout_main.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout_main.getTabAt(i);
            tab.setCustomView(adapterMainViewPager.getTabView(i));
        }


    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            //currentTimeMillis是获取当前系统时间
            if (System.currentTimeMillis() - firstTime > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                firstTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
