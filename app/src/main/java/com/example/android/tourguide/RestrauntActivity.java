package com.example.android.tourguide;

import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceBufferResponse;
import com.google.android.gms.location.places.PlaceLikelihoodBufferResponse;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Admin on 15-03-2018.
 */

public class RestrauntActivity extends AppCompatActivity {
    public static final String LOG_TAG = RestrauntActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tour_list);
        GeoDataClient mgeoDataClient;
        final ArrayList<Tour> tour = new ArrayList<>();
        final TourAdapter adapter = new TourAdapter(this, tour);
        final ListView listView = (ListView) findViewById(R.id.list);
        mgeoDataClient = Places.getGeoDataClient(this, null);
        mgeoDataClient.getPlaceById("ChIJCW8IJ-rsDzkRI1FpwEbBRwk", "ChIJWat28iPtDzkR3r-0EOaCj0s").addOnCompleteListener
                (new OnCompleteListener<PlaceBufferResponse>() {
                    @Override
                    public void onComplete(@NonNull Task<PlaceBufferResponse> task) {
                        if (task.isSuccessful()) {
                            PlaceBufferResponse places = task.getResult();
                            for (int i = 0; i < places.getCount(); i++) {
                                Place myPlace = places.get(i);
                                tour.add(new Tour(myPlace.getName().toString(), myPlace.getAddress().toString(), myPlace.getPhoneNumber().toString(), myPlace.getRating()));
                                Log.i(LOG_TAG, myPlace.getName().toString() + " " + places.getCount());
                            }
                            places.release();
                            listView.setAdapter(adapter);
                        }
                    }
                });
    }

}
