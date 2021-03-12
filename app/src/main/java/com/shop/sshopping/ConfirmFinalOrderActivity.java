package com.shop.sshopping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.shop.sshopping.Prevalent.Prevalent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class ConfirmFinalOrderActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "CHANNEL_ID";
    private static final String TAG = "main";

    private CheckBox checkBox1, checkBox2;


    private static final int PERMISSION_REQUEST_CODE = 1;
    private EditText nameEditText, phoneEditText, addressEditText, cityEditText;
    private Button confirmOrderBtn, btn;
    TextView txt, txt1;
    private String totalAmount = "";
    String value;
    final int UPI_PAYMENT = 0;
    public static final boolean IS_PATM_STAGIN = Boolean.parseBoolean("true");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_final_order);


        //btn = findViewById(R.id.btn_kropay);


        value = getIntent().getStringExtra("Price");
        Log.e("Yohh", "====" + value);


        txt1 = findViewById(R.id.txt_for_cart);



        totalAmount = getIntent().getStringExtra("Total Price");
        Log.e("uuuuluuu", "====" + totalAmount);
        txt1.setText(totalAmount);

        //  paytm = PaymentMethodDialog.findViewById(R.id.paytm_btn);
        checkBox1 = findViewById(R.id.check_box1);
        checkBox2 = findViewById(R.id.check_box2);
        confirmOrderBtn = (Button) findViewById(R.id.confirm_final_order_btn);
        nameEditText = (EditText) findViewById(R.id.shippment_name);
        phoneEditText = (EditText) findViewById(R.id.shippment_phone_number);
        addressEditText = (EditText) findViewById(R.id.shippment_address);
        cityEditText = (EditText) findViewById(R.id.shippment_city);


        confirmOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox2.isChecked()) {
                    payUsingUpi();
                }
                else if(checkBox1.isChecked())
                {

                    Check();
                    notification();
                }

            }

        });






