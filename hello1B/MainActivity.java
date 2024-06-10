package com.example.hellonameapp; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.Button; 
import android.widget.EditText; 
import android.widget.TextView; 
import androidx.appcompat.app.AppCompatActivity; 
public class MainActivity extends AppCompatActivity { 
private EditText editTextName; 
private TextView textViewMessage; 
@Override 
protected void onCreate(Bundle savedInstanceState) { 
super.onCreate(savedInstanceState); 
setContentView(R.layout.activity_main); 
editTextName = findViewById(R.id.editTextName); 
textViewMessage = findViewById(R.id.textViewMessage); 
} 
public void showHelloMessage(View view) { 
String name = editTextName.getText().toString(); 
if (!name.isEmpty()) { 
String helloMessage = "Hello, " + name + "!"; 
textViewMessage.setText(helloMessage); 
} 
} 
}