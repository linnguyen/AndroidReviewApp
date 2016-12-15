package com.example.enclaveit.androidreviewapp;

import android.app.*;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.FrameStats;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by enclaveit on 15/12/2016.
 */

public class TopFragment extends android.app.Fragment {
    EditText editText;
    Button btClickme;

    Fragment fragMent;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
       View view = inflater.inflate(R.layout.activity_fragment_layout_top, container, false);
        editText = (EditText) view.findViewById(R.id.edTopText);
        btClickme = (Button) view.findViewById(R.id.btClickme);

        btClickme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applyText();
            }
        });
        return view;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Fragment){
            this.fragMent = (Fragment) context;
        }
    }

    public void applyText(){
        String topText = editText.getText().toString();
        Toast.makeText(null,topText,Toast.LENGTH_LONG).show();
        fragMent.showText(topText);
    }
}
