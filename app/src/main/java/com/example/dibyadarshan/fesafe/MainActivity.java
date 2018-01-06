package com.example.dibyadarshan.fesafe;


import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int PERMISSION_REQUEST_CODE = 1;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (checkSelfPermission(Manifest.permission.SEND_SMS)
                    == PackageManager.PERMISSION_DENIED) {

                Log.d("permission", "permission denied to SEND_SMS - requesting it");
                String[] permissions = {Manifest.permission.SEND_SMS};

                requestPermissions(permissions, PERMISSION_REQUEST_CODE);

            }
        }
        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {

                                  @Override
                                  public void run() {

                                      Intent temp = new Intent();
                                      PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this,0,temp,0);
                                      Notification noti = new Notification.Builder(MainActivity.this)
                                              .setTicker("Ticker")
                                              .setContentTitle("C title")
                                              .setContentText("ds")
                                              .setSmallIcon(R.drawable.ic_launcher_background)
                                              .addAction(R.drawable.ic_launcher_background," ",pIntent)
                                              .setContentIntent(pIntent).getNotification();
                                      noti.flags= Notification.FLAG_AUTO_CANCEL;
                                      NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                                      nm.notify(0,noti);
                                  }

                              },
                0,
                1000);
        Button one = (Button)this.findViewById(R.id.button1);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.sound);
        one.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                //SmsManager smsManager =     SmsManager.getDefault();
                //smsManager.sendTextMessage("+919886594337", null, "Help!", null, null);
                if(mp.isPlaying()){
                    mp.pause();
                }
                else{
                    mp.start();
                }

            }
        });
    }
    public void buttonClickFunction(View v)
    {
        Intent intent = new Intent(getApplicationContext(),svg.class);
        startActivity(intent);
    }

    public void findPoliceStations(View v){

        Uri gmmIntentUri = Uri.parse("geo:0,0?q=police stations near me");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

}