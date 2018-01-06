package com.example.dibyadarshan.fesafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class svg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svg);
        final EditText name = (EditText) findViewById(R.id.editText1);
        final EditText addy = (EditText) findViewById(R.id.editText2);
        final EditText cell = (EditText) findViewById(R.id.editText3);
        final EditText questions = (EditText) findViewById(R.id.editText4);

        Button email = (Button) findViewById(R.id.button11);
        email.setOnClickListener(new View.OnClickListener()  {

            @Override
            public void onClick(View v){
                
                Intent email = new Intent(android.content.Intent.ACTION_SEND);


                email.setType("plain/text");
                email.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"mnaveenkumar2009@gmail.com"});
                email.putExtra(android.content.Intent.EXTRA_SUBJECT, "FeSafe-Complaints/Grievance");
                email.putExtra(android.content.Intent.EXTRA_TEXT,
                        "Name:"+name.getText().toString()+'\n'+"Address:"+addy.getText().toString()+'\n'+"Phone:"+cell.getText().toString()+'\n'+'\n'+questions.getText().toString()+'\n'+'\n'+"Sent from FeSafe application");


                startActivity(Intent.createChooser(email, "Send mail"));
            }
        });
    }
}
