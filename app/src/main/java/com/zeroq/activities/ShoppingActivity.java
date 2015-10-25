package com.zeroq.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.google.gson.Gson;
import com.zeroq.R;
import com.zeroq.base.BaseActivity;
import com.zeroq.config.Constants;
import com.zeroq.models.Product;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingActivity extends BaseActivity {

    private ListView productList;
    private List<String> productItems = new ArrayList<>();
    ArrayAdapter<String> adapter;
    List<Product> products = new ArrayList<>();

    private Socket mSocket;
    {
        try {
            mSocket = IO.socket(Constants.SOCKET_URL);
        } catch (URISyntaxException ignored) {}
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        productList = (ListView) findViewById(R.id.sa_product_list);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, productItems);
        productList.setAdapter(adapter);

        attachSocketListeners();
        mSocket.connect();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSocket.disconnect();
        detachSocketListeners();
    }

    private void attachSocketListeners() {
        mSocket.on("item_added", onItemAdded);
        mSocket.on("trigger_billing", onTriggerBilling);
    }

    private void detachSocketListeners() {
        mSocket.off("item_added", onItemAdded);
        mSocket.off("trigger_billing", onTriggerBilling);
    }

    private void addItemToListView(Product product) {
        adapter.add(product.getName() + "\t\t" + product.getPrice() + " Rs");
    }

    private Emitter.Listener onItemAdded = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    String data = args[0].toString();
                    Gson gson = new Gson();
                    Product product = gson.fromJson(data, Product.class);
                    products.add(product);

                    // add the message to view
                    addItemToListView(product);
                }
            });
        }
    };

    private Emitter.Listener onTriggerBilling = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Double total = (double) 0;
                    for(Product product : products) {
                        total = total + product.getPrice();
                    }
                    startBillingActivity(total);
                }
            });
        }
    };

    private void startBillingActivity(Double total) {
        Intent i = new Intent(this, BillingActivity.class);
        i.putExtra("total", total);
        startActivity(i);
        finish();

    }
}
