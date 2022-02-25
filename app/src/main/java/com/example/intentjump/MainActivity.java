package com.example.intentjump;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private EditText to,subject,body;
    private ImageView send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        to = findViewById(R.id.to);
        subject = findViewById(R.id.subject);
        body = findViewById(R.id.body);
        send = findViewById(R.id.send);

    send.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if(to.getText().length()==0){
                to.setError("REQUIRED");
            }
            else if(subject.getText().length()==0){
                subject.setError("REQUIRED");
            }
            else if(body.getText().length()==0){
                body.setError("REQUIRED");
            }
            else {
                Intent sendEmail = new Intent(Intent.ACTION_SEND);
                sendEmail.setData(Uri.parse("mailto:"));
                sendEmail.setType("text/plain");
                sendEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{String.valueOf(to)});
                sendEmail.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
                sendEmail.putExtra(Intent.EXTRA_TEXT, body.getText());
                startActivity(sendEmail);
            }
        }
    });

    }
}