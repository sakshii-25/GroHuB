package com.example.grohub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.grohub.adapter.RecommendedProductsAdapter;

import java.util.ArrayList;
import java.util.List;

public class Homepage extends AppCompatActivity {

    RecyclerView dataList;
    List<Integer> images;
    RecommendedProductsAdapter recommendedProductsAdapter;

    //ImageView vegetableBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_homepage);

     /*   vegetableBtn = findViewById(R.id.vegetableBtn);
        vegetableBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this,Vegetable_Dashboard.class);
                       startActivity(intent);

            }
        });*/

        dataList = findViewById(R.id.dataList);


        images = new ArrayList<>();

        images.add(R.drawable.tomato_item6);
        images.add(R.drawable.cabbage_item8);
        images.add(R.drawable.orange_item5);
        images.add(R.drawable.cucumber_item4);
        images.add(R.drawable.banana_item2);
        images.add(R.drawable.bread_item7);
        images.add(R.drawable.egg_item1);
        images.add(R.drawable.coconut_item3);


        recommendedProductsAdapter = new RecommendedProductsAdapter(this,images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(recommendedProductsAdapter);



    }
}