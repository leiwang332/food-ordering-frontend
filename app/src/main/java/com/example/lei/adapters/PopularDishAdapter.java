package com.example.lei.adapters;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lei.backends.api.DishService;
import com.example.lei.foodordering.R;
import com.leiwang.foodordering.domain.Dish;

import java.util.ArrayList;
import java.util.List;

public class PopularDishAdapter extends RecyclerView.Adapter<PopularDishAdapter.ViewHolder> {
    private final DishService dishService;
    private final List<Dish> popularDishes = new ArrayList<>();

    public PopularDishAdapter(List<Dish> menu, DishService dishService) {
        for (Dish dish : menu) {
            if (dish.getDishImage() != null) {
                popularDishes.add(dish);
            }
        }
        this.dishService = dishService;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.populardish,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    private Drawable convertToDrawable(byte [] bytes) {
        return new BitmapDrawable(BitmapFactory.decodeByteArray(bytes, 0, bytes.length));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Dish dish = popularDishes.get(position);
        holder.mName.setText(dish.getDishName());
        if (dish.getDishImage() != null) {
            byte [] bytes = dishService.getImageById(dish.getDishId());
            holder.mImage.setImageDrawable(convertToDrawable(bytes));
        }
    }

    @Override
    public int getItemCount() {
        return popularDishes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mName;
        public  ImageView mImage;
        Dish mdish;

        public ViewHolder(View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.populartitle);
            mImage = itemView.findViewById(R.id.popularimage);
        }
    }
}