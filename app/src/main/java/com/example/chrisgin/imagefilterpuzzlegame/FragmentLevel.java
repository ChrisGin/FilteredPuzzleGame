package com.example.chrisgin.imagefilterpuzzlegame;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by yaya on 4/20/15.
 */
public class FragmentLevel extends Fragment{


    public FragmentLevel()
    {

        // Required empty public constructor
    }

    //linking the fragment with the layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //connects the medium fragment layout to the class
        View view =  inflater.inflate(R.layout.level_fragment, container, false);
        return view;

    }
}

