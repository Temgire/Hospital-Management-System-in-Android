package com.example.dineshhospital;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class doctor extends AppCompatActivity {
    EditText a,b;
    Button c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        a=findViewById(R.id.txt1);
        b=findViewById(R.id.txt2);
        c=findViewById(R.id.btn1);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(a.getText().toString().trim().equals("Dinesh") || b.getText().toString().trim().equals("Temgire"))
                {
                    Toast.makeText(doctor.this, "Login In Process Please Wait!!!", Toast.LENGTH_SHORT).show();
                    Intent c = new Intent(doctor.this, Doctorspage.class);
                    startActivity(c);
                }

                else
                {
                    Toast.makeText(doctor.this, "Error !! Data Entered is Invalid.Please check the data once again ", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}