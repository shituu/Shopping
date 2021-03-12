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
import androidx.cardview.widget.CardView;
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

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{
    private DatabaseReference ProductsRef;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    BottomNavigationView bottomNavigationView;
    ViewFlipper flipper;
    int selectPage = 0;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    ImageView img;
    CardView card1,card2,card3;

 private static final String NODE_USERS ="users";
 private String type = "";

    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn_featur);
        btn9 = findViewById(R.id.btn_new);
        card1 = findViewById(R.id.cardview1);



        img = findViewById(R.id.imgcart);


        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CategoryFetchActivity.class);
                intent.putExtra("category", "Show Pieces");
                startActivity(intent);

            }
        });

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,CartActivity.class);
                startActivity(intent);
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(HomeActivity.this, CategoryFetchActivity.class);
                intent.putExtra("category", "Teddy");
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(HomeActivity.this, CategoryFetchActivity.class);
                intent.putExtra("category", "Toys");
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(HomeActivity.this, CategoryFetchActivity.class);
                intent.putExtra("category", "Cups");
                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(HomeActivity.this, CategoryFetchActivity.class);
                intent.putExtra("category", "Couples");
                startActivity(intent);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(HomeActivity.this, CategoryFetchActivity.class);
                intent.putExtra("category", "Frames");
                startActivity(intent);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(HomeActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareBody = "Download the app now to explore a wide range of products ✨✨✨, Surprise your loved ones with 1000+ range of products on just a click away : https://play.google.com/store/apps/details?id=com.shop.sshopping&hl=en_IN&hl=en";
                String sharesub = "App";

                intent.putExtra(Intent.EXTRA_SUBJECT,sharesub);
                intent.putExtra(Intent.EXTRA_TEXT,shareBody);

                startActivity(Intent.createChooser(intent,"Share Using"));

            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,FrontActivity.class);
                startActivity(intent);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,FrontActivity.class);
                startActivity(intent);
            }
        });


        int imgarray[]={R.drawable.welcome,R.drawable.shopimage,R.drawable.loo,R.drawable.buy,R.drawable.two,R.drawable.laa,R.drawable.trehe,
                R.drawable.dolly,R.drawable.molly,R.drawable.haapy,R.drawable.bag,R.drawable.rose,R.drawable.sgg,R.drawable.cart,R.drawable.offer};
        flipper=(ViewFlipper) findViewById(R.id.flio);
        for(int i=0;i<imgarray.length;i++)
            showImage(imgarray[i]);


        int imgarray1[]={R.drawable.salesix,R.drawable.saleone,R.drawable.saletwo,R.drawable.salethree,R.drawable.salefour,R.drawable.salefive,R.drawable.salesix,
                R.drawable.saleseven,R.drawable.saleeleven,R.drawable.saletwelve,R.drawable.salethirteen,R.drawable.salesnine,R.drawable.saleten,R.drawable.salesix,R.drawable.salefive};
        flipper=(ViewFlipper) findViewById(R.id.flier2);
        for(int i=0;i<imgarray1.length;i++)
            showImagee(imgarray1[i]);

        int imgarray2[]={R.drawable.welcome,R.drawable.shopimage,R.drawable.loo,R.drawable.buy,R.drawable.two,R.drawable.laa,R.drawable.trehe,
                R.drawable.dolly,R.drawable.molly,R.drawable.haapy,R.drawable.bag,R.drawable.rose,R.drawable.sgg,R.drawable.cart,R.drawable.offer};
        flipper=(ViewFlipper) findViewById(R.id.flier3);
        for(int i=0;i<imgarray2.length;i++)
            showImageee(imgarray2[i]);

      //  bottomNavigationView=findViewById(R.id.bottom_navigation);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null)
        {
            type = getIntent().getExtras().get("Admin").toString();
        }
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                switch(menuItem.getItemId())
//                {
//                    case R.id.menu_1:
//                        Intent intent1 = new Intent(HomeActivity.this,HomeActivity.class);
//                        startActivity(intent1);
//                        break;
//                    case R.id.menu_2:
//                        Intent intent2 = new Intent(HomeActivity.this,CartActivity.class);
//                        startActivity(intent2);
//                        break;
//                    case R.id.menu_3:
//                        Intent intent3 = new Intent(HomeActivity.this,SearchProductsActivity.class);
//                        startActivity(intent3);
//                        break;
//                    case R.id.menu_4:
//                        Intent intent4 = new Intent(HomeActivity.this,CategoryActivity.class);
//                        startActivity(intent4);
//                        break;
//                }
//                return true;
//            }
//        });


     //   ProductsRef = FirebaseDatabase.getInstance().getReference().child("Products").child("All Products");

        // Paper.init(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Welcome..");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);
        TextView userNameTextView = headerView.findViewById(R.id.user_profile_name);
        CircleImageView profileImageView = headerView.findViewById(R.id.user_profile_image);


