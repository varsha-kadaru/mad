package com.example.myapplication;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends Activity {
    EditText name,password;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.editTextUsername);
        password = findViewById(R.id.editTextPassword);
        btn = findViewById(R.id.buttonLogin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = name.getText().toString();
                String pass = password.getText().toString();
                if (isValidate(username, pass)) {
                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
        private boolean isValidate(String username,String password){
            try {
                Log.d("hi","hi");
                InputStream inputStream =
                        getAssets().open("user_credentials.txt");
                BufferedReader reader = new BufferedReader(new
                        InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(" ");
                    if (parts.length == 2) {
                        String storedUsername = parts[0];
                        String storedPassword = parts[1];
                        System.out.println(storedPassword+storedUsername);
                        if (storedUsername.equals(username) &&
                                storedPassword.equals(password)) {
                            reader.close();
                            return true;
                        }
                    }
                }
                reader.close();
            } catch (IOException e) {
                System.out.println("hi");
                e.printStackTrace();
            }
            return false;
        }
    }
   

