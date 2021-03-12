package com.shop.sshopping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class AdminMaintainProductsActivity extends AppCompatActivity
{
    private Button applyChangesBtn, deleteBtn;
    private EditText name, price, description;
    private ImageView imageView;

    private String productID = "";
    private DatabaseReference productsRef , productsRef1,productsRef2, productsRef3, productsRef4, productsRef5,productsRef6,productsRef7,productsRef8,productsRef9,productsRef10,productsRef11,productsRef12 ;
    private String CategoryName="";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_maintain_products);

        productID = getIntent().getStringExtra("pid");
        Log.e("Product Id","==="+productID);

        CategoryName = getIntent().getStringExtra("category");
        Log.e("cat Id","==="+CategoryName);


        productsRef = FirebaseDatabase.getInstance().getReference().child("Products").child("All Products").child(productID);
        productsRef1 = FirebaseDatabase.getInstance().getReference().child("Products").child("Teddy").child(productID);
        productsRef2 = FirebaseDatabase.getInstance().getReference().child("Products").child("Couples").child(productID);
        productsRef3 = FirebaseDatabase.getInstance().getReference().child("Products").child("Cups").child(productID);
        productsRef4 = FirebaseDatabase.getInstance().getReference().child("Products").child("Key Chains").child(productID);
        productsRef5 = FirebaseDatabase.getInstance().getReference().child("Products").child("Show Pieces").child(productID);
        productsRef6 = FirebaseDatabase.getInstance().getReference().child("Products").child("Frames").child(productID);
        productsRef7 = FirebaseDatabase.getInstance().getReference().child("Products").child("Paintings").child(productID);
        productsRef8 = FirebaseDatabase.getInstance().getReference().child("Products").child("Watches").child(productID);
        productsRef9 = FirebaseDatabase.getInstance().getReference().child("Products").child("Toys").child(productID);
        productsRef10 = FirebaseDatabase.getInstance().getReference().child("Products").child("Kitchen Sets").child(productID);
        productsRef11 = FirebaseDatabase.getInstance().getReference().child("Products").child("Dolls").child(productID);
        productsRef12 = FirebaseDatabase.getInstance().getReference().child("Products").child("Others").child(productID);

        applyChangesBtn = findViewById(R.id.apply_changes_btn);
        name = findViewById(R.id.product_name_maintain);
        price = findViewById(R.id.product_price_maintain);
        description = findViewById(R.id.product_description_maintain);
        imageView = findViewById(R.id.product_image_maintain);
        deleteBtn = findViewById(R.id.delete_product_btn);

           displaySpecificProductInfo();

        applyChangesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                applyChanges();
            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                deleteThisProduct();
            }
        });
    }
    private void deleteThisProduct() {

        if (CategoryName.equals("Teddy")) {
            productsRef.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {

                        productsRef1.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(AdminMaintainProductsActivity.this, "Product Deleted Successfully.", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });

                    }

                }
            });
        }

        if (CategoryName.equals("Couples")) {
            productsRef.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {

                        productsRef2.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(AdminMaintainProductsActivity.this, "Product Deleted Successfully.", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });

                    }

                }
            });
        }
        if (CategoryName.equals("Cups")) {
            productsRef.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {

                        productsRef3.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(AdminMaintainProductsActivity.this, "Product Deleted Successfully.", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });

                    }

                }
            });
        }

        if (CategoryName.equals("Key Chains")) {
            productsRef.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {

                        productsRef4.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(AdminMaintainProductsActivity.this, "Product Deleted Successfully.", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });

                    }

                }
            });
        }


        if (CategoryName.equals("Show Pieces")) {
            productsRef.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {

                        productsRef5.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(AdminMaintainProductsActivity.this, "Product Deleted Successfully.", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });

                    }

                }
            });
        }


        if (CategoryName.equals("Frames")) {
            productsRef.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {

                        productsRef6.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(AdminMaintainProductsActivity.this, "Product Deleted Successfully.", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });

                    }

                }
            });
        }


        if (CategoryName.equals("Paintings")) {
            productsRef.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {

                        productsRef7.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(AdminMaintainProductsActivity.this, "Product Deleted Successfully.", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });

                    }

                }
            });
        }




        if (CategoryName.equals("Watches")) {
            productsRef.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {

                        productsRef8.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(AdminMaintainProductsActivity.this, "Product Deleted Successfully.", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });

                    }

                }
            });
        }

        if (CategoryName.equals("Toys")) {
            productsRef.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {

                        productsRef9.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(AdminMaintainProductsActivity.this, "Product Deleted Successfully.", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });

                    }

                }
            });
        }

        if (CategoryName.equals("Kitchen Sets")) {
            productsRef.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {

                        productsRef10.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(AdminMaintainProductsActivity.this, "Product Deleted Successfully.", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });

                    }

                }
            });
        }

        if (CategoryName.equals("Doll")) {
            productsRef.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {

                        productsRef11.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(AdminMaintainProductsActivity.this, "Product Deleted Successfully.", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });

                    }

                }
            });
        }

        if (CategoryName.equals("Others")) {
            productsRef.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {

                        productsRef12.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(AdminMaintainProductsActivity.this, "Product Deleted Successfully.", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });

                    }

                }
            });
        }










    }
    private void applyChanges()
    {
        String pName = name.getText().toString();
        String pPrice = price.getText().toString();
        String pDescription = description.getText().toString();
        if (pName.equals(""))
        {
            Toast.makeText(this, "Write down Product Name.", Toast.LENGTH_SHORT).show();
        }
        else if (pPrice.equals(""))
        {
            Toast.makeText(this, "Write down Product Price.", Toast.LENGTH_SHORT).show();
        }
        else if (pDescription.equals(""))
        {
            Toast.makeText(this, "Write down Product Description.", Toast.LENGTH_SHORT).show();
        }
        else {
            final HashMap<String, Object> productMap = new HashMap<>();
//            productMap.put("category",CategoryName);
            productMap.put("pid", productID);
            productMap.put("description", pDescription);
            productMap.put("price", pPrice);
            productMap.put("pname", pName);

            if (CategoryName.equals("Teddy")) {
                productsRef.updateChildren(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            productsRef1.updateChildren(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(AdminMaintainProductsActivity.this, "Changes applied successfully.", Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });

                        }
                    }
                });
            }
            else if (CategoryName.equals("Couples")) {

                productsRef.updateChildren(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            productsRef2.updateChildren(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(AdminMaintainProductsActivity.this, "Changes applied successfully.", Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });
                        }
                    }
                });
            }
          else if (CategoryName.equals("Cups")) {

                productsRef.updateChildren(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            productsRef3.updateChildren(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(AdminMaintainProductsActivity.this, "Changes applied successfully.", Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });

                        }
                    }
                });
          }

            else if (CategoryName.equals("Key Chains")) {

                productsRef.updateChildren(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            productsRef4.updateChildren(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(AdminMaintainProductsActivity.this, "Changes applied successfully.", Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });
//                            Toast.makeText(AdminMaintainProductsActivity.this, "Changes applied successfully.", Toast.LENGTH_SHORT).show();
//
//                            Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
//                            startActivity(intent);
                            //  finish();
                        }
                    }
                });
            }

            else if (CategoryName.equals("Show Pieces")) {

                productsRef.updateChildren(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            productsRef5.updateChildren(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(AdminMaintainProductsActivity.this, "Changes applied successfully.", Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });
//                            Toast.makeText(AdminMaintainProductsActivity.this, "Changes applied successfully.", Toast.LENGTH_SHORT).show();
//
//                            Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
//                            startActivity(intent);
                            //  finish();
                        }
                    }
                });
            }

            else if (CategoryName.equals("Frames")) {

                productsRef.updateChildren(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            productsRef6.updateChildren(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(AdminMaintainProductsActivity.this, "Changes applied successfully.", Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });
//                            Toast.makeText(AdminMaintainProductsActivity.this, "Changes applied successfully.", Toast.LENGTH_SHORT).show();
//
//                            Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
//                            startActivity(intent);
                            //  finish();
                        }
                    }
                });
            }

            else if (CategoryName.equals("Paintings")) {

                productsRef.updateChildren(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            productsRef7.updateChildren(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(AdminMaintainProductsActivity.this, "Changes applied successfully.", Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });
//                            Toast.makeText(AdminMaintainProductsActivity.this, "Changes applied successfully.", Toast.LENGTH_SHORT).show();
//
//                            Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
//                            startActivity(intent);
                            //  finish();
                        }
                    }
                });
            }





            else if (CategoryName.equals("Watches")) {

                productsRef.updateChildren(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            productsRef8.updateChildren(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(AdminMaintainProductsActivity.this, "Changes applied successfully.", Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });
//                            Toast.makeText(AdminMaintainProductsActivity.this, "Changes applied successfully.", Toast.LENGTH_SHORT).show();
//
//                            Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
//                            startActivity(intent);
                            //  finish();
                        }
                    }
                });
            }

            else if (CategoryName.equals("Toys")) {

                productsRef.updateChildren(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            productsRef9.updateChildren(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(AdminMaintainProductsActivity.this, "Changes applied successfully.", Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });
//                            Toast.makeText(AdminMaintainProductsActivity.this, "Changes applied successfully.", Toast.LENGTH_SHORT).show();
//
//                            Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
//                            startActivity(intent);
                            //  finish();
                        }
                    }
                });
            }


            else if (CategoryName.equals("Kitchen Sets")) {

                productsRef.updateChildren(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            productsRef10.updateChildren(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(AdminMaintainProductsActivity.this, "Changes applied successfully.", Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });
//                            Toast.makeText(AdminMaintainProductsActivity.this, "Changes applied successfully.", Toast.LENGTH_SHORT).show();
//
//                            Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
//                            startActivity(intent);
                            //  finish();
                        }
                    }
                });
            }


            else if (CategoryName.equals("Dolls")) {

                productsRef.updateChildren(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            productsRef11.updateChildren(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(AdminMaintainProductsActivity.this, "Changes applied successfully.", Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });
//                            Toast.makeText(AdminMaintainProductsActivity.this, "Changes applied successfully.", Toast.LENGTH_SHORT).show();
//
//                            Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
//                            startActivity(intent);
                            //  finish();
                        }
                    }
                });
            }



            else if (CategoryName.equals("Others")) {

                productsRef.updateChildren(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            productsRef12.updateChildren(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(AdminMaintainProductsActivity.this, "Changes applied successfully.", Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });
//                            Toast.makeText(AdminMaintainProductsActivity.this, "Changes applied successfully.", Toast.LENGTH_SHORT).show();
//
//                            Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminCategoryActivity.class);
//                            startActivity(intent);
                            //  finish();
                        }
                    }
                });
            }





        }
        }
    private void displaySpecificProductInfo()
    {
        productsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                if (dataSnapshot.exists())
                {
                    String pName = dataSnapshot.child("pname").getValue().toString();
                    String pPrice = dataSnapshot.child("price").getValue().toString();
                    String pDescription = dataSnapshot.child("description").getValue().toString();
                    String pImage = dataSnapshot.child("image").getValue().toString();

                    name.setText(pName);
                    price.setText(pPrice);
                    description.setText(pDescription);
                    Picasso.get().load(pImage).into(imageView);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        }
    }

