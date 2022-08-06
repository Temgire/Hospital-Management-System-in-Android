package com.example.dineshhospital;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

public class Doctorspage extends AppCompatActivity {
    FirebaseFirestore firestore ;
    public static String patientName , symtom , time , date ;
    CardView cardview ;
    LinearLayout.LayoutParams cvlayoutparams , tvlayoutparams ;
    LinearLayout linearLayout ;
    TextView textview ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorspage);
        linearLayout = findViewById(R.id.linearLayout) ;

        patientName = "" ;
        symtom = "" ;
        time = "" ;
        date = "" ;

        firestore = FirebaseFirestore.getInstance();

        firestore.collection("Patient Info").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                for (DocumentChange documentChange : value.getDocumentChanges()) {

                    patientName =  documentChange.getDocument().getData().get("Patient Name").toString()  ;
                    symtom = documentChange.getDocument().getData().get("Symtoms").toString()  ;
                    time = documentChange.getDocument().getData().get("Time").toString()  ;
                    date = documentChange.getDocument().getData().get("Date").toString()  ;
//                    Log.d("tag" , patientName + "" + symtom + "" + time + "" + date) ;
                    createCardViewProgrammatically() ;
                }
            }
        });
    }

    public void createCardViewProgrammatically(){

        textview = new TextView(getApplicationContext()) ;


        cardview = new CardView(getApplicationContext());

        cvlayoutparams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        tvlayoutparams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        cvlayoutparams.setMargins(30, 30, 30, 30);

        cardview.setLayoutParams(cvlayoutparams);

        cardview.setRadius(15);

        cardview.setPadding(25, 25, 25, 25);
        int cv = Color.parseColor("#36BFB1");
        cardview.setCardBackgroundColor(cv);


        cardview.setMaxCardElevation(30);

        cardview.setMaxCardElevation(6);

        textview = new TextView(getApplicationContext());

        textview.setLayoutParams(tvlayoutparams);

        textview.setText("Patient Name : "+patientName+"\n"+
                "Symtoms : " + symtom + "\n" +
                "Time : " + time + "\n" +
                "Date : " + date);

        textview.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);

        textview.setTextColor(Color.BLACK);

        textview.setPadding(50,100,50,100);

        textview.setGravity(Gravity.CENTER);

        cardview.addView(textview);

        linearLayout.addView(cardview);

    }
}