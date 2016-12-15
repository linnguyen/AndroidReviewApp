package com.example.enclaveit.androidreviewapp;

import android.app.*;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by enclaveit on 15/12/2016.
 */

public class BottomFragment extends android.support.v4.app.Fragment{
    TextView topImageText;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.activity_fragment_layout_bottom, container, false);
         topImageText = (TextView) view.findViewById(R.id.topText);

        return view;
    }
    public void showText(String topText){
       topImageText.setText(topText);
    }
}
