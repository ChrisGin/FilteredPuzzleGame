package com.example.chrisgin.imagefilterpuzzlegame;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yaya on 4/27/15.
 */
public class FragmentLevelHard extends Fragment{

    public FragmentLevelHard (){

        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //connects the medium fragment layout to the class
        return inflater.inflate(R.layout.level_hard_fragment,container, false);

    }
}