//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                // PaymentMethodDialog.dismiss();
//                if (ContextCompat.checkSelfPermission(ConfirmFinalOrderActivity.this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
//                    ActivityCompat.requestPermissions(ConfirmFinalOrderActivity.this, new String[]{Manifest.permission.READ_SMS, Manifest.permission.RECEIVE_SMS}, 101);
//                }
//
//                final String M_id = "jQZuUY51326027069846";
//                final String customer_id = UUID.randomUUID().toString().substring(0, 10);
//                //  final String customer_id ="8085575052";
//
//                final String order_id = UUID.randomUUID().toString().substring(0, 28);
//                Log.e("customer_id", "===" + customer_id);
//                Log.e("Order", "===" + order_id);
//
//                String url = "https://shrashtigiftgallery.000webhostapp.com/paytm/generateChecksum.php";
//
//                //  String url = "https://www.blueappsoftware.com/payment/payment_paytm/generateChecksum.php";
//
//                final String callBack = "https://pguat.paytm.com/paytmchecksum/paytmCallback.jsp";
//
//
//                //syntax    // final String callBack = "https://merchant.com/pguat.paytm.com/paytmchecksum/paytmCallback.jsp";
//
//                // project //    final String callBack = "https://securegw-stage.paytm.in/theia/paytmCallback?Order_ID=%s";
//
//                RequestQueue requestQueue = Volley.newRequestQueue(ConfirmFinalOrderActivity.this);
//                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
//
//                    @Override
//                    public void onResponse(String response) {
//
//                        try {
//                            JSONObject jsonObject = new JSONObject(response);
//                            Log.e("yukti", "===" + response);
//                            if (jsonObject.has("CHECKSUMHASH")) {
//                                String CHECKSUMHASH = jsonObject.getString("CHECKSUMHASH");
//
////                                PaytmPGService paytmPGService = PaytmPGService.getStagingService();
//                                PaytmPGService paytmPGService = IS_PATM_STAGIN ? PaytmPGService.getStagingService() : PaytmPGService.getProductionService();
//
//                                HashMap<String, String> paramMap = new HashMap<String, String>();
//
//                                paramMap.put("MID", M_id);
//                                Log.e("ohoo", "===" + M_id);
//
//                                paramMap.put("ORDER_ID", order_id);
//                                Log.e("yahoooooo", "===" + order_id);
//
//                                paramMap.put("CUST_ID", customer_id);
//                                Log.e("sebduu", "===" + customer_id);
//                                // paramMap.put( "MOBILE_NO" , "8085575052");
//
//                                paramMap.put("CHANNEL_ID", "WAP");
//
//                                paramMap.put("TXN_AMOUNT", txt1.getText().toString().substring(0, txt1.getText().length()));
//
//                                paramMap.put("WEBSITE", "WEBSTAGING");
//
//                                paramMap.put("INDUSTRY_TYPE_ID", "Retail");
//
//                                paramMap.put("CALLBACK_URL", callBack);
//                                Log.e("shitu", "===" + callBack);
//
//                                paramMap.put("CHECKSUMHASH", CHECKSUMHASH);
//                                Log.e("Check", "===" + CHECKSUMHASH);
//
//                                PaytmOrder order = new PaytmOrder(paramMap);
//                                paytmPGService.initialize(order, null);
//                                Log.e("checksum ", "param " + paramMap.toString());
//
//                                paytmPGService.startPaymentTransaction(ConfirmFinalOrderActivity.this, true, true, new PaytmPaymentTransactionCallback() {
//                                    @Override
//                                    public void onTransactionResponse(Bundle inResponse) {
//
//                                        Log.e("Data", "==" + inResponse.toString());
//                                        Toast.makeText(getApplicationContext(), "Payment Transaction response " + inResponse.toString(), Toast.LENGTH_LONG).show();
//                                    }
//
//                                    @Override
//                                    public void networkNotAvailable() {
//
//                                        Toast.makeText(getApplicationContext(), "Network connection error: Check your internet connectivity", Toast.LENGTH_LONG).show();
//
//                                    }
//
//                                    @Override
//                                    public void clientAuthenticationFailed(String inErrorMessage) {
//
//                                        Toast.makeText(getApplicationContext(), "Authentication failed: Server error" + inErrorMessage.toString(), Toast.LENGTH_LONG).show();
//                                    }
//
//                                    @Override
//                                    public void someUIErrorOccurred(String inErrorMessage) {
//
//                                        Toast.makeText(getApplicationContext(), "UI Error " + inErrorMessage, Toast.LENGTH_LONG).show();
//                                    }
//
//                                    @Override
//                                    public void onErrorLoadingWebPage(int iniErrorCode, String inErrorMessage, String inFailingUrl) {
//
//                                        Toast.makeText(getApplicationContext(), "Unable to load webpage " + inErrorMessage.toString(), Toast.LENGTH_LONG).show();
//
//                                    }
//
//                                    @Override
//                                    public void onBackPressedCancelTransaction() {
//
//                                        Toast.makeText(getApplicationContext(), "Transaction cancelled", Toast.LENGTH_LONG).show();
//
//                                    }
//
//                                    @Override
//                                    public void onTransactionCancel(String inErrorMessage, Bundle inResponse) {
//
//                                        Toast.makeText(getApplicationContext(), "Transaction cancelled" + inResponse.toString(), Toast.LENGTH_LONG).show();
//
//                                    }
//                                });
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.d("yohoo", "onErrorResponse: " + error.getMessage());
//                        Toast.makeText(ConfirmFinalOrderActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
//                    }
//                }) {
//                    @Override
//                    protected Map<String, String> getParams() throws AuthFailureError {
//                        Map<String, String> paramMap = new HashMap<String, String>();
//                        paramMap.put("MID", M_id);
//// Key in your staging and production MID available in your dashboard
//                        paramMap.put("ORDER_ID", order_id);
//                        paramMap.put("CUST_ID", customer_id);
//                        // paramMap.put( "MOBILE_NO" , "8085575052");
//                        paramMap.put("CHANNEL_ID", "WAP");
//                        paramMap.put("TXN_AMOUNT", txt1.getText().toString().substring(0, txt1.getText().length()));
//                        paramMap.put("WEBSITE", "WEBSTAGING");
//// This is the staging value. Production value is available in your dashboard
//                        paramMap.put("INDUSTRY_TYPE_ID", "Retail");
//// This is the staging value. Production value is available in your dashboard
//                        paramMap.put("CALLBACK_URL", callBack);
//                        return paramMap;
//                    }
//                };
//                requestQueue.add(stringRequest);
//            }
//        });
    }


    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    private void payUsingUpi() {

        String name = "Rajesh Pal";
        String upiId  = "pal.rajesh212121@okaxis";
        String amount = txt1.getText().toString().substring(0, txt1.getText().length());

        Log.e("main ", "name "+name +"--up--"+upiId+"--"+amount);
        Uri uri = Uri.parse("upi://pay").buildUpon()
                .appendQueryParameter("pa", upiId)
                .appendQueryParameter("pn", name)
                //.appendQueryParameter("mc", "")
                //.appendQueryParameter("tid", "02125412")
                //.appendQueryParameter("tr", "25584584")
                // .appendQueryParameter("tn", note)
                .appendQueryParameter("am", amount)
                .appendQueryParameter("cu", "INR")
                //.appendQueryParameter("refUrl", "blueapp")
                .build();


        Intent upiPayIntent = new Intent(Intent.ACTION_VIEW);
        upiPayIntent.setData(uri);

        // will always show a dialog to user to choose an app
        Intent chooser = Intent.createChooser(upiPayIntent, "Pay with");

        // check if intent resolves
        if(null != chooser.resolveActivity(getPackageManager())) {
            startActivityForResult(chooser, UPI_PAYMENT);
        } else {
            Toast.makeText(ConfirmFinalOrderActivity.this,"No UPI app found, please install one to continue",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("main ", "response "+resultCode );
        /*
       E/main: response -1
       E/UPI: onActivityResult: txnId=AXI4a3428ee58654a938811812c72c0df45&responseCode=00&Status=SUCCESS&txnRef=922118921612
       E/UPIPAY: upiPaymentDataOperation: txnId=AXI4a3428ee58654a938811812c72c0df45&responseCode=00&Status=SUCCESS&txnRef=922118921612
       E/UPI: payment successfull: 922118921612
         */
        switch (requestCode) {
            case UPI_PAYMENT:
                if ((RESULT_OK == resultCode) || (resultCode == 11)) {
                    if (data != null) {
                        String trxt = data.getStringExtra("response");
                        Log.e("UPI", "onActivityResult: " + trxt);
                        ArrayList<String> dataList = new ArrayList<>();
                        dataList.add(trxt);
                        upiPaymentDataOperation(dataList);
                    } else {
                        Log.e("UPI", "onActivityResult: " + "Return data is null");
                        ArrayList<String> dataList = new ArrayList<>();
                        dataList.add("nothing");
                        upiPaymentDataOperation(dataList);
                    }
                } else {
                    //when user simply back without payment
                    Log.e("UPI", "onActivityResult: " + "Return data is null");
                    ArrayList<String> dataList = new ArrayList<>();
                    dataList.add("nothing");
                    upiPaymentDataOperation(dataList);
                }
                break;
        }
    }

    private void upiPaymentDataOperation(ArrayList<String> data) {
        if (isConnectionAvailable(ConfirmFinalOrderActivity.this)) {
            String str = data.get(0);
            Log.e("UPIPAY", "upiPaymentDataOperation: "+str);
            String paymentCancel = "";
            if(str == null) str = "discard";
            String status = "";
            String approvalRefNo = "";
            String response[] = str.split("&");
            for (int i = 0; i < response.length; i++) {
                String equalStr[] = response[i].split("=");
                if(equalStr.length >= 2) {
                    if (equalStr[0].toLowerCase().equals("Status".toLowerCase())) {
                        status = equalStr[1].toLowerCase();
                    }
                    else if (equalStr[0].toLowerCase().equals("ApprovalRefNo".toLowerCase()) || equalStr[0].toLowerCase().equals("txnRef".toLowerCase())) {
                        approvalRefNo = equalStr[1];
                    }
                }
                else {
                    paymentCancel = "Payment cancelled by user.";
                }
            }

            if (status.equals("success")) {
                //Code to handle successful transaction here.
                Toast.makeText(ConfirmFinalOrderActivity.this, "Transaction successful.", Toast.LENGTH_SHORT).show();
                Log.e("UPI", "payment successfull: "+approvalRefNo);
                Check();
                notification();
            }
            else if("Payment cancelled by user.".equals(paymentCancel)) {
                Toast.makeText(ConfirmFinalOrderActivity.this, "Payment cancelled by user.", Toast.LENGTH_SHORT).show();
                Log.e("UPI", "Cancelled by user: "+approvalRefNo);

            }
            else {
                Toast.makeText(ConfirmFinalOrderActivity.this, "Transaction failed.Please try again", Toast.LENGTH_SHORT).show();
                Log.e("UPI", "failed payment: "+approvalRefNo);

            }
        } else {
            Log.e("UPI", "Internet issue: ");

            Toast.makeText(ConfirmFinalOrderActivity.this, "Internet connection is not available. Please check and try again", Toast.LENGTH_SHORT).show();
        }
    }

    public static boolean isConnectionAvailable(ConfirmFinalOrderActivity context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnected()
                    && netInfo.isConnectedOrConnecting()
                    && netInfo.isAvailable()) {
                return true;
            }
        }
        return false;
    }


    private void notification() {


        String name = nameEditText.getText().toString();
        String message = "your Order has been placed successfully..!!";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel =
                    new NotificationChannel("n", "n", NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "n")
                .setContentText("Shrashti Gift Gallery")
                .setSmallIcon(R.drawable.ic_final_logo_noti_foreground)
                .setAutoCancel(true)
                .setContentText(message);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(999, builder.build());
    }


    private void Check() {
        if (TextUtils.isEmpty(nameEditText.getText().toString())) {
            Toast.makeText(this, "Please provide your full name.", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(phoneEditText.getText().toString())) {
            Toast.makeText(this, "Please provide your phone number.", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(addressEditText.getText().toString())) {
            Toast.makeText(this, "Please provide your address.", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(cityEditText.getText().toString())) {
            Toast.makeText(this, "Please provide your city name.", Toast.LENGTH_SHORT).show();
        }
//        else if (checkBox1.isEmpty())
//        {
//            Toast.makeText(this, "check kro.", Toast.LENGTH_SHORT).show();
//        }
//        else if (checkBox2.isChecked())
//        {
//            Toast.makeText(this, "check kro na..", Toast.LENGTH_SHORT).show();
//        }
        else {
            ConfirmOrder();

        }
    }

    private void ConfirmOrder() {
        final String saveCurrentDate, saveCurrentTime;
        final String payment;

        Calendar calForDate = Calendar.getInstance();
        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
        saveCurrentDate = currentDate.format(calForDate.getTime());
        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentTime.format(calForDate.getTime());

        if(checkBox1.isChecked())
        {
            payment = checkBox1.getText().toString();
        }
        else
        {
            payment = checkBox2.getText().toString();
        }

        final DatabaseReference ordersRef = FirebaseDatabase.getInstance().getReference()
                .child("Orders")
              //  .child(Prevalent.currentOnlineUser.getPhone());
        .child(Prevalent.CurrentOnlineUser.getPhoneNumber());

        HashMap<String, Object> ordersMap = new HashMap<>();
        ordersMap.put("totalAmount", totalAmount);
        ordersMap.put("name", nameEditText.getText().toString());
        ordersMap.put("phone", phoneEditText.getText().toString());
        ordersMap.put("address", addressEditText.getText().toString());
        ordersMap.put("city", cityEditText.getText().toString());
        ordersMap.put("paymentmode",payment);
        Log.e("MODE","=="+payment);
        ordersMap.put("date", saveCurrentDate);
        ordersMap.put("time", saveCurrentTime);
        ordersMap.put("state", "not shipped");

//        Intent intent = new Intent(ConfirmFinalOrderActivity.this,AdminNewOrdersActivity.class);
//        intent.putExtra("payment", payment);
//       startActivity(intent);

        ordersRef.updateChildren(ordersMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    FirebaseDatabase.getInstance().getReference()
                            .child("Cart List")
                            .child("User View")
                           // .child(Prevalent.currentOnlineUser.getPhone())
                            .child(Prevalent.CurrentOnlineUser.getPhoneNumber())
                            .removeValue()
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {

                                        Toast.makeText(ConfirmFinalOrderActivity.this, "your final order has been placed successfully.", Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(ConfirmFinalOrderActivity.this, DeliveryActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(intent);

                                    }
                                }
                            });
                }
            }
        });



        }
    }








