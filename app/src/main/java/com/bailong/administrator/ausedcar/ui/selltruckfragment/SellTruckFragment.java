package com.bailong.administrator.ausedcar.ui.selltruckfragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bailong.administrator.ausedcar.R;

/**
 * A simple {@link Fragment} subclass.
 */
//卖车碎片
public class SellTruckFragment extends Fragment {
    private View view ;
    private Context mcontext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mcontext = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sell_truck, container, false);
        return view;
    }

}
