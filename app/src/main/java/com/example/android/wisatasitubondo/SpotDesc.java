package com.example.android.wisatasitubondo;

import android.os.Parcel;
import android.os.Parcelable;

public class SpotDesc implements Parcelable {
    private int photooo;
    private String photoSourceee;
    private String spotLocationnn;
    private String spotTitleee;
    private String spotDescriptionnn;

    public int getPhotooo() {
        return photooo;
    }

    public String getSpotDescriptionnn() {
        return spotDescriptionnn;
    }

    public SpotDesc(int photooo, String photoSourceee, String spotTitleee, String spotLocationnn, String spotDescriptionnn) {
        this.photooo = photooo;
        this.photoSourceee = photoSourceee;
        this.spotTitleee = spotTitleee;
        this.spotLocationnn = spotLocationnn;
        this.spotDescriptionnn = spotDescriptionnn;
    }

    public String getSpotTitleee() {
        return spotTitleee;
    }

    public String getSpotLocationnn() {
        return spotLocationnn;
    }

    public String getPhotoSourceee() {
        return photoSourceee;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.photooo);
        dest.writeString(this.photoSourceee);
        dest.writeString(this.spotLocationnn);
        dest.writeString(this.spotTitleee);
        dest.writeString(this.spotDescriptionnn);
    }

    protected SpotDesc(Parcel in) {
        this.photooo = in.readInt();
        this.photoSourceee = in.readString();
        this.spotLocationnn = in.readString();
        this.spotTitleee = in.readString();
        this.spotDescriptionnn = in.readString();
    }

    public static final Parcelable.Creator<SpotDesc> CREATOR = new Parcelable.Creator<SpotDesc>() {
        @Override
        public SpotDesc createFromParcel(Parcel source) {
            return new SpotDesc(source);
        }

        @Override
        public SpotDesc[] newArray(int size) {
            return new SpotDesc[size];
        }
    };
}
