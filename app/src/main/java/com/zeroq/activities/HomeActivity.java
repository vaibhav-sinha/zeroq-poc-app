package com.zeroq.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zeroq.R;
import com.zeroq.base.BaseActivity;
import com.zeroq.datastore.Server;
import com.zeroq.event.StartShoppingEvent;
import com.zeroq.helpers.Session;
import com.zeroq.models.ShoppingRequestData;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

public class HomeActivity extends BaseActivity {

    @Inject
    Server server;

    @Inject
    Session session;

    @Inject
    EventBus eventBus;

    private EditText cartId;
    private Button startShopping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        cartId = (EditText) findViewById(R.id.ah_cart_id);
        startShopping = (Button) findViewById(R.id.ah_start_shopping);

        startShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShoppingRequestData shoppingRequestData = new ShoppingRequestData();
                shoppingRequestData.setCartId(cartId.getText().toString());
                server.startShopping(v.getContext(), shoppingRequestData, session.getUser(v.getContext()).getKey());
            }
        });
    }

    @Override
    protected void onStop() {
        eventBus.unregister(this);
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        eventBus.register(this);
    }

    public void onEventMainThread(StartShoppingEvent event) {
        if(event.getSuccess()) {
            session.setShoppingId(event.getShoppingId());
            startShoppingActivity();
        }
        else {
            Toast.makeText(this, "Shopping request failed due to " + event.getError(), Toast.LENGTH_LONG).show();
        }
    }

    private void startShoppingActivity() {
        Intent i = new Intent(this, ShoppingActivity.class);
        startActivity(i);
        finish();
    }
}
