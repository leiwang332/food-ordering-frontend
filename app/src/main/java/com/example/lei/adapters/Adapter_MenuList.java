package com.example.lei.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import com.example.lei.foodordering.R;
import com.leiwang.foodordering.domain.Dish;

public class Adapter_MenuList extends ArrayAdapter<Dish> {
    private final int resourceId;
    private final List<Dish> dishes;
    private ArrayList<Dish> selectionDish = new ArrayList<>();

    static class ViewHolder {
        TextView mDishName;
        TextView mDishDetail;
        TextView mprice;
        CheckBox mcheckBox;
    }

    public Adapter_MenuList(Context context, int listViewResourceId, List<Dish> dishList) {
        super(context, listViewResourceId, dishList);
        resourceId = listViewResourceId;
        dishes= dishList;
    }

    @Override
    public int getCount() {
        return dishes.size();
    }

    // get the dish in the current position
    @Override
    public Dish getItem(int position) {
        return dishes.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Dish dish = getItem (position);
        View view;
        ViewHolder mViewHolder = new ViewHolder();
        //Create a new row view
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            // find the child views and save it in mViewHolder
            mViewHolder.mDishName = (TextView) view.findViewById(R.id.dishName);
            mViewHolder.mDishDetail = (TextView) view.findViewById(R.id.dishDetail);
            mViewHolder.mprice = (TextView) view.findViewById(R.id.price);
            mViewHolder.mcheckBox = (CheckBox) view.findViewById(R.id.checkbox);
            //tag the dish object to its checkbox,so that when you click one checkbox, android know which dish you choose
            mViewHolder.mcheckBox.setTag(dish);
            mViewHolder.mDishDetail.setTag(dish);
            mViewHolder.mDishDetail.setTag(dish);
            mViewHolder.mprice.setTag(dish);

            view.setTag(mViewHolder);

            mViewHolder.mcheckBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CheckBox cb = (CheckBox) view;
                    Dish dish = (Dish)cb.getTag();

                    if (selectionDish.contains(dish)) {
                        selectionDish.remove(dish);
                    } else {
                        selectionDish.add(dish);
                    }
                }
            });
        }
        // Reuse existing row view
        else{
            view = convertView;
        }
        mViewHolder.mDishName.setText(dish.getDishName());
        mViewHolder.mDishDetail.setText(dish.getDishDescription());
        mViewHolder.mprice.setText(String.valueOf(dish.getDishPrice()));

        return view;
    }

    public ArrayList<Dish> getSelectionDish() {
        return selectionDish;
    }
}