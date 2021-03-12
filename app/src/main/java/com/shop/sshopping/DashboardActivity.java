package com.shop.sshopping;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class DashboardActivity extends AppCompatActivity {

    CardView cardView, cardView1, cardView2 , cardView3;
    ViewFlipper flipper;
    int selectPage = 0;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

         txt = findViewById(R.id.txt_admin);
         txt.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent (DashboardActivity.this,LoginActivity.class);
             startActivity(intent);
             }
         });





        cardView = findViewById(R.id.card1);
        cardView1 =  findViewById(R.id.card2);
        cardView2 =  findViewById(R.id.card3);
        cardView3 =  findViewById(R.id.card4);



        int imgarray[]={R.drawable.welcome,R.drawable.shopimage,R.drawable.flashdeals,R.drawable.flower,R.drawable.projectpainting,R.drawable.projectbudha,R.drawable.girlwithcart,
                R.drawable.projectshowpiece,R.drawable.projectcouples,R.drawable.haapy};
        flipper=(ViewFlipper) findViewById(R.id.flipper);
        for(int i=0;i<imgarray.length;i++)
            showImage(imgarray[i]);



        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DashboardActivity.this,HomeActivity.class);
                startActivity(intent);

            }
        });


        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DashboardActivity.this,SettingsActivity.class);
                startActivity(intent);

            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DashboardActivity.this,CategoryActivity.class);
                startActivity(intent);

            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DashboardActivity.this,CallActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public void onBackPressed()
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(DashboardActivity.this)
                .setTitle("Exit")
                .setCancelable(false)
                .setMessage("Are your sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.finishAffinity(DashboardActivity.this);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        builder.show();

    }

    private void showImage(int img) {
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(img);
        flipper.addView(imageView);
        flipper.setFlipInterval(2000);
        flipper.setAutoStart(true);
    }
}
