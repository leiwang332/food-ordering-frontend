package com.example.lei.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.lei.foodordering.R;
import com.leiwang.foodordering.domain.Dish;

import java.util.List;

public class ShoppingcartAdapter extends ArrayAdapter<Dish> {
    private final int resourceId;
    private final List<Dish> dishes;

    public static class ViewHolder {
        TextView mDishName;
        TextView mQuantity;
        TextView mAmount;
        TextView mprice;
    }

    public ShoppingcartAdapter(Context context, int listViewResourceId, List<Dish> dishList) {
        super(context, listViewResourceId, dishList);
        resourceId = listViewResourceId;
        dishes= dishList;
    }

    @Override
    public int getCount() {
        return dishes.size();
    }

    @Override
    public Dish getItem(int position) {
        return dishes.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Dish dish = getItem(position);
        View view;
        ShoppingcartAdapter.ViewHolder mViewHolder;

        //Create a new row view
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            mViewHolder = new ShoppingcartAdapter.ViewHolder();
            // find the child views and save it in mViewHolder
            mViewHolder.mDishName = (TextView) view.findViewById(R.id.dishName);
            mViewHolder.mprice = (TextView) view.findViewById(R.id.price);
            mViewHolder.mQuantity = (TextView) view.findViewById(R.id.quantity);
            mViewHolder.mAmount = (TextView) view.findViewById(R.id.amount);

            view.setTag(mViewHolder);
        } else {
            view = convertView;
            mViewHolder = (ViewHolder) view.getTag();
        }

        mViewHolder.mDishName.setText(dish.getDishName());
        mViewHolder.mprice.setText(String.valueOf(dish.getDishPrice()));
        mViewHolder.mQuantity.setText(String.valueOf(1));
        mViewHolder.mAmount.setText(String.valueOf(dish.getDishPrice()));

        return view;
    }
}