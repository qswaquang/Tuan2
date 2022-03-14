package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Food> foodList = new ArrayList<Food>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        listView.setAdapter(new ListFoodAdapter(this, foodList, R.layout.list_item));

        listView.setOnItemClickListener((new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Food food = (Food) listView.getItemAtPosition(i);
                Log.d("lala", "onItemClick: "+ food.getDescription());
            }
        }));
    }

    private void init() {
        listView = findViewById(R.id.listFood);

        Food food1 = new Food("food1", "ngon", "231$", R.drawable.donut_red);
        Food food2 = new Food("food2", "dỡ", "999$", R.drawable.donut_yellow);
        Food food3 = new Food("food3", "siêu ngon", "123$", R.drawable.green_donut);
        Food food4 = new Food("food4", "rất dỡ", "234$", R.drawable.tasty_donut);

        foodList.add(food1);
        foodList.add(food2);
        foodList.add(food3);
        foodList.add(food4);
    }
}