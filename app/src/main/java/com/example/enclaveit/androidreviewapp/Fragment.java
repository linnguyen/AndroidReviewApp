package com.example.enclaveit.androidreviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Fragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }

    public void showText(String topImageText){
       BottomFragment bottomFragment = (BottomFragment) getSupportFragmentManager()
               .findFragmentById(R.id.bottom_fragment);
       bottomFragment.showText(topImageText);
    }
}
