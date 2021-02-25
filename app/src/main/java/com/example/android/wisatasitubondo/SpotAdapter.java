package com.example.android.wisatasitubondo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SpotAdapter extends BaseAdapter {

    private int mColor;
    private Context context;
    LayoutInflater layoutInflater;
    private List<Spot> spotList;
    private ArrayList<Spot> spotArrayList;

    public class ViewHolder{
        TextView name;
        TextView tvLocation;
        ImageView imageView;
        View textContainer;
    }

    public SpotAdapter(Context mContext, List<Spot> spotList, int color) {
        context = mContext;
        this.spotList = spotList;
        layoutInflater = LayoutInflater.from(mContext);
        this.spotArrayList = new ArrayList<Spot>();
        this.spotArrayList.addAll(spotList);
        mColor=color;
    }


    @Override
    public int getCount() {
        return spotList.size();
    }

    @Override
    public Spot getItem(int position) {
        return spotList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.list_item, null);
            holder.name = convertView.findViewById(R.id.titlee);
            holder.tvLocation = convertView.findViewById(R.id.contentLocation);
            holder.imageView = convertView.findViewById(R.id.circle_image);
            holder.textContainer = convertView.findViewById(R.id.constraint);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.imageView.setImageResource(spotList.get(position).getSpotPicture());
        holder.name.setText(spotList.get(position).getSpotName());
        holder.tvLocation.setText(spotList.get(position).getSpotLocation());

        int color = ContextCompat.getColor(context, mColor);
        holder.textContainer.setBackgroundColor(color);

        return convertView;

    }


    public void filter(String text) {
        text = text.toLowerCase(Locale.getDefault());
        spotList.clear();
        if (text.length() == 0){
            spotList.addAll(spotArrayList);
        }else {
            for (Spot wp : spotArrayList){
                if (wp.getSpotName().toLowerCase(Locale.getDefault()).contains(text)){
                    spotList.add(wp);
                }
            }
        }

        notifyDataSetChanged();
    }
}
