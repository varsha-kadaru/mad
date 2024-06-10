package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
TextView nametxt,rolltxt,agetxt,exptxt;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        nametxt=findViewById(R.id.nameTextView);
        rolltxt=findViewById(R.id.rollNoTextView);
        agetxt=findViewById(R.id.ageTextView);
        exptxt=findViewById(R.id.experienceTextView);
        btn=findViewById(R.id.backButton);
        Intent intent=getIntent();
        if(intent!=null){
            nametxt.setText(intent.getStringExtra("name"));
            rolltxt.setText(intent.getStringExtra("rollNo"));
            agetxt.setText(intent.getStringExtra("age"));
            exptxt.setText(intent.getStringExtra("experience"));
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}