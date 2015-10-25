package com.zeroq.models;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

/**
 * Created by user-1 on 25/10/15.
 */
@Data
public class ShoppingRequestData {

    @SerializedName(value = "cart_id")
    private String cartId;
}
