package com.example.hellouserapp; 
import android.os.Bundle; 
import androidx.appcompat.app.AppCompatActivity; 
import android.widget.TextView; 
public class MainActivity extends AppCompatActivity { 
@Override 
protected void onCreate(Bundle savedInstanceState) { 
super.onCreate(savedInstanceState); 
setContentView(R.layout.activity_main); 
// Assuming you have a TextView with the id 'textView' in your layout 
String username = "Sampath"; 
TextView textView = findViewById(R.id.textView); 
textView.setText("Hello, " + username + "!"); 
} 
}
