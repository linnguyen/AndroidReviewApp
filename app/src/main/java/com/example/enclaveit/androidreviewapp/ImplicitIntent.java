package com.example.enclaveit.androidreviewapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ImplicitIntent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);



    }
    public void showWebPage(View view) {
        Intent intent =  new Intent (Intent.ACTION_VIEW, Uri.parse("http://google.com"));
        startActivity(intent);
    }



}
