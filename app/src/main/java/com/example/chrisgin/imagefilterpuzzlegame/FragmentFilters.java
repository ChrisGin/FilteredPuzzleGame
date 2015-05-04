package com.example.chrisgin.imagefilterpuzzlegame;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

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

        //this gets the arguments we created using the Bundle onject  imageView = (ImageView) getActivity().findViewById(R.id.imageView);
        String photos = getArguments().getString("photoNum");
        Toast toast = Toast.makeText(getActivity().getApplicationContext(), photos, Toast.LENGTH_LONG);
        toast.show();

       // Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.image1);
     //   Bitmap newbitmap = doColorFilter(bmp,135, 125, 165);

      /*  imageView = (ImageView)getActivity().findViewById(R.id.imageView1);
        bitmapOrg = this.getResources().getDrawable(R.drawable.image1);

        button1 = (Button)getActivity().findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                int mColor = (int) Math.floor(Math.random() * mColors.length);
                bitmapOrg.setColorFilter(mColors[mColor], PorterDuff.Mode.MULTIPLY);
                imageView.setImageDrawable(bitmapOrg);
                imageView.invalidate();
            }
        });/*



       // img.setImageResource(R.drawable.imge1);
        //BitmapDrawable  abmp = (BitmapDrawable) img.getDrawable();
      //  bmp = abmp.getBitmap();



        // ImageView imgView = (ImageView)getActivity().findViewById(R.id.imageViewfilter);
       // imgView.setImageResource( R.drawable.image2 );

       // imgView.setImageResource( R.drawable.image2 );
     /*   if(photos == "image1")
        {
            imageView.setImageResource(R.drawable.image1);
            Toast toast = Toast.makeText(getActivity().getApplicationContext(), photos, Toast.LENGTH_LONG);
            toast.show();
        }
        else if(photos == "image2")
        {
            imageView.setImageResource(R.drawable.image2);
            Toast toast = Toast.makeText(getActivity().getApplicationContext(), photos, Toast.LENGTH_LONG);
            toast.show();
        }*/



        return view;
    }

    public void gray(View view){
        operation= Bitmap.createBitmap(bmp.getWidth(),
                bmp.getHeight(), bmp.getConfig());

        double red = 0.33;
        double green = 0.59;
        double blue = 0.11;

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
    }

    public void bright(View view){
        operation= Bitmap.createBitmap(bmp.getWidth(),
                bmp.getHeight(),bmp.getConfig());


        for(int i=0; i<bmp.getWidth(); i++){
            for(int j=0; j<bmp.getHeight(); j++){
                int p = bmp.getPixel(i, j);
                int r = Color.red(p);
                int g = Color.green(p);
                int b = Color.blue(p);
                int alpha = Color.alpha(p);

                r = 100  +  r;
                g = 100  + g;
                b = 100  + b;
                alpha = 100 + alpha;

                operation.setPixel(i, j, Color.argb(alpha, r, g, b));
            }
        }
        img.setImageBitmap(operation);
    }

    public void dark(View view){
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



}
