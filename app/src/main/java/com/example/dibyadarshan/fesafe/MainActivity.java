package com.example.dibyadarshan.fesafe;



import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int PERMISSION_REQUEST_CODE = 1;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {

            if (checkSelfPermission(Manifest.permission.SEND_SMS)
                    == PackageManager.PERMISSION_DENIED) {

                Log.d("permission", "permission denied to SEND_SMS - requesting it");
                String[] permissions = {Manifest.permission.SEND_SMS};

                requestPermissions(permissions, PERMISSION_REQUEST_CODE);

            }
        }
        Button one = (Button)this.findViewById(R.id.button1);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.sound);
        one.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                SmsManager smsManager =     SmsManager.getDefault();
                smsManager.sendTextMessage("+919886594337", null, "Help!", null, null);
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

}
