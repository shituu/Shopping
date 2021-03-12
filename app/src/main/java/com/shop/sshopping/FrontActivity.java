package com.shop.sshopping;
import android.content.Intent;
import android.os.Bundle;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;

import com.google.android.material.navigation.NavigationView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;
import com.shop.sshopping.Model.Products;
import com.shop.sshopping.Model.Users;
import com.shop.sshopping.Prevalent.Prevalent;
import com.shop.sshopping.ViewHolder.ProductViewHolder;
import com.squareup.picasso.Picasso;


import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;
import io.paperdb.Paper;

import android.view.Menu;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class FrontActivity extends AppCompatActivity

{
    private DatabaseReference ProductsRef;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    BottomNavigationView bottomNavigationView;
    ViewFlipper flipper;
    int selectPage = 0;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7;
    ImageView img;

    private static final String NODE_USERS ="users";
    private String type = "";

    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);









        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null)
        {
            type = getIntent().getExtras().get("Admin").toString();
        }
//

        ProductsRef = FirebaseDatabase.getInstance().getReference().child("Products").child("All Products");


        recyclerView = findViewById(R.id.recycler_menu);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

//    private void saveToken(String token) {
//        String phoneNumber = mAuth.getCurrentUser().getPhoneNumber();
//        Users user = new Users(phoneNumber,token);
//
//        DatabaseReference dbUsers = FirebaseDatabase.getInstance().getReference(NODE_USERS);
//        dbUsers.child(mAuth.getCurrentUser().getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//               if(task.isSuccessful())
//               {
//                   Toast.makeText(HomeActivity.this,"Token saved successfully",Toast.LENGTH_LONG).show();
//               }
//            }
//        });
//
//
//    }


    @Override
    protected void onStart()
    {
        super.onStart();


//        if(mAuth.getCurrentUser()==null)
//        {
//            Intent intent = new  Intent(HomeActivity.this,DashboardActivity.class);
//            startActivity(intent);
//
//        }



        FirebaseRecyclerOptions<Products> options =
                new FirebaseRecyclerOptions.Builder<Products>()
                        .setQuery(ProductsRef, Products.class)
                        .build();

        Log.e("options","==="+options);

        FirebaseRecyclerAdapter<Products, ProductViewHolder> adapter = new FirebaseRecyclerAdapter<Products, ProductViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final ProductViewHolder holder, int position, @NonNull final Products model)
            {

                // holder.txtProductName.setText(model.getPname());
                // holder.txtProductDescription.setText(model.getDescription());
                 // holder.txtProductPrice.setText("Price = " + model.getPrice() + "Rs");

                Picasso.get().load(model.getImage()).into(holder.imageView);

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        if (type.equals("Admin"))
                        {
                            Intent intent = new Intent(FrontActivity.this, AdminMaintainProductsActivity.class);
                            intent.putExtra("pid", model.getPid());
                            intent.putExtra("category", model.getCategory());

                            Log.e("cat name","==="+model.getCategory());
                            startActivity(intent);

                        }
                        else
                        {
                            Intent intent = new Intent(FrontActivity.this, ProductDetailsActivity.class);
                            intent.putExtra("pid", model.getPid());
                            intent.putExtra("image",model.getImage());
                            Log.e("Imageeee url","=="+model.getImage());
                            Log.e("shubhi","=="+model.getPid());
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
//
//        if (id == R.id.action_settings)
//        {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }




    }