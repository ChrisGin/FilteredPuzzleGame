package com.example.chrisgin.imagefilterpuzzlegame;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.PixelFormat;
import android.media.Image;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by yaya on 4/20/15.
 */
public class FragmentLevel extends Fragment{

    private ImageView imageView;
    File[] listFile;

    public String images_path;
    public int rows = 3;

    public int cols = 3;
    public int chunks = rows * cols;
    public int chunkWidth;
    public int chunkHeight;
    public int count;

    //text view for the number of moves left
    TextView numberMoves;

    //temporary button for swapping images
    int tempPlace;

    //temporary variables for default
    //int place_1 = -1;
    //int place_2 = -1;
    Bitmap[] bmp = new Bitmap[9];

    Bitmap bitmap;

    //this is the array that will hold the pictures after cutting them into smaller images
    Bitmap[] bitmaps = new Bitmap[9];

    //array of randomized tiles for the puzzle
  	int[] mixedImages = new int[]{8,3,7,6,1,5,2,0,4};
    	//answer key for solved puzzled
   	int[] answerKey = new int[]{0,1,2,3,4,5,6,7,8};

    //Number of tries
    int numberOfTries = 15;
    	//checks if the user completed the puzzle if count
    	//victory gets to nine
    	int countVictory = 0;

//Image button are created for the image that is slided
    	ImageButton icon1,
					icon2,
					icon3,
					icon4,
					icon5,
					icon6,
					icon7,
					icon8,
					icon9;

        public FragmentLevel()
    {

        // Required empty public constructor
    }

    //linking the fragment with the layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //connects the medium fragment layout to the class
        View view =  inflater.inflate(R.layout.level_fragment, container, false);
        //finds the r file location of the imageButtons
		icon1 = (ImageButton) view.findViewById(R.id.slide_image1);//reference to the images in the layout
		icon2 = (ImageButton) view.findViewById(R.id.slide_image2);
		icon3 = (ImageButton) view.findViewById(R.id.slide_image3);
		icon4 = (ImageButton) view.findViewById(R.id.slide_image4);
		icon5 = (ImageButton) view.findViewById(R.id.slide_image5);
		icon6 = (ImageButton) view.findViewById(R.id.slide_image6);
		icon7 = (ImageButton) view.findViewById(R.id.slide_image7);
		icon8 = (ImageButton) view.findViewById(R.id.slide_image8);
		icon9 = (ImageButton) view.findViewById(R.id.slide_image9);



		icon1.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				Toast toast = Toast.makeText(getActivity().getApplicationContext(),"image1", Toast.LENGTH_LONG);
				toast.show();


			}
		});

		icon2.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){


			}
		});
		icon3.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){


			}
		});

		icon4.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){


			}
		});

		icon5.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){


			}
		});

		icon6.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){


			}
		});

		icon7.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){


			}
		});

		icon8.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){


			}
		});

		icon9.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){


			}
		});

        setGalleryImages();
        Bitmap myBitmap = BitmapFactory.decodeFile(images_path);

        ImageView myImage = (ImageView) view.findViewById(R.id.level_image);

        chunkWidth = myBitmap.getWidth();
        chunkHeight = myBitmap.getHeight();


        //cropped the images for the grid view of the puzzle
        bmp[0] = Bitmap.createBitmap(Bitmap.createScaledBitmap(myBitmap,180, 180, true),0,0,60,60);
        bmp[1] = Bitmap.createBitmap(Bitmap.createScaledBitmap(myBitmap,180, 180, true),60,0,60,60);
        bmp[2] = Bitmap.createBitmap(Bitmap.createScaledBitmap(myBitmap,180, 180, true),120,0,60,60);
        bmp[3] = Bitmap.createBitmap(Bitmap.createScaledBitmap(myBitmap,180, 180, true),0,60,60,60);
        bmp[4] = Bitmap.createBitmap(Bitmap.createScaledBitmap(myBitmap,180, 180, true),60,60,60,60);
        bmp[5] = Bitmap.createBitmap(Bitmap.createScaledBitmap(myBitmap,180, 180, true),120,60,60,60);
        bmp[6] = Bitmap.createBitmap(Bitmap.createScaledBitmap(myBitmap,180, 180, true),0,120,60,60);
        bmp[7] = Bitmap.createBitmap(Bitmap.createScaledBitmap(myBitmap,180, 180, true),60,120,60,60);
        bmp[8] = Bitmap.createBitmap(Bitmap.createScaledBitmap(myBitmap,180, 180, true),120,120,60,60);

        myImage.setImageBitmap(myBitmap);
        setImageCrop();


        return view;


    }

    public void setGalleryImages(){

        //gets the image file from the directory
        File file = new File(android.os.Environment.getExternalStorageDirectory(),"image");

        if(file.isDirectory()){
            listFile = file.listFiles();

            images_path = (listFile[0].getAbsolutePath());

        }
    }

    public void setImageCrop(){

    //sets the images cropped in a form of a three by three
		icon1.setImageBitmap(bmp[mixedImages[0]]);
		icon2.setImageBitmap(bmp[mixedImages[1]]);
		icon3.setImageBitmap(bmp[mixedImages[2]]);
		icon4.setImageBitmap(bmp[mixedImages[3]]);
		icon5.setImageBitmap(bmp[mixedImages[4]]);
		icon6.setImageBitmap(bmp[mixedImages[5]]);
		icon7.setImageBitmap(bmp[mixedImages[6]]);
		icon8.setImageBitmap(bmp[mixedImages[7]]);
		icon9.setImageBitmap(bmp[mixedImages[8]]);
    }

    //calls the method to send a string to this fragment
    public static FragmentLevel getInstancelevel(String image) {

        FragmentLevel frag = new FragmentLevel();

        Bundle bundle = new Bundle();
        bundle.putString("photoNum", image);//we are putting a string(nameKey, string);

        frag.setArguments(bundle);

        return  frag;
    }

}

