package com.zeroq.modules;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.zeroq.activities.BillingActivity;
import com.zeroq.activities.HomeActivity;
import com.zeroq.activities.LoginActivity;
import com.zeroq.activities.ProfileActivity;
import com.zeroq.activities.ShoppingActivity;
import com.zeroq.activities.SplashActivity;
import com.zeroq.datastore.Server;
import com.zeroq.datastore.ServerImpl;
import com.zeroq.helpers.NetworkAccessHelper;
import com.zeroq.helpers.Session;
import com.zeroq.helpers.SharedPreferencesHelper;
import com.zeroq.volley.SaveUserRequest;
import com.zeroq.volley.StartShoppingRequest;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;

/**
 * Created by user-1 on 25/10/15.
 */
@Module(
        injects = {
                SplashActivity.class,
                ProfileActivity.class,
                LoginActivity.class,
                HomeActivity.class,
                ServerImpl.class,
                SaveUserRequest.class,
                StartShoppingRequest.class,
                Session.class,
                NetworkAccessHelper.class,
                ShoppingActivity.class,
                BillingActivity.class
        },
        library = true,
        complete = true
)
public class MiddlewareGraph {

    private Context applicationContext;

    public MiddlewareGraph(Context context) {
        this.applicationContext = context;
    }

    @Provides
    public Context provideApplicationContext() {
        return applicationContext;
    }

    @Provides
    @Singleton
    EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public RequestQueue provideRequestQueue() {
        return Volley.newRequestQueue(this.applicationContext);
    }

    @Provides
    @Singleton
    public Server provideServer() {
        return new ServerImpl();
    }

    @Provides
    @Singleton
    public SharedPreferencesHelper provideSharedPreferencesHelper() {
        return new SharedPreferencesHelper("ZeroQPreferences");
    }

    @Provides
    @Singleton
    public Session provideSession() {
        return new Session();
    }

    @Provides
    @Singleton
    public SaveUserRequest provideSaveUserRequest() {
        return new SaveUserRequest();
    }

    @Provides
    @Singleton
    public StartShoppingRequest provideStartShoppingRequest() {
        return new StartShoppingRequest();
    }

}

