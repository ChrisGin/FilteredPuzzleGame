package com.example.chrisgin.imagefilterpuzzlegame;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yaya on 4/27/15.
 */
public class FragmentLevelMedium extends android.support.v4.app.Fragment {

    public FragmentLevelMedium()
    {

        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //connects the medium fragment layout to the class
        return inflater.inflate(R.layout.level_medium_fragment,container, false);

    }
}

