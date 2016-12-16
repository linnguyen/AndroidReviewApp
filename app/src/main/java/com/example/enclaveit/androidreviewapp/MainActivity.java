package com.example.enclaveit.androidreviewapp;

import android.app.*;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
     Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.listView);

        String [] listSyllabus = {"Implicit Intent","Explicit Intent", "Fragment","App phone call","Notification", "Service","Dialog","Broad cast"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listSyllabus);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        intent = new Intent(MainActivity.this, ImplicitIntent.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, ExplicitIntent.class);
                        startActivity(intent);
                         break;
                    case 2:
                        intent = new Intent(MainActivity.this, Fragment.class);
                        startActivity(intent);
                         break;
                    case 3:
                        intent = new Intent(MainActivity.this, PhoneCall.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(MainActivity.this, Notification.class);
                        startActivity(intent);
                        break;

                    default:
                }
            }
        });
    }
}
