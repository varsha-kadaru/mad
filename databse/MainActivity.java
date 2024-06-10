
package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private EditText userNameEdt, userEmailEdt, userPasswordEdt;
    private Button registerBtn;
    TextView txt;
    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userNameEdt = findViewById(R.id.idEdtUserName);
        userEmailEdt = findViewById(R.id.idEdtUserEmail);
        userPasswordEdt = findViewById(R.id.idEdtUserPassword);
        registerBtn = findViewById(R.id.idBtnRegister);
        dbHandler = new DBHandler(MainActivity.this);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = userNameEdt.getText().toString();
                String userEmail = userEmailEdt.getText().toString();
                String userPassword = userPasswordEdt.getText().toString();
                if (userName.isEmpty() || userEmail.isEmpty() ||
                        userPassword.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                dbHandler.addNewUser(userName, userEmail, userPassword);
                txt=findViewById(R.id.txt);
                txt.setText("succes");
                userNameEdt.setText("");
                userEmailEdt.setText("");
                userPasswordEdt.setText("");
            }
        });
    }
}