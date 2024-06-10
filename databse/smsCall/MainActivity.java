package com.example.myapplication;

import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button dialButton = findViewById(R.id.dialbtn);
        Button websiteButton = findViewById(R.id.webbtn);
        Button smsButton = findViewById(R.id.smsbtn);
        dialButton.setOnClickListener(this);
        websiteButton.setOnClickListener(this);
        smsButton.setOnClickListener(this);
    }
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.dialbtn) {
            // Dial a number
            Intent dialIntent = new Intent(Intent.ACTION_DIAL);
            dialIntent.setData(Uri.parse("tel:123456789")); // Replace with youphone number
            startActivity(dialIntent);
        } else if (id == R.id.webbtn) {
            // Open a website
            Intent websiteIntent = new Intent(Intent.ACTION_VIEW);
            websiteIntent.setData(Uri.parse("https://www.example.com")); //Replace with your website URL
            startActivity(websiteIntent);
        } else if (id == R.id.smsbtn) {
            // Send an SMS
            Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
            smsIntent.setData(Uri.parse("smsto:")); // This ensures only SMS appsrespond
            smsIntent.putExtra("sms_body", "Hello, this is a test message!"); //Replace with your message
            startActivity(smsIntent);
        }
    }
}
