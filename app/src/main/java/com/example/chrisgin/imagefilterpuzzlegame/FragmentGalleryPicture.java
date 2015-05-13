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
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by yaya on 4/19/15.
 * Name of Class: GalleryActivity
 * Description: This class inherits from Fragment. This class displays constructs the gallery
 *
 */

public class FragmentGalleryPicture extends Fragment {


    //declars the ImageButtons from the layout file
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

        //Sets an OnClickListener for the ImageButton1, when the image is selected the above code
        //will run
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

        //Sets an OnClickListener for the ImageButton2, when the image is selected the above code
        //will run
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


        //Sets an OnClickListener for the ImageButton3, when the image is selected the above code
        //will run
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

        //Sets an OnClickListener for the ImageButton4, when the image is selected the above code
        //will run
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

        //Sets an OnClickListener for the ImageButton5, when the image is selected the above code
        //will run
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

        //Sets an OnClickListener for the ImageButton6, when the image is selected the above code
        //will run
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
