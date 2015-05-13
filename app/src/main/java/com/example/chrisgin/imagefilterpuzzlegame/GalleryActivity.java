package com.example.chrisgin.imagefilterpuzzlegame;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


/**
 * Created by yaya on 4/15/15.
 * Name of Class: GalleryActivity
 * Description: This class inherits from ActionBarActivity. This class displays two fragments the
 *              FragmentGalleryPictures and the FragmentFilters
 */


public class GalleryActivity extends ActionBarActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //linkes the class to its layout
        setContentView(R.layout.gallery);

      final FragmentManager fragmentManager = getSupportFragmentManager();//get an instance of the
       //activity fragment manager

        //finds a location to display the fragment in the gallery_layout
         Fragment galleryFragment = fragmentManager.findFragmentById(R.id.gallery_container);

        //if the fragment was not initialize
        if(galleryFragment == null) {
            //crate the fragment
            galleryFragment = new FragmentGalleryPicture();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.gallery_container, galleryFragment);
           //fragmentTransaction.addToBackStack();
            fragmentTransaction.commit();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
