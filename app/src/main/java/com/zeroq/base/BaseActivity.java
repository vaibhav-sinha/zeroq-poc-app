package com.zeroq.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zeroq.applications.ZeroqApplication;

/**
 * Created by user-1 on 3/10/15.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((ZeroqApplication)getApplication()).inject(this);
    }

}
