package com.zeroq.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.zeroq.R;
import com.zeroq.base.BaseActivity;
import com.zeroq.datastore.Server;
import com.zeroq.event.UserRegistrationEvent;
import com.zeroq.helpers.Session;
import com.zeroq.models.User;

import de.greenrobot.event.EventBus;

import javax.inject.Inject;


/**
 * Created by user-1 on 3/10/15.
 */
public class ProfileActivity extends BaseActivity {

    @Inject
    Server server;

    @Inject
    EventBus eventBus;

    @Inject
    Session session;

    private EditText apName;
    private EditText apAddress;
    private RadioGroup apSex;
    private Button apSubmit;

    private String selectedSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        apName = (EditText) findViewById(R.id.ap_name);
        apAddress = (EditText) findViewById(R.id.ap_address);
        apSex = (RadioGroup) findViewById(R.id.ap_sex);
        apSubmit = (Button) findViewById(R.id.ap_submit);

        apSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.ap_male) {
                    selectedSex = "male";
                }
                else {
                    selectedSex = "female";
                }
            }
        });

        apSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setId(getIntent().getStringExtra("phoneNumber"));
                user.setName(apName.getText().toString());
                user.setAddress(apAddress.getText().toString());
                user.setGender(selectedSex);
                server.registerUser(getBaseContext(), user);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        eventBus.register(this);
        if(session.getUser(this) != null) {
            startHomeActivity();
        }
    }

    @Override
    protected void onStop() {
        eventBus.unregister(this);
        super.onStop();
    }

    public void onEventMainThread(UserRegistrationEvent event) {
        if(event.getSuccess()) {
            session.setUser(this, event.getUser());
            startHomeActivity();
        }
        else {
            Toast.makeText(this, "User registration failed because " + event.getError(), Toast.LENGTH_LONG).show();
        }
    }

    private void startHomeActivity() {
        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
        finish();
    }
}
