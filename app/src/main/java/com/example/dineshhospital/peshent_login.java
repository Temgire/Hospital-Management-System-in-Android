package com.example.dineshhospital;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class peshent_login extends AppCompatActivity {
    ImageView a,b,c,d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peshent_login);

        a=findViewById(R.id.imgb1);
        b=findViewById(R.id.imgb2);
        c=findViewById(R.id.imgb3);
        d=findViewById(R.id.imgb4);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e=new Intent(peshent_login.this,view_doctor.class);
                startActivity(e);
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent g=new Intent(peshent_login.this,medical.class);
                startActivity(g);
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent h=new Intent(peshent_login.this,contactus.class);
                startActivity(h);
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(peshent_login.this,appoitmentbook.class);
                startActivity(intent);
            }
        });
    }
}