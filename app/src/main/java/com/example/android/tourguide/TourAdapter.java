package com.example.android.tourguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Admin on 16-03-2018.
 */

public class TourAdapter extends ArrayAdapter<Tour> {
    public static final String LOG_TAG = TourAdapter.class.getName();

    public TourAdapter(Activity context, ArrayList<Tour> tour){
        super(context,0,tour);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        Tour currentTour = getItem(position);
        TextView nameView = (TextView)listItemView.findViewById(R.id.place_name);
        nameView.setText(currentTour.getName());
        TextView addressView = (TextView)listItemView.findViewById(R.id.address);
        addressView.setText(currentTour.getAddress());
        RatingBar ratingBar = (RatingBar)listItemView.findViewById(R.id.rating_bar);
        ratingBar.setRating(currentTour.getRating());
        ImageView imageView = (ImageView)listItemView.findViewById(R.id.image);
        imageView.setImageBitmap(currentTour.getImage());
        TextView phoneView = (TextView)listItemView.findViewById(R.id.phone);
        phoneView.setText(currentTour.getPhone());
        return listItemView;
    }
}