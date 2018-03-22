package com.example.android.tourguide;

import android.util.Log;

import com.google.android.gms.common.api.GoogleApi;

/**
 * Created by Admin on 16-03-2018.
 */

public class Tour{
    public static final String LOG_TAG = Tour.class.getName();
    final private String mName;
    final private String mAddress;
    final private String mNumber;
    final private float mRating;
    public Tour(String name,String address,String number,float rating){
        mName = name;
        mAddress = address;
        mNumber = number;
        mRating = rating;
    }

    public String getName(){return mName;}

    public String getAddress(){return mAddress;}

    public String getNumber(){return mNumber;}

    public float getRating(){return mRating;}
}
