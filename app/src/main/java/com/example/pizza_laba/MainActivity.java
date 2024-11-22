package com.example.pizza_laba;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Pizza> pizzaList = new ArrayList<>();
        int[] ref_image = {R.drawable.a, R.drawable.b, R.drawable.c,
                R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h,
                R.drawable.i, R.drawable.j, R.drawable.k, R.drawable.l, R.drawable.m};

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("pizza.txt")))) {
            String curLine; int idx = 0;
            while ((curLine = reader.readLine()) != null) {
                StringTokenizer info = new StringTokenizer(curLine, " \t\n\r");
                String name = info.nextToken().replace('_', ' ');
                String weight = info.nextToken() + " г";
                String size = info.nextToken() + " см";
                String price = info.nextToken() + " ₽";
                pizzaList.add(new Pizza(name, weight, size, price, ref_image[idx++]));
            }
        } catch (IOException error) {
            throw new RuntimeException("Error with file 'pizza.txt'", error);
        }

        RecyclerView recyclerView = findViewById(R.id.rc_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CustomAdapter(pizzaList));
    }
}