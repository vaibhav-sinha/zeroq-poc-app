package com.zeroq.base;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import com.zeroq.applications.ZeroqApplication;

/**
 * Created by user-1 on 4/10/15.
 */
public class BaseIntentService extends IntentService {

    public BaseIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ((ZeroqApplication)getApplication()).inject(this);
    }
}
