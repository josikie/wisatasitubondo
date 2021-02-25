package com.example.android.wisatasitubondo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;

import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Objects;

public class BeachDescription extends AppCompatActivity {

    ArrayList<Spot> spotArrayList;
    private TextView tvPhotoSource, tvTitle, tvSpotLocation, tvDescription;
    private ImageView imgSpot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        
        Toolbar toolbar = findViewById(R.id.descToolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.beach);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimaryDark));

        imgSpot = findViewById(R.id.photoDescription);
        tvPhotoSource = findViewById(R.id.photoSource);
        tvSpotLocation = findViewById(R.id.location2);
        tvTitle = findViewById(R.id.title2);
        tvDescription = findViewById(R.id.placeDescription);

        Intent data = getIntent();
        String photoSource = data.getStringExtra("photoSource");
        String spotLocation = data.getStringExtra("spotLocation");
        String spotDescription = data.getStringExtra("spotDescription");
        String spotTitle = data.getStringExtra("spotTitle");
        int photo = data.getIntExtra("Photo", 0);

        tvPhotoSource.setText(photoSource);
        tvSpotLocation.setText(spotLocation);
        tvDescription.setText(spotDescription);
        tvTitle.setText(spotTitle);
        imgSpot.setImageResource(photo);

    }


}
