package com.example.chrisgin.imagefilterpuzzlegame;

import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.graphics.PixelFormat;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;


/**
 * Created by yaya on 4/20/15.
 */
public class FragmentLevel extends Fragment{

    private ImageView imageView;

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
        imageView = (ImageView) view.findViewById(R.id.level_image);
        imageView.setImageResource(R.drawable.image4);

        return view;

    }

/*
    public class CropImageManipulator
    {
        public CropImageManipulator()
        {
        }

        private String _fileNameWithoutExtension;
        private String _fileExtension;
        private String _fileDirectory;

        public void Cropping(String inputImgPath, int cropWidth, int cropHeight)
        {
            this._fileNameWithoutExtension = System.IO.Path.GetFileNameWithoutExtension(inputImgPath);
            this._fileExtension = System.IO.Path.GetExtension(inputImgPath);
            this._fileDirectory = System.IO.Path.GetDirectoryName(inputImgPath);

            //Load the image divided
            Image inputImg = Image.FromFile(inputImgPath);
            int imgWidth = inputImg.Width;
            int imgHeight = inputImg.Height;

            //Divide how many small blocks
            int widthCount = (int)Math.Ceiling((imgWidth * 1.00) / (cropWidth * 1.00));
            int heightCount = (int)Math.Ceiling((imgHeight * 1.00) / (cropHeight * 1.00));
            ArrayList areaList = new ArrayList();

            int i = 0;
            for (int iHeight = 0; iHeight < heightCount ; iHeight ++)
            {
                for (int iWidth = 0; iWidth < widthCount ; iWidth ++)
                {
                    int pointX = iWidth * cropWidth;
                    int pointY = iHeight * cropHeight;
                    int areaWidth = ((pointX + cropWidth) > imgWidth) ? (imgWidth - pointX) : cropWidth;
                    int areaHeight = ((pointY + cropHeight) > imgHeight) ? (imgHeight - pointY) : cropHeight;
                    String s = String.Format("{0};{1};{2};{3}",pointX,pointY,areaWidth,areaHeight);

                    Rectangle rect = new Rectangle(pointX,pointY,areaWidth,areaHeight);
                    areaList.Add(rect);
                    i ++;
                }
            }

            for (int iLoop = 0 ; iLoop < areaList.Count ; iLoop ++)
            {
                Rectangle rect = (Rectangle)areaList[iLoop];
                string fileName = this._fileDirectory + "\\" + this._fileNameWithoutExtension + "_" + iLoop.ToString() + this._fileExtension;
                Bitmap newBmp = new Bitmap(rect.Width,rect.Height, PixelFormat.Format24bppRgb);
                Graphics newBmpGraphics = Graphics.FromImage(newBmp);
                newBmpGraphics.DrawImage(inputImg,new Rectangle(0,0,rect.Width,rect.Height),rect,GraphicsUnit.Pixel);
                newBmpGraphics.Save();
                switch (this._fileExtension.toLowerCase())
                {
                    case ".jpg":
                    case ".jpeg":
                        newBmp.Save(fileName, ImageFormat.Jpeg);
                        break;
                    case "gif":
                        newBmp.Save(fileName,ImageFormat.Gif);
                        break;
                }
            }
            inputImg.Dispose();
        }
    }*/
    //calls the method to send a string to this fragment
    public static FragmentLevel getInstancelevel(String image) {

        FragmentLevel frag = new FragmentLevel();

        Bundle bundle = new Bundle();

        bundle.putString("photoNum", image);//we are putting a string(nameKey, string);

        frag.setArguments(bundle);

        return  frag;
    }
}

