package com.zeroq.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.zeroq.applications.ZeroqApplication;

/**
 * Created by user-1 on 3/10/15.
 */
public class BaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((ZeroqApplication)getActivity().getApplication()).inject(this);
    }

}
