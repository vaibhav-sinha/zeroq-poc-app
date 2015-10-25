package com.zeroq.datastore;

import android.content.Context;

import com.zeroq.models.ShoppingRequestData;
import com.zeroq.models.User;


/**
 * Created by user-1 on 3/10/15.
 */
public interface Server {

    void registerUser(Context context, User user);
    void loadUserById(Context context, String id);
    void startShopping(Context context, ShoppingRequestData shoppingRequestData, String key);
}
