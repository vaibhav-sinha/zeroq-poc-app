package com.zeroq.event;

import com.zeroq.base.BaseEvent;

import lombok.Data;

/**
 * Created by user-1 on 25/10/15.
 */
@Data
public class StartShoppingEvent extends BaseEvent {

    private String shoppingId;
}
