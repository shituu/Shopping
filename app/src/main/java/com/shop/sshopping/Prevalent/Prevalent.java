package com.shop.sshopping.Prevalent;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.shop.sshopping.Model.Users;

public class Prevalent
{
    //public static Users currentOnlineUser;

    public static FirebaseUser CurrentOnlineUser = FirebaseAuth.getInstance().getCurrentUser();

    public static final String UserPhoneKey = "UserPhone";
    public static final String UserPasswordKey = "UserPassword";
}