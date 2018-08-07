package com.example.lei;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.lei.adapters.Adapter_MenuList;
import com.example.lei.adapters.PopularDishAdapter;
import com.example.lei.backends.api.DishService;
import com.example.lei.mockimpl.DishMockService;
import com.example.lei.foodordering.R;
import com.leiwang.foodordering.domain.Dish;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lei on 10/20/2017.
 */

public class MenuListActivity extends AppCompatActivity {

    private List<Dish> restaurantMenu = new ArrayList<>();
    private DishService dishService = new DishMockService();

    // private Map<Integer,List<Dish>> restaurantMenu= new HashMap<Integer,List<Dish>>();

    private RecyclerView mRecyclerview;
    private RecyclerView.LayoutManager mlayoutManager;
    private RecyclerView.Adapter mRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        // set the title bar with the chosen restaurant name
        Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar1);
        Bundle mBunndle = getIntent().getExtras();
        if (mBunndle != null) {
            toolbar1.setTitle(mBunndle.getString("restaurantName"));
        }

        // get the id of the chosen restaurant
        int restaurantId = mBunndle.getInt("restaurantId");
        // get the menu of the chosen restaurant
        restaurantMenu = BackendServices.getDishService().getRestaurantMenuById(restaurantId);
        // top picture roll of popular dishes
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerview.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerview.setLayoutManager(mlayoutManager);
        mRecyclerAdapter = new PopularDishAdapter(restaurantMenu, dishService);
        mRecyclerview.setAdapter(mRecyclerAdapter);

        // list view of menu with checkboxes
        final ListView mListView = (ListView) findViewById(R.id.restaurantMenu);
        mListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        final Adapter_MenuList adapterMenuList = new Adapter_MenuList(MenuListActivity.this, R.layout.restaurantmenu_list, restaurantMenu);
        mListView.setAdapter(adapterMenuList);

        // click the "add to cart" button
        final Button buttonCart = (Button) findViewById(R.id.cartButton);
        buttonCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!adapterMenuList.getSelectionDish().isEmpty()) {
                    Intent cartIntent = new Intent(MenuListActivity.this, ShoppingCartActivity.class);
                    cartIntent.putExtra("dishList", adapterMenuList.getSelectionDish());
                    startActivity(cartIntent);
                }
            }
        });
    }

}
