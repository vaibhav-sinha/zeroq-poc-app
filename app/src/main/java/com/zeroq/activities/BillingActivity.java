package com.zeroq.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.zeroq.R;
import com.zeroq.base.BaseActivity;

public class BillingActivity extends BaseActivity {

    private TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing);

        total = (TextView) findViewById(R.id.ab_total);

        Double totalAmount = getIntent().getDoubleExtra("total", 0);
        total.setText("Total amount to be paid by you is " + totalAmount);
    }
}
