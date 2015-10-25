package com.zeroq.helpers;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.zeroq.base.BaseClass;
import com.zeroq.models.User;

import javax.inject.Inject;

import lombok.Data;

/**
 * Created by user-1 on 3/10/15.
 */
@Data
public class Session extends BaseClass {

    @Inject
    SharedPreferencesHelper sharedPreferencesHelper;

    private String shoppingId;


    public User getUser(Context context) {
        String json = sharedPreferencesHelper.getString(context, "User", null);
        if(json == null) {
            return null;
        }
        Gson gson = new Gson();
        try {
            return gson.fromJson(json, User.class);
        } catch (JsonParseException e) {
            return null;
        }
    }

    public void setUser(Context context, User user) {
        Gson gson = new Gson();
        sharedPreferencesHelper.putString(context, "User", gson.toJson(user));
    }
}
