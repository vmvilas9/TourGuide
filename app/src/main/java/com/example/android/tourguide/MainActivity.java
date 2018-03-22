package com.example.android.tourguide;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView restraunt = (TextView) findViewById(R.id.restraunt);
        restraunt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent restrauntIntent = new Intent(MainActivity.this,RestrauntActivity.class);
                startActivity(restrauntIntent);
            }
        });

        TextView park = (TextView) findViewById(R.id.park);
        park.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent parkIntent = new Intent(MainActivity.this,ParkActivity.class);
                startActivity(parkIntent);
            }
        });

        TextView famousPlaces = (TextView) findViewById(R.id.famousPlaces);
        famousPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent famousPlacesIntent = new Intent(MainActivity.this,FamousPlacesActivity.class);
                startActivity(famousPlacesIntent);
            }
        });
    }
}
