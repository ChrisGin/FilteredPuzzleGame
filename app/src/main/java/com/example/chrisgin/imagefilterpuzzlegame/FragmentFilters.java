package com.example.chrisgin.imagefilterpuzzlegame;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yaya on 4/24/15.
 */
public class FragmentFilters extends Fragment {


    public FragmentFilters()
    {

        // Required empty public constructor
    }

    //linking the fragment with the layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_filters, container, false);
        return view;
    }
}
