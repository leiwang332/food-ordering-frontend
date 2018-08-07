package com.example.lei;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.lei.adapters.Adapter_RestList;
import com.example.lei.foodordering.R;
import com.leiwang.foodordering.domain.Restaurant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lei on 9/27/2017.
 */

public class HomeActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Adapter_RestList selectedAdapter;
    private List<Restaurant> selectedRestaurant = new ArrayList<>();
    private List<Restaurant> allRestaurant = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final int selection[] = {-1}; // variable to save the index of selected item
        //toolbar with food type spinner
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final Spinner mspinner = (Spinner) findViewById(R.id.spinner);

        //list view of restaurants
        allRestaurant = BackendServices.getRestaurantService().getAllRestaurant();
        final ListView mListView = (ListView) findViewById(R.id.listView);
        final Adapter_RestList adapterRestList = new Adapter_RestList(HomeActivity.this,
                R.layout.restaurant_list, allRestaurant);
        mListView.setAdapter(adapterRestList);

        // list view in spinner:food types
        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(HomeActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.FoodStyles));
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mspinner.setAdapter(myAdapter1);

        // select one food category from the spinner
        mspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedAdapter = new Adapter_RestList(HomeActivity.this, R.layout.restaurant_list, selectedRestaurant);
                if (i == 0) {
                    selectedRestaurant.clear();
                    selectedRestaurant.addAll(allRestaurant);
                    mListView.setAdapter(adapterRestList);
                } else {
                    selectedRestaurant.clear();
                    for (Restaurant r : allRestaurant) {
                        if (r.getCategoryId() == i) {
                            selectedRestaurant.add(r);
                        }
                    }
                    mListView.setAdapter(selectedAdapter);
                }
                selection[0] = i;
                selectedAdapter.notifyDataSetChanged(); //selectedAdapter now is changed to selected food type

                //click one restaurant from the current listView
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent menuIntent = new Intent(HomeActivity.this, MenuListActivity.class);
                        Bundle extras = new Bundle();
                        Adapter_RestList.ViewHolder viewHolder = (Adapter_RestList.ViewHolder) view.getTag();
                        extras.putString("restaurantName", viewHolder.restaurant.getName());
                        extras.putInt("restaurantId", viewHolder.restaurant.getId());
                        menuIntent.putExtras(extras);
                        startActivity(menuIntent);
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        //left side navigation drawer
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
