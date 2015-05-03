package com.example.chrisgin.imagefilterpuzzlegame;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by yaya on 4/24/15.
 */
public class FragmentFilters extends Fragment {

    ImageView imageView;

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

        //this gets the arguments we created using the Bundle onject
        String photos = getArguments().getString("photoNum");
        if(photos == "image1")
            imageView = (ImageView) getActivity().findViewById(R.id.imageView);
        Toast toast = Toast.makeText(getActivity().getApplicationContext(), photos, Toast.LENGTH_LONG);
        toast.show();

        return view;
    }


}
