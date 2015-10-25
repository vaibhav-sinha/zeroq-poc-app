package com.zeroq.base;

import com.zeroq.applications.ZeroqApplication;

/**
 * Created by user-1 on 3/10/15.
 */
public class BaseClass {
    public BaseClass() {
        ZeroqApplication.getInstance().inject(this);
    }
}
