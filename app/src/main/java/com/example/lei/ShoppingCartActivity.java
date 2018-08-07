package com.example.lei;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lei.adapters.ShoppingcartAdapter;
import com.example.lei.foodordering.R;
import com.leiwang.foodordering.domain.Dish;

import java.util.ArrayList;

public class ShoppingCartActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingcart);
        ArrayList<Dish> dishes = (ArrayList<Dish>) getIntent().getSerializableExtra("dishList");

        final ListView mListView = (ListView) findViewById(R.id.shoppingcartList);
        final ShoppingcartAdapter mAdapter = new ShoppingcartAdapter(ShoppingCartActivity.this,
                R.layout.shoppingcart,dishes);
        mListView.setAdapter(mAdapter);

        final TextView sumView = (TextView) findViewById(R.id.sum);
        double sum =0.0;
        for(Dish d: dishes){
            sum += d.getDishPrice();
        }
        double tax = sum*0.09;
        double total = sum + tax + 5;

        String output = String.format("Subtotal: %.2f\nTax: %.2f\nShipping: 5.00\nTotal: %.2f",sum,tax,total);
        sumView.setText(output);

    }
}
