package com.example.notifyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void createNotification(View v)
    {
        Toast.makeText(this,"creating a notification",Toast.LENGTH_LONG).show();
        //GET THE NOTIFICATION MANAGER SERVICE
        NotificationManager nmr = (NotificationManager) this.getSystemService(NotificationManager.class);

        //CREATE NOTIFICATION CHANNEL-----new concept
        //provide channel name, description and importance
        NotificationChannel nc=new NotificationChannel("Blog","Michael's Blog",NotificationManager.IMPORTANCE_DEFAULT);
        nmr.createNotificationChannel(nc);//add channel by using NotificationManager
        //Build the Notification
           Notification.Builder builder = new Notification.Builder(this,nc.getId());//provide app context and channel ID
           builder.setSmallIcon(R.drawable.ic_launcher_foreground);
           //builder.setLargeIcon(R.drawable.ic_launcher_background.xml);
           builder.setContentTitle("Michael's Blog");
           builder.setContentText("You can get my lecture Notes in this blog");

            //create pendingIntent for the action to be performed when the user taps on the notification.
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://michaelkona.blogspot.com"));
            PendingIntent pi = PendingIntent.getActivity(this, 0, i, 0);
            builder.setContentIntent(pi);//set the intent to the notification

            Notification not = builder.build();//build the notification
            nmr.notify(1, not);//send notification
    }
}