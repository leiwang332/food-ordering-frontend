package com.example.lei.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lei.foodordering.R;
import com.leiwang.foodordering.domain.Restaurant;

import java.util.List;

/**
 * Created by Lei on 10/19/2017.
 */

public class Adapter_RestList extends ArrayAdapter<Restaurant> {
    private final int resourceId;
    private final List<Restaurant> restaurants;

    public Adapter_RestList(Context context, int listViewResourceId, List<Restaurant> restaurantList) {
        super(context, listViewResourceId, restaurantList);
        resourceId = listViewResourceId;
        restaurants = restaurantList;
    }

    @Override
    public int getCount() {
        return restaurants.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Restaurant restaurant = restaurants.get(position);
        View view;
        ViewHolder mViewHolder = new ViewHolder();

        view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        mViewHolder.mName = (TextView) view.findViewById(R.id.textView);
        mViewHolder.mImage = (ImageView) view.findViewById(R.id.imageView);
        mViewHolder.restaurant = restaurant;
        view.setTag(mViewHolder);

        mViewHolder.mName.setText(restaurant.getName());
        mViewHolder.mImage.setImageResource(restaurant.getImageId());

        return view;
    }

    public static class ViewHolder {
        public TextView mName;
        public ImageView mImage;
        public Restaurant restaurant;
    }


}
