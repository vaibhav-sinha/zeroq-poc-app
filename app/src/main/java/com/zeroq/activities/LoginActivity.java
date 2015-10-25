package com.zeroq.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.digits.sdk.android.AuthCallback;
import com.digits.sdk.android.DigitsAuthButton;
import com.digits.sdk.android.DigitsException;
import com.digits.sdk.android.DigitsSession;
import com.zeroq.R;

import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.digits.sdk.android.Digits;
import com.zeroq.base.BaseActivity;
import com.zeroq.config.Constants;
import com.zeroq.helpers.Session;

import javax.inject.Inject;

import io.fabric.sdk.android.Fabric;

public class LoginActivity extends BaseActivity {

    @Inject
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(Constants.TWITTER_KEY, Constants.TWITTER_SECRET);
        Fabric.with(this, new TwitterCore(authConfig), new Digits());
        setContentView(R.layout.activity_login);

        DigitsAuthButton digitsButton = (DigitsAuthButton) findViewById(R.id.auth_button);
        digitsButton.setAuthTheme(R.style.CustomDigitsTheme);
        digitsButton.setCallback(new AuthCallback() {
            @Override
            public void success(DigitsSession session, String phoneNumber) {
                Toast.makeText(getApplicationContext(), "Authentication successful for " + phoneNumber, Toast.LENGTH_LONG).show();
                startProfileActivity(phoneNumber);
            }

            @Override
            public void failure(DigitsException exception) {
                Toast.makeText(getApplicationContext(), "Authentication failed", Toast.LENGTH_LONG).show();
                Log.d("Digits", "Sign in with Digits failure", exception);
            }
        });

        if(session.getUser(this) != null) {
            Log.d("Loggedin user", session.getUser(this).toString());
            startHomeActivity();
        }

    }

    private void startProfileActivity(String phoneNumber) {
        Intent i = new Intent(this, ProfileActivity.class);
        i.putExtra("phoneNumber", phoneNumber);
        startActivity(i);
        finish();
    }

    private void startHomeActivity() {
        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
        finish();
    }
}
