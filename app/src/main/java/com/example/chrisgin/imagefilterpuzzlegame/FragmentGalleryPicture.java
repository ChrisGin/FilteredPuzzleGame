package com.example.chrisgin.imagefilterpuzzlegame;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yaya on 4/19/15.
 */
public class FragmentGalleryPicture extends Fragment {


    public FragmentGalleryPicture()
    {

        // Required empty public constructor
    }
    //linking the fragment with the layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_gallery_layout, container, false);
        return view;
    }
}