package com.example.myapplication;

import static java.sql.Types.NULL;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity{
    ListView list;
    String[] names={"x","y","z"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=findViewById(R.id.nameListView);
        ArrayAdapter<String>adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,names);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedname=names[i];
                String[] details=getDetails(selectedname);
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("name",selectedname);
                intent.putExtra("rollNo", details[0]);
                intent.putExtra("age",details[1]);
                intent.putExtra("experience",details[2]);
                startActivity(intent);
            }
        });
    }
    
    public String[] getDetails(String name){
        String[] details=new String[3];
        if(name=="x"){
            details[0] = "101"; // Roll Number
            details[1] = "25"; // Age
            details[2] = "3 years"; // Experienc
        }
        else if(name=="y"){
            details[0] = "1"; // Roll Number
            details[1] = "5"; // Age
            details[2] = "0 years"; // Experienc
        } else if (name=="z") {
            details[0] = "11"; // Roll Number
            details[1] = "2"; // Age
            details[2] = "5 years"; // Experienc
        }
        return details;
    }
    

}


