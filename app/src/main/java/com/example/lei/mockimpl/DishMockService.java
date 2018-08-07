package com.example.lei.mockimpl;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import com.example.lei.backends.api.DishService;

import com.example.lei.foodordering.R;
import com.leiwang.foodordering.domain.Dish;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lei on 10/30/2017.
 */

public class DishMockService implements DishService {
    private List<Dish>  menu101= new ArrayList();
    private List<Dish>  menu102= new ArrayList();
    private List<Dish>  menu103= new ArrayList();
    private List<Dish>  menu201= new ArrayList();
    private List<Dish>  menu202= new ArrayList();
    private List<Dish>  menu301= new ArrayList();
    private List<Dish>  menu401= new ArrayList();
    private List<Dish>  menu501= new ArrayList();
    private Map<Integer,List<Dish>> restaurantMenu = new HashMap<>();

    public DishMockService(){
        initMenu();
    }

    private void initMenu() {
        Dish r11 = new Dish(101, "Grizz", "sweet cream pancakes,thick-cut smoked bacon and sausage", 14.49,R.drawable.food3);
        menu101.add(r11);
        Dish r12 = new Dish(101, "Fried Steak&eggs", "eggs,strip-cut hash browns,country red potatoes", 14.99,R.drawable.food1);
        menu101.add(r12);
        Dish r13 = new Dish(101, "Chicken Apple Sausage", "smoked chicken, sweet apples", 11.49,R.drawable.food2);
        menu101.add(r13);
        Dish r14 = new Dish(102, "Original pizza", "10 oz cut", 15.99,R.drawable.pizza1_);
        menu102.add(r14);
        Dish r15 = new Dish(102, "Carne Asada Pizza", "Tender marinated steak, fire-roasted poblanos, cilantro pesto", 11.49,R.drawable.pizza2);
        menu102.add(r15);
        Dish r18 = new Dish(102, "California Veggie", "Baby broccoli, eggplant, Cremini mushrooms, sun-dried tomatoes", 11.49,R.drawable.pizza3);
        menu102.add(r18);
        Dish r16 = new Dish(103, "Original Cheesecake", "Creamy Cheesecake with a Graham Cracker Crust and Sour Cream Topping", 6.99,R.drawable.cake);
        menu103.add(r16);
        Dish r17 = new Dish(103, "Strawberry Cake", "The Original Topped with Glazed Fresh Strawberries.", 7.49,R.drawable.cake1);
        menu103.add(r17);
        Dish r19 = new Dish(103, "Chocolate Cake", "Godiva Chocolate Brownie, Vanilla Ice Cream.", 7.49,R.drawable.cake2);
        menu103.add(r19);

        Dish r21 = new Dish(201, "Black Pepper Tuna", "Seared red tuna with black pepper seasoning with veggie, mango", 14,R.drawable.sushi1);
        menu201.add(r21);
        Dish r22 = new Dish(201, "Soft Shell Crab", "Deep fried breaded Maryland soft shell crab served with Japanese tartar sauce",R.drawable.sushi2);
        menu201.add(r22);
        Dish r23 = new Dish(201, "Beef Tataki", "Roasted beef served on white truffle oil with oyster sauce radish sprouts", 14,R.drawable.sushi3);
        menu201.add(r23);
        Dish r24 = new Dish(202, "Truffle Salmon", "Raw salmon & seared salmon with truffle oil on top", 14,R.drawable.japan1);
        menu202.add(r24);
        Dish r25 = new Dish(202, "Sea Urchin", "A tray of uni, origin varies, prices depend on availability and grade", 15,R.drawable.japan2);
        menu202.add(r25);
        Dish r26 = new Dish(202, "Mini Uni", "Origin varies, prices depend on availability and grade", 18,R.drawable.japan3);
        menu202.add(r26);

        Dish r31 = new Dish(301, "Chicken Margherita", "Grilled chicken breasts topped with fresh tomatoes, mozzarella.", 17.49,R.drawable.ita1);
        menu301.add(r31);
        Dish r32 = new Dish(301, "Garlic Mussels Marinara", "Oven-roasted mussels tossed", 11.99,R.drawable.ita2);
        menu301.add(r32);
        Dish r33 = new Dish(301, "Lasagna Classico", "Prepared fresh daily with layers of pasta, parmesan, mozzarella", 17.29,R.drawable.ita3);
        menu301.add(r33);

        Dish r41 = new Dish(401, "Chicken Tikka Masala", "spicy creamy curry with chicken", 7.99,R.drawable.ind1);
        menu401.add(r41);
        Dish r42 = new Dish(401, "Chicken Korma", "Traditional Dish cooked with blend of exotic herbs and selected species", 6.95,R.drawable.ind2);
        menu401.add(r42);
        Dish r43 = new Dish(401, "Achari Chicken", "Pickle flavor chicken with green chili, herbs&spices", 6.95,R.drawable.ind3);
        menu401.add(r43);

        Dish r51 = new Dish(501, "Minced pork noodle soup with egg", "Noodle soup", 8.99,R.drawable.chi1);
        menu501.add(r51);
        Dish r52 = new Dish(501, "Chinois Chicken Salad", "BBQ chicken breast and crispy tortilla strips with lettuce and chinese mustard dressing", 7.49,R.drawable.chi2);
        menu501.add(r52);
        Dish r53 = new Dish(501, "Field Greens with Teriyaki Salmon", "Wild field greens, cherry tomatoes, cucumbers, tossed in soy-citrus vinaigrette", 9.99,R.drawable.chi3);
        menu501.add(r53);

        restaurantMenu.put(101, menu101);
        restaurantMenu.put(102, menu102);
        restaurantMenu.put(103, menu103);
        restaurantMenu.put(201, menu201);
        restaurantMenu.put(202, menu202);
        restaurantMenu.put(301, menu301);
        restaurantMenu.put(401, menu401);
        restaurantMenu.put(501, menu501);
    }

    @Override
    public List<Dish> getRestaurantMenuById(int id){
        return restaurantMenu.get(id);
    }

    @Override
    public byte [] getImageById(int imageId) {
        Drawable drawable = ContextCompat.getDrawable(
                BackendMockFactory.getApplicationContext(), imageId);
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        return stream.toByteArray();
    }
}