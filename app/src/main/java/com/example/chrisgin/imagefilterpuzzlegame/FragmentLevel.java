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
 *  * Developers:Yarely Chino, Noemi Cuin, Christian Martinez
 *
 *
 *
 * Created by yaya on 4/20/15.
 * Name of Class: MainActivity
 * Description: This class inherits from a Fragment. This class displays the game
 */
public class FragmentLevel extends Fragment{

    private ImageView imageView;
    File[] listFile;

    public String images_path;
    public int chunkWidth;
    public int chunkHeight;

    int tempPlace;

    //default varibles at the begining of the game
    int imagedefault =  8;
    int imageswap;
    Bitmap[] bmp = new Bitmap[9];

    //array of randomized tiles for the puzzle
  	int[] mixedImages = new int[]{4,3,7,6,1,5,2,0,8};
    	//answer key for solved puzzled
   	int[] answerKey = new int[]{0,1,2,3,4,5,6,7,8};


	int checksArrayForWin = 0;

//Image button are created for the image that is slided
    	ImageButton icon0;
		ImageButton icon1;
		ImageButton	icon2;
		ImageButton	icon3;
		ImageButton	icon4;
		ImageButton	icon5;
		ImageButton	icon6;
		ImageButton	icon7;
		ImageButton	icon8;

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


		setGalleryImages();
		Bitmap myBitmap = BitmapFactory.decodeFile(images_path);

		ImageView myImage = (ImageView) view.findViewById(R.id.level_image);

		chunkWidth = myBitmap.getWidth();
		chunkHeight = myBitmap.getHeight();
		Bitmap bt = Bitmap.createScaledBitmap(myBitmap,180, 180, true);

		//cropped the images for the grid view of the puzzle
		bmp[0] = Bitmap.createBitmap(bt,0, 0, 60,60);
		bmp[1] = Bitmap.createBitmap(bt,60,0,60,60);
		bmp[2] = Bitmap.createBitmap(bt,120,0,60,60);
		bmp[3] = Bitmap.createBitmap(bt,0,60,60,60);
		bmp[4] = Bitmap.createBitmap(bt,60,60,60,60);
		bmp[5] = Bitmap.createBitmap(bt,120,60,60,60);
		bmp[6] = Bitmap.createBitmap(bt,0,120,60,60);
		bmp[7] = Bitmap.createBitmap(bt,60,120,60,60);
		bmp[8] = Bitmap.createBitmap(bt,120,120,60,60);

		myImage.setImageBitmap(myBitmap);
		setImageCrop();

