package com.example.chrisgin.imagefilterpuzzlegame;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by yaya on 4/19/15.
 */
public class FragmentGalleryPicture extends Fragment {


    private ImageButton mPictureButton;

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

        final FragmentManager fragmentManager = getChildFragmentManager();

        mPictureButton = (ImageButton) view.findViewById(R.id.imageButton1);
        mPictureButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Fragment filtersFra = new FragmentFilters();//it creates a new objectt of type FragmentFilters
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
               fragmentTransaction.add(R.id.filter_fragment_container, filtersFra );
                //fragmentTransaction.addToBackStack("gallery_fragment");
                fragmentTransaction.commit();
               // Toast toast = Toast.makeText(getActivity().getApplicationContext(), "picuture button", Toast.LENGTH_LONG);
              //  toast.show();

            }
        });
        return view;

    }
}