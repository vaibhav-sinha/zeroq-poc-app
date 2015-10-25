package com.zeroq.event;


import com.zeroq.base.BaseEvent;
import com.zeroq.models.User;

import lombok.Data;

/**
 * Created by user-1 on 3/10/15.
 */
@Data
public class UserRegistrationEvent extends BaseEvent {

    private User user;
}
