package com.example.chrisgin.imagefilterpuzzlegame;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by yaya on 4/24/15.
 */
public class FragmentFilters extends Fragment {

    private ImageView img;
    private ImageView imageView;
    private Bitmap bmp;
    private Button button1;
    private Bitmap operation;
    Drawable bitmapOrg;

    private Button mContrastButton;
    private Button mNegativeButton;
    private Button mLavaButton;
    private Button mSepiaButton;
    private Button mBlackWhiteButton;
    private Button mStartButton;

    public ImageView currentView;

    private final int[] mColors =
            {Color.BLUE, Color.GREEN, Color.RED, Color.LTGRAY, Color.MAGENTA, Color.CYAN,
                    Color.YELLOW, Color.WHITE};
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


        final FragmentManager fragmentManager = getChildFragmentManager();

        //this gets the arguments we created using the Bundle onject  imageView = (ImageView) getActivity().findViewById(R.id.imageView);
        String photos = getArguments().getString("photoNum");
        imageView = (ImageView) view.findViewById(R.id.filter_image);

        if(photos == "image1") {
            imageView.setImageResource(R.drawable.image1);
        }
        else if(photos == "image2")
        {
            imageView.setImageResource(R.drawable.image2);

        }
        else if(photos == "image3")
        {
            imageView.setImageResource(R.drawable.image3);

        }
        else if(photos == "image4")
        {
            imageView.setImageResource(R.drawable.image4);
        }

        else if(photos == "image5")
        {
            imageView.setImageResource(R.drawable.image5);

        }
        else if(photos == "image6")
        {
            imageView.setImageResource(R.drawable.image6);

        }

        img = (ImageView)view.findViewById(R.id.filter_image);
        BitmapDrawable  abmp = (BitmapDrawable)img.getDrawable();
        bmp = abmp.getBitmap();

