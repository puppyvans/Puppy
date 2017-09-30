package com.example.wb_gxf323855.puppy.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wb_gxf323855.puppy.R;
import com.example.wb_gxf323855.puppy.start.Main;

import java.util.List;

/**
 * Created by puppy on 2017/9/30.
 */

public class AdapterMainViewPager extends FragmentPagerAdapter {

    private Context context;
    private List<Fragment> fragmentList;
    private String[] titles = {"Chats", "Contacts", "Discover", "Me"};
    private int[] icons = {R.drawable.tab_icon1, R.drawable.tab_icon2, R.drawable.tab_icon3, R.drawable.tab_icon4};



    public AdapterMainViewPager(FragmentManager fm, Context context, List<Fragment> fragmentList) {
        super(fm);
        this.context = context;
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public View getTabView(int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.tab_custom, null);
        TextView textView = (TextView) view.findViewById(R.id.tab_txt);
        ImageView imageView = (ImageView) view.findViewById(R.id.tab_icon);
        textView.setText(titles[position]);
        imageView.setImageResource(icons[position]);
        textView.setTextColor(Main.tabLayout_main.getTabTextColors());
        return view;

    }
}
