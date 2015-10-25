package com.zeroq.datastore;

import android.content.Context;

import com.zeroq.base.BaseClass;
import com.zeroq.models.ShoppingRequestData;
import com.zeroq.models.User;
import com.zeroq.volley.SaveUserRequest;
import com.zeroq.volley.StartShoppingRequest;

import javax.inject.Inject;

/**
 * Created by user-1 on 3/10/15.
 */
public class ServerImpl extends BaseClass implements Server {

    @Inject
    SaveUserRequest saveUserRequest;

    @Inject
    StartShoppingRequest startShoppingRequest;

    @Override
    public void registerUser(Context context, User user) {
        saveUserRequest.processRequest(context, user);
    }

    @Override
    public void loadUserById(Context context, String id) {

    }

    @Override
    public void startShopping(Context context, ShoppingRequestData shoppingRequestData, String key) {
        startShoppingRequest.processRequest(context, shoppingRequestData, key);
    }


}
