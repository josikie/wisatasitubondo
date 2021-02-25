package com.example.android.wisatasitubondo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class WaterBoomDescription extends AppCompatActivity {

    private ImageView imgSpot;
    private TextView tvSourcePhoto, tvSpotTitle, tvSpotDescription, tvSpotLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Toolbar toolbar = findViewById(R.id.descToolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.waterboom);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimaryDark));

        onPrepare();
        onCatchData();

    }

    public  void onPrepare(){
         imgSpot = findViewById(R.id.photoDescription);
         tvSourcePhoto = findViewById(R.id.photoSource);
         tvSpotLocation = findViewById(R.id.location2);
         tvSpotTitle = findViewById(R.id.title2);
         tvSpotDescription = findViewById(R.id.placeDescription);
    }

    private void onCatchData(){
        Intent intent = getIntent();
        int photo = intent.getIntExtra("photo", 0);
        String photoSource = intent.getStringExtra("photoSource");
        String spotLocation = intent.getStringExtra("spotLocation");
        String spotTitle = intent.getStringExtra("spotTitle");
        String spotDesc = intent.getStringExtra("spotDescription");

        imgSpot.setImageResource(photo);
        tvSourcePhoto.setText(photoSource);
        tvSpotLocation.setText(spotLocation);
        tvSpotTitle.setText(spotTitle);
        tvSpotDescription.setText(spotDesc);


    }
}
