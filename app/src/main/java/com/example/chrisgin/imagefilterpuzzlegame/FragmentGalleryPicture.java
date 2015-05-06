package com.example.chrisgin.imagefilterpuzzlegame;

import android.app.Activity;
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


    private ImageButton mPictureButton1;
    private ImageButton mPictureButton2;
    private ImageButton mPictureButton3;
    private ImageButton mPictureButton4;
    private ImageButton mPictureButton5;
    private ImageButton mPictureButton6;


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


        mPictureButton1 = (ImageButton) view.findViewById(R.id.imageButton1);
        mPictureButton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                //I created a Bundle object so we are able to pass information to our next fragment.
                //So we can know what image to display

                Fragment filtersFra = FragmentFilters.getInstance("image1");
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

               fragmentTransaction.replace(R.id.filter_fragment_container, filtersFra );

                //fragmentTransaction.addToBackStack("gallery_fragment");
                fragmentTransaction.commit();
            }
        });

        mPictureButton2 = (ImageButton) view.findViewById(R.id.imageButton2);
        mPictureButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //I created a Bundle object so we are able to pass information to our next fragment.
                //So we can know what image to display

                Fragment filtersFra = FragmentFilters.getInstance("image2");
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.filter_fragment_container, filtersFra);
                //fragmentTransaction.addToBackStack("gallery_fragment");
                fragmentTransaction.commit();
                // Toast toast = Toast.makeText(getActivity().getApplicationContext(), "picuture button", Toast.LENGTH_LONG);
                //  toast.show();

            }
        });

        mPictureButton3 = (ImageButton) view.findViewById(R.id.imageButton3);
        mPictureButton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //I created a Bundle object so we are able to pass information to our next fragment.
                //So we can know what image to display
                Fragment filtersFra = FragmentFilters.getInstance("image3");
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


                fragmentTransaction.replace(R.id.filter_fragment_container, filtersFra);
                //fragmentTransaction.addToBackStack("gallery_fragment");
                fragmentTransaction.commit();
                // Toast toast = Toast.makeText(getActivity().getApplicationContext(), "picuture button", Toast.LENGTH_LONG);
                //  toast.show();

            }
        });

        mPictureButton4 = (ImageButton) view.findViewById(R.id.imageButton4);
        mPictureButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //I created a Bundle object so we are able to pass information to our next fragment.
                //So we can know what image to display

                Fragment filtersFra = FragmentFilters.getInstance("image4");
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.filter_fragment_container, filtersFra);
                //fragmentTransaction.addToBackStack("gallery_fragment");
                fragmentTransaction.commit();
                // Toast toast = Toast.makeText(getActivity().getApplicationContext(), "picuture button", Toast.LENGTH_LONG);
                //  toast.show();

            }
        });

        mPictureButton5 = (ImageButton) view.findViewById(R.id.imageButton5);
        mPictureButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //I created a Bundle object so we are able to pass information to our next fragment.
                //So we can know what image to display


                Fragment filtersFra = FragmentFilters.getInstance("image5");
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


                fragmentTransaction.replace(R.id.filter_fragment_container, filtersFra);
                //fragmentTransaction.addToBackStack("gallery_fragment");
                fragmentTransaction.commit();
                // Toast toast = Toast.makeText(getActivity().getApplicationContext(), "picuture button", Toast.LENGTH_LONG);
                //  toast.show();

            }
        });

        mPictureButton6 = (ImageButton) view.findViewById(R.id.imageButton6);
        mPictureButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //I created a Bundle object so we are able to pass information to our next fragment.
                //So we can know what image to display


                Fragment filtersFra = FragmentFilters.getInstance("image6");
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


                fragmentTransaction.replace(R.id.filter_fragment_container, filtersFra);
                //fragmentTransaction.addToBackStack("gallery_fragment");
                fragmentTransaction.commit();
                // Toast toast = Toast.makeText(getActivity().getApplicationContext(), "picuture button", Toast.LENGTH_LONG);
                //  toast.show();

            }
        });
        return view;

    }


}
