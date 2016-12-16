package com.example.enclaveit.androidreviewapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.enclaveit.androidreviewapp.MainActivity;
import com.example.enclaveit.androidreviewapp.PhoneCall;
import com.example.enclaveit.androidreviewapp.R;
import com.example.enclaveit.androidreviewapp.model.Contact;

import java.util.List;
import java.util.jar.Manifest;

import static android.Manifest.permission.CALL_PHONE;

/**
 * Created by enclaveit on 16/12/2016.
 */

public class ContactApdapter extends ArrayAdapter<Contact> {
    Activity context;
    int resource;
    List<Contact> objects;

    public ContactApdapter(Activity context, int resource, List<Contact> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource, null);

        TextView txtName = (TextView) row.findViewById(R.id.txtName);
        TextView txtPhone = (TextView) row.findViewById(R.id.txtPhone);

        ImageButton btCall = (ImageButton) row.findViewById(R.id.btCall);
        ImageButton btSMS = (ImageButton) row.findViewById(R.id.btSMS);

        final Contact contact = this.objects.get(position);

        //process calling
        btCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyCall(contact);
            }
        });

        txtName.setText(contact.getName().toString());
        txtPhone.setText(contact.getPhone().toString());

        return row;
    }

    public void xulyCall(Contact contact) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse(contact.getPhone()));
        Activity activity = new Activity();
        if (ActivityCompat.checkSelfPermission(this.context, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        activity.startActivity(callIntent);

//        Intent intent = new Intent(Intent.ACTION_CALL);
//        Uri uri = Uri.parse("tel:" + contact.getPhone());
//        intent.setData(uri);
//
//        if (ActivityCompat.checkSelfPermission(this.context, CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
//        this.context.startActivity(intent);
    }
}
