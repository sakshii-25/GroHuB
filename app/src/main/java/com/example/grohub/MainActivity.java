package com.example.grohub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;
    //THIS WILL TAKE CARE OF HOW LONG WOULD SPLASH SCREEN STAY ON THE SCREEN.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TO REMOVE THE STATUS BAR/ACTION BAR FROM THE SCREEN
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                Intent intenet = new Intent(MainActivity.this, Login.class);
                startActivity(intenet);
                finish();
            }
        }, SPLASH_SCREEN);
    }
}