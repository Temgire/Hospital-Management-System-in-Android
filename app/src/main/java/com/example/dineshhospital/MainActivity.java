package com.example.dineshhospital;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    TextView t1, b2, b3,b4;
    EditText t2, t3;
    Button b1;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t2 = findViewById(R.id.txt2);
        t1 = findViewById(R.id.txt1);
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        b4=findViewById(R.id.di);
        auth = FirebaseAuth.getInstance();


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                auth.signInWithEmailAndPassword(t1.getText().toString(), t2.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Login  Successfully", Toast.LENGTH_LONG).show();
                            Intent y = new Intent(MainActivity.this, peshent_login.class);
                            startActivity(y);
                        } else {
                            Toast.makeText(getApplicationContext(), "Error! Data Entered is Invalid.Please check the data once again", Toast.LENGTH_LONG).show();
                        }

                    }
                });


            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent x = new Intent(MainActivity.this, Signup_page.class);
                startActivity(x);

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent B = new Intent(MainActivity.this, doctor.class);
                startActivity(B);
            }
        });

    }
}