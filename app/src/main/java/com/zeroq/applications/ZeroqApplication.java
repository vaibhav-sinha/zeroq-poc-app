package com.zeroq.applications;

import android.app.Application;
import android.os.StrictMode;
import android.util.Log;

import com.zeroq.BuildConfig;
import com.zeroq.modules.MiddlewareGraph;

import java.util.Collections;

import dagger.ObjectGraph;

/**
 * Created by user-1 on 25/10/15.
 */
public class ZeroqApplication extends Application {

    private static ObjectGraph objectGraph;
    private static ZeroqApplication instance;

    @Override
    public void onCreate() {
        if (BuildConfig.DEBUG) {
            Log.d("ZeroqApplication", "Debug mode enabled");
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()   // or .detectAll() for all detectable problems
                    .penaltyLog()
                    .penaltyDialog()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .penaltyLog()
                    .penaltyDeath()
                    .build());
        }
        super.onCreate();
        instance = this;
        objectGraph = ObjectGraph.create(getModules());
    }

    private Object[] getModules() {
        return Collections.singletonList(new MiddlewareGraph(this)).toArray();
    }

    public void inject(Object target) {
        objectGraph.inject(target);
    }

    public static ZeroqApplication getInstance() {
        return instance;
    }
}
