package com.recharge.nirbhay.rechargewallete.fragmetsclass;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.recharge.nirbhay.rechargewallete.R;

/**
 * Created by Rakesh on 12/16/2016.
 *
 */

public class FragmentFAQ extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.faq, null);
        return view;
    }
}