		//Sets an OnClickListener for the icon0, when the image is selected the below code
		//will run and will call the slideImage method
		icon0 = (ImageButton) view.findViewById(R.id.slide_image0);//reference to the images in the layout
		icon0.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//Toast toast = Toast.makeText(getActivity().getApplicationContext(),"image1", Toast.LENGTH_LONG);
				//toast.show();
				slideImage(v);

			}
		});

		//Sets an OnClickListener for the icon0, when the image is selected the below code
		//will run and will call the slideImage method
		icon1 = (ImageButton) view.findViewById(R.id.slide_image1);
		icon1.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				//Toast toast = Toast.makeText(getActivity().getApplicationContext(),"image2", Toast.LENGTH_LONG);
				//toast.show();
				slideImage(v);

			}
		});

		//Sets an OnClickListener for the icon2, when the image is selected the below code
		//will run and will call the slideImage method
		icon2 = (ImageButton) view.findViewById(R.id.slide_image2);
		icon2.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){

				slideImage(v);
			}
		});


		//Sets an OnClickListener for the icon3, when the image is selected the below code
		//will run and will call the slideImage method
		icon3 = (ImageButton) view.findViewById(R.id.slide_image3);
		icon3.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){

				slideImage(v);

			}
		});

		//Sets an OnClickListener for the icon4, when the image is selected the below code
		//will run and will call the slideImage method

		icon4 = (ImageButton) view.findViewById(R.id.slide_image4);
		icon4.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){

				slideImage(v);
			}
		});

		//Sets an OnClickListener for the icon5, when the image is selected the below code
		//will run and will call the slideImage method
		icon5 = (ImageButton) view.findViewById(R.id.slide_image5);
		icon5.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){

				slideImage(v);
			}
		});

		//Sets an OnClickListener for the icon6, when the image is selected the below code
		//will run and will call the slideImage method
		icon6 = (ImageButton) view.findViewById(R.id.slide_image6);
		icon6.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){

				slideImage(v);
			}
		});

		//Sets an OnClickListener for the icon7, when the image is selected the below code
		//will run and will call the slideImage method
		icon7 = (ImageButton) view.findViewById(R.id.slide_image7);
		icon7.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){

				slideImage(v);

			}
		});

		//Sets an OnClickListener for the icon8, when the image is selected the below code
		//will run and will call the slideImage method
		icon8 = (ImageButton) view.findViewById(R.id.slide_image8);
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

		//reads the image path from the directory
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

			//looks for the tag that was set in the layout in the image view
			String tagname = imageButton.getTag().toString();

			//this indicates that the image was touched and the imagedefault is changed
			imageswap = Integer.parseInt(tagname);
		//Toast toast = Toast.makeText(getActivity().getApplicationContext(), String.valueOf(imageswap), Toast.LENGTH_LONG);
		//toast.show();


		//gets the imageDefault "white" image icon and depending on the location of the image the
		//switch will run
		switch (imagedefault) {
			case 0:
			{
				//if the white image is in section 0 this runs
				if (imageswap == (imagedefault + 1)) {

					//swaps the image view
					icon1.setImageResource(R.drawable.imagewhite);
					icon0.setImageBitmap(bmp[mixedImages[imagedefault + 1]]);
					tempPlace = mixedImages[imagedefault];


					//swapts the integers from the arrays
					mixedImages[imagedefault] = mixedImages[imageswap];
					mixedImages[imageswap] = tempPlace;
					imagedefault = imagedefault + 1;

				}

				else if (imageswap == (imagedefault + 3)) {

					//swaps the image view
					icon3.setImageResource(R.drawable.imagewhite);
					icon0.setImageBitmap(bmp[mixedImages[imagedefault + 3]]);
					tempPlace = mixedImages[imagedefault];

					//swapts the integers from the arrays
					mixedImages[imagedefault] = mixedImages[imageswap];
					mixedImages[imageswap] = tempPlace;
					imagedefault = imagedefault + 3;

				}
				checksIfUserWon();

				break;

			}

			//if the white image is in section 1 this runs
			case 1:
			{
				if (imageswap == (imagedefault - 1)) {

					//swaps the image view
					icon0.setImageResource(R.drawable.imagewhite);
					icon1.setImageBitmap(bmp[mixedImages[imagedefault - 1]]);
					tempPlace = mixedImages[imagedefault];

					//swapts the integers from the arrays
					mixedImages[imagedefault] = mixedImages[imageswap];
					mixedImages[imageswap] = tempPlace;
					imagedefault = imagedefault - 1;

				}

				else if (imageswap == (imagedefault + 1)) {

					//swaps the image view
					icon2.setImageResource(R.drawable.imagewhite);
					icon1.setImageBitmap(bmp[mixedImages[imagedefault + 1]]);
					tempPlace = mixedImages[imagedefault];

					//swapts the integers from the arrays
					mixedImages[imagedefault] = mixedImages[imageswap];
					mixedImages[imageswap] = tempPlace;
					imagedefault = imagedefault + 1;

				}

				else if (imageswap == (imagedefault + 3)) {

					//swaps the image view
					icon4.setImageResource(R.drawable.imagewhite);
					icon1.setImageBitmap(bmp[mixedImages[imagedefault + 3]]);
					tempPlace = mixedImages[imagedefault];

					//swapts the integers from the arrays
					mixedImages[imagedefault] = mixedImages[imageswap];
					mixedImages[imageswap] = tempPlace;
					imagedefault = imagedefault + 3;

				}
				checksIfUserWon();

				break;

			}


			//if the white image is in section 2 this runs
			case 2: {

				if (imageswap == (imagedefault - 1)) {        //swaps the image view
					icon1.setImageResource(R.drawable.imagewhite);
					icon2.setImageBitmap(bmp[mixedImages[imagedefault - 1]]);
					tempPlace = mixedImages[imagedefault];

					//swapts the integers from the arrays
					mixedImages[imagedefault] = mixedImages[imageswap];
					mixedImages[imageswap] = tempPlace;
					imagedefault = imagedefault - 1;

				} else if (imageswap == (imagedefault + 3)) {

					icon5.setImageResource(R.drawable.imagewhite);
					icon2.setImageBitmap(bmp[mixedImages[imagedefault + 3]]);
					tempPlace = mixedImages[imagedefault];

					//swapts the integers from the arrays
					mixedImages[imagedefault] = mixedImages[imageswap];
					mixedImages[imageswap] = tempPlace;
					imagedefault = imagedefault + 3;

				}
				checksIfUserWon();

				break;
			}

			//if the white image is in section 3 this runs
			case 3:
			{

					if (imageswap == (imagedefault + 1)) {

						//swaps the image view
						icon4.setImageResource(R.drawable.imagewhite);
						icon3.setImageBitmap(bmp[mixedImages[imagedefault + 1]]);
						tempPlace = mixedImages[imagedefault];

						//swapts the integers from the arrays
						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault + 1;

					}

					else if (imageswap == (imagedefault - 3)) {

						//swaps the image view
						icon0.setImageResource(R.drawable.imagewhite);
						icon3.setImageBitmap(bmp[mixedImages[imagedefault - 3]]);
						tempPlace = mixedImages[imagedefault];

						//swapts the integers from the arrays
						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault - 3;

					}
					else if (imageswap == (imagedefault + 3)) {

						//swaps the image view
						icon6.setImageResource(R.drawable.imagewhite);
						icon3.setImageBitmap(bmp[mixedImages[imagedefault + 3]]);
						tempPlace = mixedImages[imagedefault];

						//swapts the integers from the arrays
						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault + 3;

					}
					checksIfUserWon();



				break;
			}

			//if the white image is in section 4 this runs
			case 4:
			{
					if (imageswap == (imagedefault + 1)) {

						//swaps the image view
						icon5.setImageResource(R.drawable.imagewhite);
						icon4.setImageBitmap(bmp[mixedImages[imagedefault + 1]]);
						tempPlace = mixedImages[imagedefault];
						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault + 1;

					}

					else if (imageswap == (imagedefault - 3)) {

						//swaps the image view
						icon1.setImageResource(R.drawable.imagewhite);
						icon4.setImageBitmap(bmp[mixedImages[imagedefault - 3]]);
						tempPlace = mixedImages[imagedefault];

						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault - 3;

					}
					else if (imageswap == (imagedefault + 3)) {

						//swaps the image view
						icon7.setImageResource(R.drawable.imagewhite);
						icon4.setImageBitmap(bmp[mixedImages[imagedefault + 3]]);
						tempPlace = mixedImages[imagedefault];

						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault + 3;

					}
					else if (imageswap == (imagedefault - 1)) {

						//swaps the image view
						icon3.setImageResource(R.drawable.imagewhite);
						icon4.setImageBitmap(bmp[mixedImages[imagedefault - 1]]);
						tempPlace = mixedImages[imagedefault];
						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault - 1;

					}
					checksIfUserWon();


				break;


			}

			//if the white image is in section 5 this runs
			case 5: {

					if (imageswap == (imagedefault - 3)) {

						//swaps the image view
						icon2.setImageResource(R.drawable.imagewhite);
						icon5.setImageBitmap(bmp[mixedImages[imagedefault - 3]]);
						tempPlace = mixedImages[imagedefault];

						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault - 3;

					}
					else if (imageswap == (imagedefault + 3)) {

						//swaps the image view
						icon8.setImageResource(R.drawable.imagewhite);
						icon5.setImageBitmap(bmp[mixedImages[imagedefault + 3]]);
						tempPlace = mixedImages[imagedefault];

						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault + 3;

					}
					else if (imageswap == (imagedefault - 1)) {

						//swaps the image view
						icon4.setImageResource(R.drawable.imagewhite);
						icon5.setImageBitmap(bmp[mixedImages[imagedefault - 1]]);
						tempPlace = mixedImages[imagedefault];
						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault - 1;

					}
					checksIfUserWon();


				break;
			}

			//if the white image is in section 6 this runs
			case 6: {

					if (imageswap == (imagedefault - 3)) {

						//swaps the image view
						icon3.setImageResource(R.drawable.imagewhite);
						icon6.setImageBitmap(bmp[mixedImages[imagedefault - 3]]);
						tempPlace = mixedImages[imagedefault];

						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault - 3;

					} else if (imageswap == (imagedefault + 1)) {

						//swaps the image view
						icon7.setImageResource(R.drawable.imagewhite);
						icon6.setImageBitmap(bmp[mixedImages[imagedefault + 1]]);
						tempPlace = mixedImages[imagedefault];
						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault + 1;

					}

					checksIfUserWon();
				break;
			}

			//if the white image is in section 7 this runs
			case 7:
			{

					if(imageswap == (imagedefault-3)){

						//swaps the image view
						icon4.setImageResource(R.drawable.imagewhite);
						icon7.setImageBitmap(bmp[mixedImages[imagedefault-3]]);
						tempPlace = mixedImages[imagedefault];
						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault-3;

					}
					else if(imageswap == (imagedefault-1)){

						//swaps the image view
						icon6.setImageResource(R.drawable.imagewhite);
						icon7.setImageBitmap(bmp[mixedImages[imagedefault-1]]);
						tempPlace = mixedImages[imagedefault];
						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault-1;

					}

					else if(imageswap == (imagedefault+1)){

						//swaps the image view
						icon8.setImageResource(R.drawable.imagewhite);
						icon7.setImageBitmap(bmp[mixedImages[imagedefault+1]]);
						tempPlace = mixedImages[imagedefault];
						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault+1;

					}
					checksIfUserWon();



				break;
			}

			//if the white image is in section 8 this runs
			case 8:
			{

					if(imageswap == (imagedefault-3)){

						//swaps the image view
						icon5.setImageResource(R.drawable.imagewhite);
						icon8.setImageBitmap(bmp[mixedImages[imagedefault-3]]);
						tempPlace = mixedImages[imagedefault];

						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault-3;

					}
					else if(imageswap == (imagedefault-1)){

						//swaps the image view
						icon7.setImageResource(R.drawable.imagewhite);
						icon8.setImageBitmap(bmp[mixedImages[imagedefault-1]]);
						tempPlace = mixedImages[imagedefault];
						mixedImages[imagedefault] = mixedImages[imageswap];
						mixedImages[imageswap] = tempPlace;
						imagedefault = imagedefault-1;

					}
					checksIfUserWon();
				}

				break;
			default:
				break;

		}

				//checks if the same image was not selected



	}


    public void checksIfUserWon()
	{
		//checks if the user won
		for(int x = 0;x < 9;x++)
		{
			//increments the count victory if both numbers are the same
			if(mixedImages[x] == answerKey[x])
				checksArrayForWin++;
			else
				break;
		}

		if(checksArrayForWin == 9)
		{
			//if the array is the same the wonMesssage meethod is displayed
			wonMessage();
		}
		checksArrayForWin = 0;//resets back to zero if they didn't win

	}
    	//pops up the layout of the victory screen
	private void wonMessage()
	{
		Toast toast = Toast.makeText(getActivity().getApplicationContext(), "Yay!!! YOU WON", Toast.LENGTH_LONG);
		toast.show();
	}

}

