package com.example.grohub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.grohub.adapter.RecommendedProductsAdapter;
import com.example.grohub.adapter.VegetableItemsAdapter;

import java.util.ArrayList;
import java.util.List;

public class Vegetable_Dashboard extends AppCompatActivity {

    RecyclerView dataList1;
    List<Integer> images1;
    VegetableItemsAdapter vegetableItemsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        dataList1 = findViewById(R.id.datalist1);
        images1 = new ArrayList<>();

        images1.add(R.drawable.cucumber_item4);
        images1.add(R.drawable.tomato_item6);
        images1.add(R.drawable.cabbage_item8);
        images1.add(R.drawable.ladyfinger_item10);
        images1.add(R.drawable.potato_item11);
        images1.add(R.drawable.peas_item12);
        images1.add(R.drawable.onion_item13);
        images1.add(R.drawable.raddish_item14);
        images1.add(R.drawable.bellpepper_item15);
        images1.add(R.drawable.green_chilli_item16);
        images1.add(R.drawable.cauliflower_item17);
        images1.add(R.drawable.brocolli_item18);
        images1.add(R.drawable.green_onion_item19);

        vegetableItemsAdapter = new VegetableItemsAdapter(this,images1);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        dataList1.setLayoutManager(gridLayoutManager);
        dataList1.setAdapter(vegetableItemsAdapter);






    }
}