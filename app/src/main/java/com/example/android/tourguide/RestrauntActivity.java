package com.example.android.tourguide;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceBufferResponse;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoMetadataBuffer;
import com.google.android.gms.location.places.PlacePhotoMetadataResponse;
import com.google.android.gms.location.places.PlacePhotoResponse;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;


/**
 * Created by Admin on 15-03-2018.
 */

public class RestrauntActivity extends AppCompatActivity {
    private GeoDataClient mGeoDataClient;
    private Bitmap bitImage;
    public static final String LOG_TAG = RestrauntActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tour_list);
        final ArrayList<Tour> tour = new ArrayList<>();
        final ListView listView = (ListView) findViewById(R.id.list);
        final TourAdapter adapter = new TourAdapter(this, tour);
        mGeoDataClient = Places.getGeoDataClient(this, null);
        final String [] placeId = {"ChIJCW8IJ-rsDzkRI1FpwEbBRwk", "ChIJWat28iPtDzkR3r-0EOaCj0s"};
        mGeoDataClient.getPlaceById(placeId[0],placeId[1])
                .addOnSuccessListener
                        (new OnSuccessListener<PlaceBufferResponse>() {
                            @Override
                            public void onSuccess(final PlaceBufferResponse places) {
                                for (int i = 0; i < places.getCount(); i++) {
                                    final Place myPlace = places.get(i);
                                    final Task<PlacePhotoMetadataResponse> photoMetadataResponse = mGeoDataClient.getPlacePhotos(placeId[i]);
                                    photoMetadataResponse.addOnSuccessListener(new OnSuccessListener<PlacePhotoMetadataResponse>() {
                                        @Override
                                        public void onSuccess(PlacePhotoMetadataResponse placePhotoMetadataResponse) {
                                            // Get the PlacePhotoMetadataBuffer (metadata for all of the photos).
                                            PlacePhotoMetadataBuffer photoMetadataBuffer = placePhotoMetadataResponse.getPhotoMetadata();
                                            // Get the first photo in the list.
                                            PlacePhotoMetadata photoMetadata = photoMetadataBuffer.get(0);
                                            // Get a full-size bitmap for the photo.
                                            Task<PlacePhotoResponse> photoResponse = mGeoDataClient.getPhoto(photoMetadata);
                                            photoResponse.addOnSuccessListener(new OnSuccessListener<PlacePhotoResponse>() {
                                                @Override
                                                public void onSuccess(PlacePhotoResponse placePhotoResponse) {
                                                    Log.i(LOG_TAG, "3");
                                                    bitImage = placePhotoResponse.getBitmap();
                                                    tour.add(new Tour(myPlace.getName().toString(), myPlace.getAddress().toString(), myPlace.getPhoneNumber().toString(), myPlace.getRating(),bitImage,myPlace.getPhoneNumber().toString()));
                                                    listView.setAdapter(adapter);
                                                }
                                            });
                                            photoMetadataBuffer.release();
                                            places.release();
                                        }
                                    });
                                    Log.i(LOG_TAG, "1");
                                }
                            }
                        });
        Log.i(LOG_TAG, "2");
    }
}
