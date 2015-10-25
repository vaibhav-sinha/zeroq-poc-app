package com.zeroq.volley;

import android.content.Context;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.zeroq.base.BaseClass;
import com.zeroq.config.Constants;
import com.zeroq.event.UserRegistrationEvent;
import com.zeroq.helpers.NetworkAccessHelper;
import com.zeroq.models.User;

import de.greenrobot.event.EventBus;

import javax.inject.Inject;

/**
 * Created by user-1 on 3/10/15.
 */
public class SaveUserRequest extends BaseClass {

    @Inject
    EventBus eventBus;
    @Inject
    NetworkAccessHelper networkAccessHelper;

    public void processRequest(Context context, User user) {
        GenericPostVolleyRequest<User> request = new GenericPostVolleyRequest<>(Constants.SAVE_PROFILE_URL, createErrorListener(), createSuccessListener(), user);
        networkAccessHelper.submitNetworkRequest("RegisterUser", request);
    }

    private Response.Listener<String> createSuccessListener() {
        return new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                User user = new Gson().fromJson(response, User.class);
                UserRegistrationEvent event = new UserRegistrationEvent();
                if(user == null) {
                    event.setSuccess(false);
                }
                else {
                    event.setSuccess(true);
                    event.setUser(user);
                }
                eventBus.post(event);
            }
        };
    }

    private Response.ErrorListener createErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                UserRegistrationEvent event = new UserRegistrationEvent();
                event.setSuccess(false);
                event.setError(error.toString());
                eventBus.post(event);
            }
        };
    }
}
