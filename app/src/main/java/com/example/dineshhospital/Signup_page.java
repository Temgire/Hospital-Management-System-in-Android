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

public class Signup_page extends AppCompatActivity {
    Button c2;
    EditText e1,e2;
    TextView d;
    FirebaseAuth auth ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);

        c2=findViewById(R.id.signbtn);
        e1 = findViewById(R.id.txt11) ;
        e2 = findViewById(R.id.txt21) ;
        d=findViewById(R.id.signlogin);
        auth = FirebaseAuth.getInstance() ;



        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                auth.createUserWithEmailAndPassword(e1.getText().toString() , e2.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Signup_page.this, "User Created", Toast.LENGTH_SHORT).show();
                            Intent z=new Intent(Signup_page.this,MainActivity.class);
                            startActivity(z);
                        }else{
                            Toast.makeText(Signup_page.this, "User Creation Failed", Toast.LENGTH_SHORT).show();
                        }

                    }
                });


            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(Signup_page.this,MainActivity.class);
                startActivity(a);
            }
        });

    }
}