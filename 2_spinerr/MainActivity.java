package com.example.myapplication;

import static java.sql.Types.NULL;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
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
    private EditText editTextUserName, editTextPassword, editTextAddress,
            editTextAge;
    private RadioButton radioButtonMale, radioButtonFemale;
    private DatePicker datePicker;
    private Spinner spinnerState;
    private TextView textViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUserName = findViewById(R.id.editTextUserName);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextAddress = findViewById(R.id.editTextAddress);
        editTextAge = findViewById(R.id.editTextAge);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        datePicker = findViewById(R.id.datePicker);
        spinnerState = findViewById(R.id.spinnerState);
        textViewResult = findViewById(R.id.textViewResult);
        setupSpinner();
    }
    private void setupSpinner(){
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(
                this,
                R.array.app_name,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerState.setAdapter(adapter);
    }

    public void onSubmitClick(View view) {
        String userName = editTextUserName.getText().toString();
        String password = editTextPassword.getText().toString();
        String address = editTextAddress.getText().toString();
        String age = editTextAge.getText().toString();
        String gender = radioButtonMale.isChecked() ? "Male" : "Female";
        int day=datePicker.getDayOfMonth();
        int month=datePicker.getMonth()+1;
        int year= datePicker.getYear();
        String dateOfBirth=String.format("%02d-%02d-%04d",day,month,year);
        String state=spinnerState.getSelectedItem().toString();
        String result = "User Name: " + userName +
                "\nPassword: " + password +
                "\nAddress: " + address +
                "\nAge: " + age +
                "\nGender: " + gender +
                "\nDate of Birth: " + dateOfBirth +
                "\nState: " + state;
        textViewResult.setText(result);
    }
}


