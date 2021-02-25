package com.example.android.wisatasitubondo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

public class TourismAndWaterParkActivity extends AppCompatActivity {

    ImageView imgSpot;
    TextView tvPhotoSource, tvSpotTitle, tvSpotLocation, tvSpotDesc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Toolbar toolbar = findViewById(R.id.descToolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.tourismandwaterpark);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimaryDark));

        onPrepare();
        onCactchData();

    }

    public void onPrepare(){
        imgSpot = findViewById(R.id.photoDescription);
        tvPhotoSource = findViewById(R.id.photoSource);
        tvSpotTitle = findViewById(R.id.title2);
        tvSpotLocation = findViewById(R.id.location2);
        tvSpotDesc = findViewById(R.id.placeDescription);
    }

    public void onCactchData(){
        Intent intent = getIntent();
        int photo = intent.getIntExtra("Photo", 0);
        String photoSource = intent.getStringExtra("photoSource");
        String spotTitle = intent.getStringExtra("spotTitle");
        String spotLocation = intent.getStringExtra("spotLocation");
        String spotDesc = intent.getStringExtra("spotDescription");

        imgSpot.setImageResource(photo);
        tvPhotoSource.setText(photoSource);
        tvSpotTitle.setText(spotTitle);
        tvSpotLocation.setText(spotLocation);
        tvSpotDesc.setText(spotDesc);
    }
}
