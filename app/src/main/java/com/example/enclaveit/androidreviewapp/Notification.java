package com.example.enclaveit.androidreviewapp;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

/**
 * Created by enclaveit on 16/12/2016.
 */

public class Notification extends Activity{
    private NotificationCompat.Builder notBuilder;
    private static final int MY_NOTIFICATION_ID = 12345;
    private static final int MY_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        this.notBuilder = new NotificationCompat.Builder(this);

        //The message will automatically be canceled when the user clicks on Panel

        this.notBuilder.setAutoCancel(true);
    }

    public void notiButtonClicked(View view){
        //
        //Prepare a notification
        this.notBuilder.setSmallIcon(R.mipmap.ic_launcher);
        this.notBuilder.setTicker("This is a ticket");

        //Set the time that the event occurred
        //Notificatons in the panel are sorted by the time
        this.notBuilder.setWhen(System.currentTimeMillis() + 10*1000);
        this.notBuilder.setContentTitle("This is the title");
        this.notBuilder.setContentText("This is content text..");

        //Create Intent
        Intent intent = new Intent(this, Notification.class);

        //PendingIntent

        PendingIntent pendingIntent = PendingIntent.getActivity(this, MY_REQUEST_CODE,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);

        this.notBuilder.setContentIntent(pendingIntent);

        //Get a notification service
        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);

        //Builds notification and issue it

        android.app.Notification notification = notBuilder.build();
        notificationManager.notify(MY_NOTIFICATION_ID, notification);



    }
}
