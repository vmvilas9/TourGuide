package com.example.android.tourguide;

import android.graphics.Bitmap;
import android.util.Log;

/**
 * Created by Admin on 16-03-2018.
 */

public class Tour{
    public static final String LOG_TAG = Tour.class.getName();
    final private String mName;
    final private String mAddress;
    final private String mNumber;
    final private float mRating;
    final private Bitmap mImage;
    final private String mPhone;
    public Tour(String name, String address, String number, float rating,Bitmap image,String phone){
        mName = name;
        mAddress = address;
        mNumber = number;
        mRating = rating;
        mImage = image;
        mPhone = phone;
    }
    public String getName(){return mName;}

    public String getAddress(){return mAddress;}

    public String getNumber(){return mNumber;}

    public float getRating(){return mRating;}

    public Bitmap getImage() {return mImage;}

    public String getPhone() {return mPhone;}
}
