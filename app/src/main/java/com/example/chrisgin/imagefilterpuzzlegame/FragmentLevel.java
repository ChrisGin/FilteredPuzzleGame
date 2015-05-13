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

    //default varibles at the begining of the game
    int imagedefault =  8;
    int imageswap = -1;
    Bitmap[] bmp = new Bitmap[9];

    Bitmap bitmap;

    //this is the array that will hold the pictures after cutting them into smaller images
    Bitmap[] bitmaps = new Bitmap[9];

    //array of randomized tiles for the puzzle
  	int[] mixedImages = new int[]{4,3,7,6,1,5,2,0,8};
    	//answer key for solved puzzled
   	int[] answerKey = new int[]{0,1,2,3,4,5,6,7,8};

    //Number of tries
    int numberOfTries = 15;
    	//checks if the user completed the puzzle if count
    	//victory gets to nine
    	int countVictory = 0;

//Image button are created for the image that is slided
    	ImageButton
					icon0,
					icon1,
					icon2,
					icon3,
					icon4,
					icon5,
					icon6,
					icon7,
					icon8;

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
		icon0 = (ImageButton) view.findViewById(R.id.slide_image0);//reference to the images in the layout
		icon1 = (ImageButton) view.findViewById(R.id.slide_image1);
		icon2 = (ImageButton) view.findViewById(R.id.slide_image2);
		icon3 = (ImageButton) view.findViewById(R.id.slide_image3);
		icon4 = (ImageButton) view.findViewById(R.id.slide_image4);
		icon5 = (ImageButton) view.findViewById(R.id.slide_image5);
		icon6 = (ImageButton) view.findViewById(R.id.slide_image6);
		icon7 = (ImageButton) view.findViewById(R.id.slide_image7);
		icon8 = (ImageButton) view.findViewById(R.id.slide_image8);

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

		icon0.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				//Toast toast = Toast.makeText(getActivity().getApplicationContext(),"image1", Toast.LENGTH_LONG);
				//toast.show();
				slideImage(v);

			}
		});

		icon1.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				//Toast toast = Toast.makeText(getActivity().getApplicationContext(),"image2", Toast.LENGTH_LONG);
				//toast.show();
				slideImage(v);

			}
		});
		icon2.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){

				slideImage(v);
			}
		});

		icon3.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){

				slideImage(v);

			}
		});

		icon4.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){

				slideImage(v);
			}
		});

		icon5.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){

				slideImage(v);
			}
		});

		icon6.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){

				slideImage(v);
			}
		});

		icon7.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){

				slideImage(v);

			}
		});

		icon8.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){

				slideImage(v);

			}
		});


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
		icon0.setImageBitmap(bmp[mixedImages[0]]);
		icon1.setImageBitmap(bmp[mixedImages[1]]);
		icon2.setImageBitmap(bmp[mixedImages[2]]);
		icon3.setImageBitmap(bmp[mixedImages[3]]);
		icon4.setImageBitmap(bmp[mixedImages[4]]);
		icon5.setImageBitmap(bmp[mixedImages[5]]);
		icon6.setImageBitmap(bmp[mixedImages[6]]);
		icon7.setImageBitmap(bmp[mixedImages[7]]);
	//	icon9.setImageBitmap(bmp[mixedImages[8]]);
    }

    //calls the method to send a string to this fragment
    public static FragmentLevel getInstancelevel(String image) {

        FragmentLevel frag = new FragmentLevel();

        Bundle bundle = new Bundle();
        bundle.putString("photoNum", image);//we are putting a string(nameKey, string);

        frag.setArguments(bundle);

        return  frag;
    }


    public void slideImage(View v) {


			//creates the temp button when framed touched
			ImageButton imageButton = (ImageButton) v;

			//finds the tag for the button from the xml
			String tagname = imageButton.getTag().toString();

			//this indicates that the image was touched and the imagedefault is changed
			imageswap = Integer.parseInt(tagname);

		switch (imagedefault) {
			case 0:
			{

				if (imageswap == (imagedefault + 1)) {

					icon1.setImageResource(R.drawable.imagegray);
					icon0.setImageBitmap(bmp[mixedImages[imagedefault + 1]]);
					tempPlace = mixedImages[imagedefault];
					mixedImages[imagedefault] = mixedImages[imageswap];
					mixedImages[imageswap] = tempPlace;
					imagedefault = imagedefault + 1;

				}

				else if (imageswap == (imagedefault + 3)) {

					icon3.setImageResource(R.drawable.imagegray);
					icon0.setImageBitmap(bmp[mixedImages[imagedefault + 3]]);
					tempPlace = mixedImages[imagedefault];

					mixedImages[imagedefault] = mixedImages[imageswap];
					mixedImages[imageswap] = tempPlace;
					imagedefault = imagedefault + 3;

				}

				break;

			}
			case 1:
			{
				if (imageswap == (imagedefault - 1)) {

					icon0.setImageResource(R.drawable.imagegray);
					icon1.setImageBitmap(bmp[mixedImages[imagedefault - 1]]);
					tempPlace = mixedImages[imagedefault];
					mixedImages[imagedefault] = mixedImages[imageswap];
					mixedImages[imageswap] = tempPlace;
					imagedefault = imagedefault - 1;

				}

				else if (imageswap == (imagedefault + 1)) {

					icon2.setImageResource(R.drawable.imagegray);
					icon1.setImageBitmap(bmp[mixedImages[imagedefault + 1]]);
					tempPlace = mixedImages[imagedefault];
					mixedImages[imagedefault] = mixedImages[imageswap];
					mixedImages[imageswap] = tempPlace;
					imagedefault = imagedefault + 1;

				}

				else if (imageswap == (imagedefault + 3)) {

					icon4.setImageResource(R.drawable.imagegray);
					icon1.setImageBitmap(bmp[mixedImages[imagedefault + 3]]);
					tempPlace = mixedImages[imagedefault];

					mixedImages[imagedefault] = mixedImages[imageswap];
					mixedImages[imageswap] = tempPlace;
					imagedefault = imagedefault + 3;

				}

				break;

			}


			case 2:
			{
					if (imageswap == (imagedefault - 1)) {

					icon1.setImageResource(R.drawable.imagegray);
					icon2.setImageBitmap(bmp[mixedImages[imagedefault - 1]]);
					tempPlace = mixedImages[imagedefault];
					mixedImages[imagedefault] = mixedImages[imageswap];
					mixedImages[imageswap] = tempPlace;
					imagedefault = imagedefault - 1;

					}

					else if (imageswap == (imagedefault + 3)) {

						icon5.setImageResource(R.drawable.imagegray);
						icon2.setImageBitmap(bmp[mixedImages[imagedefault + 3]]);
						tempPlace = mixedImages[imagedefault];

						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault + 3;

					}



				}
				break;

			case 3:
			{

				if (imageswap != imagedefault) {
					if (imageswap == (imagedefault + 1)) {

						icon4.setImageResource(R.drawable.imagegray);
						icon3.setImageBitmap(bmp[mixedImages[imagedefault + 1]]);
						tempPlace = mixedImages[imagedefault];
						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault + 1;

					}

					else if (imageswap == (imagedefault - 3)) {

						icon0.setImageResource(R.drawable.imagegray);
						icon3.setImageBitmap(bmp[mixedImages[imagedefault - 3]]);
						tempPlace = mixedImages[imagedefault];

						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault - 3;

					}
					else if (imageswap == (imagedefault + 3)) {

						icon6.setImageResource(R.drawable.imagegray);
						icon3.setImageBitmap(bmp[mixedImages[imagedefault + 3]]);
						tempPlace = mixedImages[imagedefault];

						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault + 3;

					}


				}
				break;
			}
			case 4:
			{
				if (imageswap != imagedefault) {
					if (imageswap == (imagedefault + 1)) {

						icon5.setImageResource(R.drawable.imagegray);
						icon4.setImageBitmap(bmp[mixedImages[imagedefault + 1]]);
						tempPlace = mixedImages[imagedefault];
						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault + 1;

					}

					else if (imageswap == (imagedefault - 3)) {

						icon1.setImageResource(R.drawable.imagegray);
						icon4.setImageBitmap(bmp[mixedImages[imagedefault - 3]]);
						tempPlace = mixedImages[imagedefault];

						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault - 3;

					}
					else if (imageswap == (imagedefault + 3)) {

						icon7.setImageResource(R.drawable.imagegray);
						icon4.setImageBitmap(bmp[mixedImages[imagedefault + 3]]);
						tempPlace = mixedImages[imagedefault];

						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault + 3;

					}
					else if (imageswap == (imagedefault - 1)) {

						icon3.setImageResource(R.drawable.imagegray);
						icon4.setImageBitmap(bmp[mixedImages[imagedefault - 1]]);
						tempPlace = mixedImages[imagedefault];
						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault - 1;

					}

				}
				break;


			}
			case 5: {
				if (imageswap != imagedefault) {

					if (imageswap == (imagedefault - 3)) {

						icon5.setImageResource(R.drawable.imagegray);
						icon2.setImageBitmap(bmp[mixedImages[imagedefault - 3]]);
						tempPlace = mixedImages[imagedefault];

						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault - 3;

					}
					else if (imageswap == (imagedefault + 3)) {

						icon8.setImageResource(R.drawable.imagegray);
						icon5.setImageBitmap(bmp[mixedImages[imagedefault + 3]]);
						tempPlace = mixedImages[imagedefault];

						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault + 3;

					}
					else if (imageswap == (imagedefault - 1)) {

						icon4.setImageResource(R.drawable.imagegray);
						icon5.setImageBitmap(bmp[mixedImages[imagedefault - 1]]);
						tempPlace = mixedImages[imagedefault];
						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault - 1;

					}

				}
				break;
			}

			case 6: {
				if (imageswap != imagedefault) {

					if (imageswap == (imagedefault - 3)) {

						icon3.setImageResource(R.drawable.imagegray);
						icon6.setImageBitmap(bmp[mixedImages[imagedefault - 3]]);
						tempPlace = mixedImages[imagedefault];

						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault - 3;

					} else if (imageswap == (imagedefault + 1)) {

						icon7.setImageResource(R.drawable.imagegray);
						icon6.setImageBitmap(bmp[mixedImages[imagedefault + 1]]);
						tempPlace = mixedImages[imagedefault];
						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault + 1;

					}



				}
				break;
			}

			case 7:
			{
				if(imageswap != imagedefault){

					if(imageswap == (imagedefault-3)){

						icon4.setImageResource(R.drawable.imagegray);
						icon7.setImageBitmap(bmp[mixedImages[imagedefault-3]]);
						tempPlace = mixedImages[imagedefault];
						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault-3;



					}
					else if(imageswap == (imagedefault-1)){

						Toast toast = Toast.makeText(getActivity().getApplicationContext(), String.valueOf(imageswap), Toast.LENGTH_LONG);
						toast.show();
						icon6.setImageResource(R.drawable.imagegray);
						icon7.setImageBitmap(bmp[mixedImages[imagedefault-1]]);
						tempPlace = mixedImages[imagedefault];
						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault-1;

					}

					else if(imageswap == (imagedefault+1)){

						Toast toast = Toast.makeText(getActivity().getApplicationContext(), String.valueOf(imageswap), Toast.LENGTH_LONG);
						toast.show();
						icon7.setImageResource(R.drawable.imagegray);
						icon8.setImageBitmap(bmp[mixedImages[imagedefault+1]]);
						tempPlace = mixedImages[imagedefault];
						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault+1;

					}


				}

				break;
			}
			case 8:
			{
				if(imageswap != imagedefault){

					if(imageswap == (imagedefault-3)){

						icon5.setImageResource(R.drawable.imagegray);
						icon8.setImageBitmap(bmp[mixedImages[imagedefault-3]]);
						tempPlace = mixedImages[imagedefault];

						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault-3;

					}
					else if(imageswap == (imagedefault-1)){

						icon7.setImageResource(R.drawable.imagegray);
						icon8.setImageBitmap(bmp[mixedImages[imagedefault-1]]);
						tempPlace = mixedImages[imagedefault];
						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault-1;

					}

				}

				break;
			}
			default:
				break;

		}

				//checks if the same image was not selected



	}


    public void checksIfWon()
	{
		//checks if the user won
		for(int x = 0;x < 9;x++)
		{
			//increments the count victory if both numbers are the same
			if(mixedImages[x] == answerKey[x])
				countVictory++;
			else
				break;
		}
		//if count victory is nine then user wins
		if(countVictory == 9)
			victoryActivity();
			//if no more tries left then the user lost
		else if(numberOfTries == 0)
			losingActivity();
	}
    	//pops up the layout of the victory screen
	private void victoryActivity()
	{
	}
	//pops up the layout of the losing screen
	private void losingActivity()
	{
	}

}

