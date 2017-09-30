package com.example.wb_gxf323855.puppy.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wb_gxf323855.puppy.R;

/**
 * Created by puppy on 2017/9/30.
 */

public class Tab3Fragment extends Fragment {

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.tab3_fragment, container, false);
        return rootView;
    }
}
