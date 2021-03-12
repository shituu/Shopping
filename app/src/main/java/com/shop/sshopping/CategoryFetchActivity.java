package com.shop.sshopping;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.shop.sshopping.Model.Products;
import com.shop.sshopping.ViewHolder.ProductViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.paperdb.Paper;

public class CategoryFetchActivity extends AppCompatActivity {


    private DatabaseReference ProductsRef;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;


    private String type = "";
    String teddy,couples,toys,cups,keychain, showpiece, frames, paintings , watches, doll, kitchenset,others;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_fetch);

        Intent intent1 = getIntent();
        teddy = intent1.getStringExtra("category");

        Intent intent2 = getIntent();
        couples = intent2.getStringExtra("category");

        Intent intent3 = getIntent();
        toys = intent3.getStringExtra("category");

        Intent intent4 = getIntent();
        cups = intent4.getStringExtra("category");

        Intent intent5 = getIntent();
        keychain = intent5.getStringExtra("category");

        Intent intent6 = getIntent();
        showpiece = intent6.getStringExtra("category");

        Intent intent7 = getIntent();
        frames = intent7.getStringExtra("category");

        Intent intent8 = getIntent();
        paintings = intent8.getStringExtra("category");

        Intent intent9 = getIntent();
        watches = intent9.getStringExtra("category");

        Intent intent10 = getIntent();
        doll = intent10.getStringExtra("category");

        Intent intent11 = getIntent();
        kitchenset= intent11.getStringExtra("category");

        Intent intent12 = getIntent();
        others = intent12.getStringExtra("category");



        ProductsRef = FirebaseDatabase.getInstance().getReference().child("Products").child(teddy);
        ProductsRef = FirebaseDatabase.getInstance().getReference().child("Products").child(couples);
        ProductsRef = FirebaseDatabase.getInstance().getReference().child("Products").child(toys);
        ProductsRef = FirebaseDatabase.getInstance().getReference().child("Products").child(cups);
        ProductsRef = FirebaseDatabase.getInstance().getReference().child("Products").child(keychain);
        ProductsRef = FirebaseDatabase.getInstance().getReference().child("Products").child(showpiece);
        ProductsRef = FirebaseDatabase.getInstance().getReference().child("Products").child(frames);
        ProductsRef = FirebaseDatabase.getInstance().getReference().child("Products").child(paintings);
        ProductsRef = FirebaseDatabase.getInstance().getReference().child("Products").child(watches);
        ProductsRef = FirebaseDatabase.getInstance().getReference().child("Products").child(doll);
        ProductsRef = FirebaseDatabase.getInstance().getReference().child("Products").child(kitchenset);
        ProductsRef = FirebaseDatabase.getInstance().getReference().child("Products").child(others);


        recyclerView = findViewById(R.id.recycler_menu1);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }


    @Override
    protected void onStart()
    {
        super.onStart();

        FirebaseRecyclerOptions<Products> options =
                new FirebaseRecyclerOptions.Builder<Products>()
                        .setQuery(ProductsRef, Products.class)
                        .build();

        Log.e("options","==="+options);

        FirebaseRecyclerAdapter<Products, ProductViewHolder> adapter = new FirebaseRecyclerAdapter<Products, ProductViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final ProductViewHolder holder, int position, @NonNull final Products model)
            {

              //  holder.txtProductName.setText(model.getPname());
               // holder.txtProductDescription.setText(model.getDescription());
              //  holder.txtProductPrice.setText("Price = " + model.getPrice() + "Rs");

                Picasso.get().load(model.getImage()).into(holder.imageView);



                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        if (type.equals("Admin"))
                        {
                            Intent intent = new Intent(CategoryFetchActivity.this, AdminMaintainProductsActivity.class);
                            intent.putExtra("pid", model.getPid());
                            startActivity(intent);

//                            Intent intent1 = new Intent(CategoryFetchActivity.this, AdminMaintainProductsActivity.class);
//                            intent1.putExtra("category", model.getCategory());
//                            startActivity(intent1);


                        }
                        else
                        {
                            Intent intent = new Intent(CategoryFetchActivity.this, ProductDetailsActivity.class);
                            intent.putExtra("pid", model.getPid());
                            intent.putExtra("image",model.getImage());
                            Log.e("Imageeee ","=="+model.getImage());
                            startActivity(intent);
                        }
                    }
                });

            }

            @NonNull
            @Override
            public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
            {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_items_layout, parent, false);
                ProductViewHolder holder = new ProductViewHolder(view);
                return holder;
            }
        };

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
       recyclerView.setAdapter(adapter);
        adapter.startListening();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);


            super.onBackPressed();

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

//        if (id == R.id.action_settings)
//        {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }



    @SuppressWarnings("StatementWithEmptyBody")
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_cart)
        {
            if (!type.equals("Admin"))
            {
//                Intent intent = new Intent(HomeActivity.this, CartActivity.class);
//                startActivity(intent);
            }
        }
        else if (id == R.id.nav_search)
        {
            if (!type.equals("Admin"))
            {
//                Intent intent = new Intent(HomeActivity.this, SearchProductsActivity.class);
//                startActivity(intent);
            }
        }
        else if (id == R.id.nav_categories)
        {
//            Intent intent = new Intent(HomeActivity.this, CategoryActivity.class);
//            startActivity(intent);
        }
//        else if (id == R.id.nav_settings)
//        {
//            if (!type.equals("Admin"))
//            {
//                Intent intent = new Intent(HomeActivity.this, SettinsActivity.class);
//                startActivity(intent);
//            }
//        }
        else if (id == R.id.nav_logout)
        {
            if (!type.equals("Admin"))
            {
                Paper.book().destroy();
//
//                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(intent);
//                finish();
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}




