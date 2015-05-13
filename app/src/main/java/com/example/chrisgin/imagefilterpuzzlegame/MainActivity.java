package com.example.chrisgin.imagefilterpuzzlegame;


//imports all the library we need
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;


/**
 * Created by yaya on 4/24/15.
 * Name of Class: MainActivity
 * Description: This class inherits from ActionBarActivity. This class displays two buttons one
 *              for the camera and one for the gallery.
 */

public class MainActivity extends ActionBarActivity  {

    private ImageButton mGalleryButton;//creates a variable for the gallery button
    private ImageButton mCameraButton;// creates a variable for the camera button

    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;//variable that is sent to the camera activity
    View view;// creates a view for the images

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //linkes the class with its layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mCameraButton = (ImageButton) findViewById(R.id.cameraButton);//type casts the button as an image button and connects it to the camera button in the xml
        mCameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//waits for the button to be clicked
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//if clicked creates a new intent for image capturing
                startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);//launches the camera
            }
        });

        mGalleryButton = (ImageButton) findViewById(R.id.galleryButton);//typecasts the button as an image button and connects it to the gallery button in the xml
        mGalleryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {//waits for that button to be clicked.
                Intent intent = new Intent(MainActivity.this, GalleryActivity.class);//creates an intent that takes you from MainActivity to the Gallery Activity.
                startActivity(intent);//launches that intent.
            }
        });
    }
    public void onActivityResult(int requestCode, int resultCode) {
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                ImageView imageView = (ImageView) view.findViewById(R.id.camera_image);
                imageView.setImageURI(null);
            } else if (resultCode == RESULT_CANCELED) {
                // User cancelled the image capture
            } else {
                // Image capture failed, advise user
            }
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
    public void changeMethod(View v){
        //if the gallery button is selected the GalleryActivity class is displayed
        startActivity(new Intent(MainActivity.this, GalleryActivity.class));

        }


}
