package com.example.dibyadarshan.fesafe;



import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button one = (Button)this.findViewById(R.id.button1);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.sound);
        one.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
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
