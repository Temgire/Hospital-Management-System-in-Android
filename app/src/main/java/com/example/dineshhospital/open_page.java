package com.example.dineshhospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class open_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_page);
        Thread th=new Thread()
        {
            public void run()
            {
                try{
                    sleep(4000);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                finally {
                    Intent intent=new Intent(open_page.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        };th.start();
    }
}