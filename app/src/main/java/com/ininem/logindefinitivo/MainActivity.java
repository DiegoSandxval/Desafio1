package com.ininem.logindefinitivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        EditText Username,password,repass;
        Button signin;
        TextView signup;
        DBhelper DB;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        Username=findViewById(R.id.user);
        password=findViewById (R.id.pass);
        signup=findViewById (R.id.create);
        signin=findViewById (R.id. loggin) ;
        DB=new DBhelper(this);

        signup.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                String user = Username.getText().toString();
                String pass = password.getText().toString();


                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
                    Toast.makeText(MainActivity.this, "hay campos vacios ", Toast.LENGTH_SHORT).show();

                else {

                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser == false) {
                            boolean insert = DB.insertData(user, pass);
                            if (insert == true) {
                                Toast.makeText(MainActivity.this, "cuenta creada", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Login.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(MainActivity.this, "fallo", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(MainActivity.this, "usuario ya existe", Toast.LENGTH_SHORT).show();
                        }

                    }
                }

          });
        signin.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }

    });}
}