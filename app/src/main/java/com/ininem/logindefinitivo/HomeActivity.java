package com.ininem.logindefinitivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    Button ejercicio1;
    Button ejercicio2;
    Button ejercicio3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ejercicio1 = findViewById(R.id.bb1);
        ejercicio2 = findViewById(R.id.bb2);
        ejercicio3 = findViewById(R.id.bb3);

        ejercicio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Ejer1Activity.class);
                startActivity(intent);
            }
        });
        ejercicio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Ejer2Activity.class);
                startActivity(intent);
            }
        });
        ejercicio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Ejer3Activity.class);
                startActivity(intent);
            }
        });
    }}