//        if (!type.equals("Admin"))
//        {
//            userNameTextView.setText(Prevalent.currentOnlineUser.getName());
//            Picasso.get().load(Prevalent.currentOnlineUser.getImage()).placeholder(R.drawable.profile).into(profileImageView);
//        }
//        recyclerView = findViewById(R.id.recycler_menu);
//        recyclerView.setHasFixedSize(true);
//        layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
    }

    private void showImageee(int img2) {

        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(img2);
        flipper.addView(imageView);
        flipper.setFlipInterval(2000);
        flipper.setAutoStart(true);
    }

    private void showImagee(int img1) {

        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(img1);
        flipper.addView(imageView);
        flipper.setFlipInterval(2000);
        flipper.setAutoStart(true);
    }

    private void showImage(int img) {
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(img);
        flipper.addView(imageView);
        flipper.setFlipInterval(2000);
        flipper.setAutoStart(true);
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
              //  holder.txtProductPrice.setText("Price = " + model.getPrice() + "Rs");

                Picasso.get().load(model.getImage()).into(holder.imageView);

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        if (type.equals("Admin"))
                        {
                            Intent intent = new Intent(HomeActivity.this, AdminMaintainProductsActivity.class);
                            intent.putExtra("pid", model.getPid());
                            intent.putExtra("category", model.getCategory());

                            Log.e("cat name","==="+model.getCategory());
                            startActivity(intent);

                        }
                        else
                        {
                            Intent intent = new Intent(HomeActivity.this, ProductDetailsActivity.class);
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
//        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
//        recyclerView.setAdapter(adapter);
//        adapter.startListening();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

//        AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this)
//                .setTitle("Exit")
//                .setCancelable(false)
//                .setMessage("Are your sure you want to exit?")
//                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        ActivityCompat.finishAffinity(HomeActivity.this);
//                    }
//                })
//                .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        dialogInterface.cancel();
//                    }
//                });
//
//        builder.show();

        }
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



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_cart)
        {
            if (!type.equals("Admin"))
            {
                Intent intent = new Intent(HomeActivity.this, CartActivity.class);
                startActivity(intent);
            }
        }
        else if (id == R.id.nav_search)
        {
            if (!type.equals("Admin"))
            {
                Intent intent = new Intent(HomeActivity.this, SearchProductsActivity.class);
                startActivity(intent);
            }
        }
        else if (id == R.id.nav_categories)
        {
            Intent intent = new Intent(HomeActivity.this, CategoryActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_settings)
        {
            if (!type.equals("Admin"))
            {
                Intent intent = new Intent(HomeActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        }
        else if (id == R.id.nav_call)
        {
            if (!type.equals("Admin"))
            {
                Intent intent = new Intent(HomeActivity.this, CallActivity.class);
                startActivity(intent);
            }
        }
        else if (id == R.id.nav_orders)
        {
            if (!type.equals("Admin"))
            {
                Intent intent = new Intent(HomeActivity.this, MyOrdersActivity.class);
                startActivity(intent);
            }
        }
        else if (id == R.id.nav_logout)
        {
            if (!type.equals("Admin"))
            {

                Intent intent = new Intent(HomeActivity.this, DashboardActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        }
        else if (id == R.id.nav_seller)
        {
            if (!type.equals("Admin"))
            {

                Intent intent = new Intent(HomeActivity.this, SellerActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}