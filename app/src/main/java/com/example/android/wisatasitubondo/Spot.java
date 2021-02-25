package com.example.android.wisatasitubondo;

import android.os.Parcel;
import android.os.Parcelable;

public class Spot implements Parcelable {
    private int spotPicture = NO_IMAGE_PROVIDED;
    private String spotName;
    private String spotLocation;
    private String sourcePicture;
    private String spotDescription;

    private static final int NO_IMAGE_PROVIDED = -1;

    // const for NO_IMAGE_PROVIDED


    public String getSpotDescription() {
        return spotDescription;
    }

    public String getSourcePicture(){
        return sourcePicture;
    }

    //hasimage
    public boolean hasImage(){
        return spotPicture != NO_IMAGE_PROVIDED;
    }

    public String getSpotLocation() {
        return spotLocation;
    }

    public String getSpotName() {
        return spotName;
    }

    public int getSpotPicture() {
        return spotPicture;
    }


    public Spot(int spotPicture, String spotPictureSource, String spotName, String spotLocation, String spotDescription ) {
        this.spotPicture = spotPicture;
        this.sourcePicture = spotPictureSource;
        this.spotName = spotName;
        this.spotLocation = spotLocation;
        this.spotDescription = spotDescription;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.spotPicture);
        dest.writeString(this.sourcePicture);
        dest.writeString(this.spotName);
        dest.writeString(this.spotLocation);
        dest.writeString(this.spotDescription);
    }

    protected Spot(Parcel in) {
        this.spotPicture = in.readInt();
        this.sourcePicture = in.readString();
        this.spotName = in.readString();
        this.spotLocation = in.readString();
        this.spotDescription = in.readString();
    }

    public static final Parcelable.Creator<Spot> CREATOR = new Parcelable.Creator<Spot>() {
        @Override
        public Spot createFromParcel(Parcel source) {
            return new Spot(source);
        }

        @Override
        public Spot[] newArray(int size) {
            return new Spot[size];
        }
    };

    @Override
    public String toString() {
        return "Spot{" +
                "spotPicture=" + spotPicture +
                ", spotPictureSource='" + sourcePicture + '\'' +
                ", spotName='" + spotName + '\'' +
                ", spotLocation='" + spotLocation + '\'' +
                ", spotDescription='" + spotDescription + '\'' +
                '}';
    }
}
