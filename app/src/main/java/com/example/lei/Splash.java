package com.example.lei;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lei.foodordering.R;

/**
 * Created by Lei on 12/2/2017.
 */

public class Splash extends AppCompatActivity{

    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        image = (ImageView) findViewById(R.id.splash);

        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.transition);
        image.startAnimation(myanim);

        final Intent i = new Intent(Splash.this, LoginActivity.class);
        Thread timer = new Thread(){
           public void run(){
               try{
                   sleep(2500);
               } catch (InterruptedException e){
                   e.printStackTrace();
               }
               finally {
                   startActivity(i);
                   finish();
               }
           }
        };
        timer.start();
    }
}
