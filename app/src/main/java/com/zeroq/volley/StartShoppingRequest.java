package com.zeroq.volley;

import android.content.Context;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.zeroq.base.BaseClass;
import com.zeroq.config.Constants;
import com.zeroq.event.StartShoppingEvent;
import com.zeroq.helpers.NetworkAccessHelper;
import com.zeroq.models.ShoppingRequestData;
import com.zeroq.models.ShoppingResponseData;

import de.greenrobot.event.EventBus;

import javax.inject.Inject;

/**
 * Created by user-1 on 3/10/15.
 */
public class StartShoppingRequest extends BaseClass {

    @Inject
    EventBus eventBus;

    @Inject
    NetworkAccessHelper networkAccessHelper;

    public void processRequest(Context context, ShoppingRequestData shoppingRequestData, String key) {
        GenericPostVolleyRequest<ShoppingRequestData> request = new GenericPostVolleyRequest<>(Constants.START_SHOPPING_URL + "?access_token=" + key, createErrorListener(), createSuccessListener(), shoppingRequestData);
        networkAccessHelper.submitNetworkRequest("StartShopping", request);
    }

    private Response.Listener<String> createSuccessListener() {
        return new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                ShoppingResponseData shoppingResponseData = new Gson().fromJson(response, ShoppingResponseData.class);
                StartShoppingEvent event = new StartShoppingEvent();
                if(shoppingResponseData == null) {
                    event.setSuccess(false);
                }
                else {
                    event.setSuccess(true);
                    event.setShoppingId(shoppingResponseData.getShoppingId());
                }
                eventBus.post(event);
            }
        };
    }

    private Response.ErrorListener createErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                StartShoppingEvent event = new StartShoppingEvent();
                event.setSuccess(false);
                event.setError(error.toString());
                eventBus.post(event);
            }
        };
    }
}

