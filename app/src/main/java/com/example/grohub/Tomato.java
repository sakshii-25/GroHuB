 package com.example.grohub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

 public class Tomato extends AppCompatActivity {

     ImageView imageView4;
     String s1[];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomato);


        imageView4 = findViewById(R.id.tomatoImageView);
        imageView4.setImageResource(getIntent().getExtras().getInt("Images"));

        s1 = getResources().getStringArray(R.array.Price);

    }


 }