        mContrastButton = (Button) view.findViewById(R.id.contrast_button);
        mContrastButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                currentView = contrast(v);

            }
        });

        mBlackWhiteButton = (Button) view.findViewById(R.id.blackwhite_button);
        mBlackWhiteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                currentView = blackwhite(v);

            }
        });

        mNegativeButton = (Button) view.findViewById(R.id.negative_button);
        mNegativeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                currentView = negative(v);

            }
        });

        mSepiaButton = (Button) view.findViewById(R.id.sepia_button);
        mSepiaButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                currentView = sepia(v);

            }
        });


        mLavaButton = (Button) view.findViewById(R.id.lava_button);
        mLavaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentView = lava(v);

            }
        });

        mStartButton = (Button) view.findViewById(R.id.start_button);
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment frag = FragmentLevel.getInstancelevel("image1");

                currentView.setDrawingCacheEnabled(true);
                final Bitmap myImage = currentView.getDrawingCache();

                OutputStream fOut = null;
                Uri outputFileUri;
                try {
                    File root = new File(Environment.getExternalStorageDirectory()
                            + File.separator + "folder_name" + File.separator);
                    root.mkdirs();

                    File sdImageMainDirectory = new File(root, "myPicName.jpg");
                    outputFileUri = Uri.fromFile(sdImageMainDirectory);
                    fOut = new FileOutputStream(sdImageMainDirectory);
                } catch (Exception e) {

                }

                try {
                    myImage.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                    fOut.flush();
                    fOut.close();
                } catch (Exception e) {
                }

                frag = new FragmentLevel();

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction().add(R.id.filter_fragment_container, frag);
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.commit();



            }
        });

        return view;
    }

    public ImageView contrast(View view){
        operation= Bitmap.createBitmap(bmp.getWidth(),
                bmp.getHeight(), bmp.getConfig());

        double contrast = Math.pow((100.0 + 70.0) / 100, 2);
        for(int i=0; i<bmp.getWidth(); i++){
            for(int j=0; j<bmp.getHeight(); j++){
                int p = bmp.getPixel(i, j);
                int r = Color.red(p);
                int g = Color.green(p);
                int b = Color.blue(p);

                r = (int)(((((r/ 255.0) - 0.5) * contrast) + 0.5) * 255.0);
                if(r < 0) { r = 0; }
                else if(r > 255) { r = 255; }

                g = (int)(((((g / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
                if(g < 0) { g = 0; }
                else if(g > 255) { g = 255; }

                b = (int)(((((b / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
                if(b < 0) { b = 0; }
                else if(b > 255) { b = 255; }

                operation.setPixel(i, j, Color.argb(Color.alpha(p), r, g, b));
            }
        }
        img.setImageBitmap(operation);
        return img;
    }

    public ImageView blackwhite(View view){
        operation= Bitmap.createBitmap(bmp.getWidth(),
                bmp.getHeight(), bmp.getConfig());

        double factor = (259 * (64 + 255 )) / (255 * (259 - 64));
        for(int i=0; i<bmp.getWidth(); i++){
            for(int j=0; j<bmp.getHeight(); j++){
                int p = bmp.getPixel(i, j);
                int r = Color.red(p);
                int g = Color.green(p);
                int b = Color.blue(p);
                double lumi = (r + b + g)/3;

                if (lumi < 25) {
                    r = 25;
                    g = 25;
                    b = 25;
                }
                else if(lumi < 50){
                    r = 50;
                    g = 50;
                    b = 50;
                }
                else if(lumi < 75){
                    r = 75;
                    g = 75;
                    b = 75;
                }
                else if(lumi < 100){
                    r = 100;
                    g = 100;
                    b = 100;
                }
                else if(lumi < 125){
                    r = 125;
                    g = 125;
                    b = 125;
                }
                else if(lumi < 150){
                    r = 150;
                    g = 150;
                    b = 150;
                }
                else if(lumi < 175){
                    r = 175;
                    g = 175;
                    b = 175;
                }
                else if(lumi < 200){
                    r = 200;
                    g = 200;
                    b = 200;
                }

                else if(lumi < 225){
                    r = 225;
                    g = 225;
                    b = 225;
                }
                else
                {
                    r = 248;
                    g = 248;
                    b = 248;
                }

                operation.setPixel(i, j, Color.argb(Color.alpha(p), r, g, b));
            }
        }
        img.setImageBitmap(operation);
        return img;
    }
    public ImageView negative(View view){
        operation= Bitmap.createBitmap(bmp.getWidth(),
                bmp.getHeight(), bmp.getConfig());

        double factor = (259 * (64 + 255 )) / (255 * (259 - 64));
        for(int i=0; i<bmp.getWidth(); i++){
            for(int j=0; j<bmp.getHeight(); j++){
                int p = bmp.getPixel(i, j);
                int r = Color.red(p);
                int g = Color.green(p);
                int b = Color.blue(p);

                r = 255 - r;
                g = 255 - g;
                b = 255 - b;

                operation.setPixel(i, j, Color.argb(Color.alpha(p), r, g, b));
            }
        }
        img.setImageBitmap(operation);
        return img;
    }
    public ImageView gray(View view){
        operation= Bitmap.createBitmap(bmp.getWidth(),
                bmp.getHeight(), bmp.getConfig());

        double red = 0.30;
        double green = 0.40;
        double blue = 0.15;

        for(int i=0; i<bmp.getWidth(); i++){
            for(int j=0; j<bmp.getHeight(); j++){
                int p = bmp.getPixel(i, j);
                int r = Color.red(p);
                int g = Color.green(p);
                int b = Color.blue(p);

                r = (int) red * r;
                g = (int) green * g;
                b = (int) blue * b;

                operation.setPixel(i, j, Color.argb(Color.alpha(p), r, g, b));
            }
        }
        img.setImageBitmap(operation);
        return img;
    }


    public ImageView sepia(View view){
        operation= Bitmap.createBitmap(bmp.getWidth(),
                bmp.getHeight(),bmp.getConfig());

        double tr;
        double tg;
        double tb;

        for(int i=0; i<bmp.getWidth(); i++){
            for(int j=0; j<bmp.getHeight(); j++){
                int p = bmp.getPixel(i, j);
                int r = Color.red(p);
                int g = Color.green(p);
                int b = Color.blue(p);
                int alpha = Color.alpha(p);
                tr = (.393 * r) + (.769 * g) + (.189*b);
                tg =  (.349 * r) + (.686 * g) + (.168 * b);
                tb =  (.272 * r) + (.534 *g) + (.131 * b);

                if (tr > 255)
                    r = 255;
                else
                    r = (int) tr;

                if (tg > 255)
                    g = 255;
                else
                    g = (int) tg;

                if (tb > 255)
                    b = 255;
                else
                    b = (int) tb;

                operation.setPixel(i, j, Color.argb(alpha, r, g, b));
            }
        }
        img.setImageBitmap(operation);
        return img;
    }


    public ImageView lava(View view){
        operation= Bitmap.createBitmap(bmp.getWidth(),
                bmp.getHeight(),bmp.getConfig());


        for(int i=0; i<bmp.getWidth(); i++){
            for(int j=0; j<bmp.getHeight(); j++){
                int p = bmp.getPixel(i, j);
                int r = Color.red(p);
                int g = Color.green(p);
                int b = Color.blue(p);
                int alpha = Color.alpha(p);

                r =  r - 50;
                g =  g - 50;
                b =  b - 50;
                alpha = alpha -50;
                operation.setPixel(i, j, Color.argb(Color.alpha(p), r, g, b));


            }
        }

        img.setImageBitmap(operation);
        return img;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getActivity().getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public static Bitmap doColorFilter(Bitmap src, double red, double green, double blue) {
        // image size
        int width = src.getWidth();
        int height = src.getHeight();
        // create output bitmap
        Bitmap bmOut = Bitmap.createBitmap(width, height, src.getConfig());

        // color information
        int A, R, G, B;
        int pixel;

        // scan through all pixels
        for(int x = 0; x < width; ++x) {
            for(int y = 0; y < height; ++y) {
                // get pixel color
                pixel = src.getPixel(x, y);
                // apply filtering on each channel R, G, B
                A = Color.alpha(pixel);
                R = (int)(Color.red(pixel) * red);
                G = (int)(Color.green(pixel) * green);
                B = (int)(Color.blue(pixel) * blue);
                // set new color pixel to output bitmap
                bmOut.setPixel(x, y, Color.argb(A, R, G, B));
            }
        }

        // return final image
        return bmOut;
    }

    //calls the method to send a string to this fragment
    public static FragmentFilters getInstance(String image) {

        FragmentFilters frag = new FragmentFilters();

        Bundle bundle = new Bundle();

        bundle.putString("photoNum", image);//we are putting a string(nameKey, string);

        frag.setArguments(bundle);

        return  frag;
    }




}
