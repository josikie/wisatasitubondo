package com.example.android.wisatasitubondo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

public class HotelActivity extends AppCompatActivity {

    private ImageView imgSpot;
    private TextView tvPhotoSource, tvSpotTitle, tvSpotLocation, tvSpotDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Toolbar toolbar = findViewById(R.id.descToolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.hotel);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimaryDark));

        onPrepare();
        onCacthData();


    }

    private void onPrepare(){
        imgSpot = findViewById(R.id.photoDescription);
        tvPhotoSource = findViewById(R.id.photoSource);
        tvSpotTitle = findViewById(R.id.title2);
        tvSpotLocation = findViewById(R.id.location2);
        tvSpotDescription = findViewById(R.id.placeDescription);
    }

    private void onCacthData(){
        Intent getData = getIntent();
        int photo = getData.getIntExtra("photo", 0);
        String photoSource = getData.getStringExtra("photoSource");
        String spotTitle = getData.getStringExtra("spotTitle");
        String spotLocation = getData.getStringExtra("spotLocation");
        String spotDescription = getData.getStringExtra("spotDescription");

        imgSpot.setImageResource(photo);
        tvPhotoSource.setText(photoSource);
        tvSpotTitle.setText(spotTitle);
        tvSpotLocation.setText(spotLocation);
        tvSpotDescription.setText(spotDescription);
    }
}
