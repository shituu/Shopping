package com.shop.sshopping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class CategoryActivity extends AppCompatActivity {

    CardView btn, btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        btn = findViewById(R.id.btn_teddy);
        btn1 = findViewById(R.id.btn_couples);
        btn2 = findViewById(R.id.btn_toys);

        btn3 = findViewById(R.id.btn_cups);
        btn4 = findViewById(R.id.btn_windchains);
        btn5 = findViewById(R.id.btn_showpieces);

        btn6 = findViewById(R.id.btn_frames);
        btn7 = findViewById(R.id.btn_paintings);
        btn8 = findViewById(R.id.btn_watch);

        btn9 = findViewById(R.id.btn_cars);
        btn10 = findViewById(R.id.btn_kitchen);
        btn11 = findViewById(R.id.btn_others);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(CategoryActivity.this, CategoryFetchActivity.class);
                intent.putExtra("category", "Teddy");
                startActivity(intent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(CategoryActivity.this, CategoryFetchActivity.class);
                intent.putExtra("category", "Couples");
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(CategoryActivity.this, CategoryFetchActivity.class);
                intent.putExtra("category", "Toys");
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(CategoryActivity.this, CategoryFetchActivity.class);
                intent.putExtra("category", "Cups");
                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(CategoryActivity.this, CategoryFetchActivity.class);
                intent.putExtra("category", "Key Chains");
                startActivity(intent);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(CategoryActivity.this, CategoryFetchActivity.class);
                intent.putExtra("category", "Show Pieces");
                startActivity(intent);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(CategoryActivity.this, CategoryFetchActivity.class);
                intent.putExtra("category", "Frames");
                startActivity(intent);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(CategoryActivity.this, CategoryFetchActivity.class);
                intent.putExtra("category", "Paintings");
                startActivity(intent);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(CategoryActivity.this, CategoryFetchActivity.class);
                intent.putExtra("category", "Watches");
                startActivity(intent);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(CategoryActivity.this, CategoryFetchActivity.class);
                intent.putExtra("category", "Doll");
                startActivity(intent);
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(CategoryActivity.this, CategoryFetchActivity.class);
                intent.putExtra("category", "Kitchen Sets");
                startActivity(intent);
            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(CategoryActivity.this, CategoryFetchActivity.class);
                intent.putExtra("category", "Others");
                startActivity(intent);
            }
        });

    }
}