package com.example.android.wisatasitubondo;

import android.content.Context;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CategoryPager extends FragmentPagerAdapter {

    private Context mContet;
    private String[] title = {" Pantai ", " Kolam ", " Hotel ", "Dermaga"};


    public CategoryPager(Context mContext, FragmentManager fm) {
        super(fm);
        mContet = mContext;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new BeachFragment();
        }else if (position == 1){
            return new WaterBoomFragment();
        }else if (position == 2){
            return new Hotel();
        } else{
            return new TourismAndWaterPark();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return title[position];
        } else if(position == 1){
            return  title[position];
        } else  if(position == 2) {
            return title[position];
        } else
            return title[position];
    }


    @Override
    public int getCount() {
        return 4;
    }
}
