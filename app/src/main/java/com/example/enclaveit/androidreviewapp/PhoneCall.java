package com.example.enclaveit.androidreviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.enclaveit.androidreviewapp.adapter.ContactApdapter;
import com.example.enclaveit.androidreviewapp.model.Contact;

import java.util.ArrayList;

public class PhoneCall extends AppCompatActivity {
     EditText edName;
     EditText edPhone;
     ImageButton btnAdd;

    ListView lvDirectory;
    ArrayList<Contact> arrDirectory;
    ContactApdapter  adapterContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_call);

        addControls();
        addEvent();
    }

    private void addControls(){
        edName = (EditText) findViewById(R.id.edNameContact);
        edPhone = (EditText) findViewById(R.id.edPhoneContact);
        btnAdd = (ImageButton) findViewById(R.id.btAdd);
        lvDirectory = (ListView) findViewById(R.id.lvDirectory);

        arrDirectory = new ArrayList<>();
        adapterContact = new ContactApdapter(PhoneCall.this, R.layout.item, arrDirectory);
        lvDirectory.setAdapter(adapterContact);
    }

    private void addEvent(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyDanhBa();
            }
        });
    }

    public void xulyDanhBa(){
        Contact contact = new Contact(edName.getText().toString(), edPhone.getText().toString());
        arrDirectory.add(contact);
        adapterContact.notifyDataSetChanged();
    }
}
