package com.ininem.logindefinitivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText username, password;
    Button signin;
    TextView crea;
    DBhelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=findViewById(R.id.edtEmail);
        password=findViewById(R.id.edtPassword);
        signin=findViewById(R.id.btnLogin);
        crea=findViewById(R.id.register);
        DB=new DBhelper(this);
        

        signin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                if (TextUtils.isEmpty(user)||TextUtils.isEmpty(pass))
                    Toast.makeText(Login.this,"fill the fields ",Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass=DB.checkusernamepassword(user,pass);
                    if(checkuserpass==true){
                        Toast.makeText(Login.this,"sign in correctly",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);

                    }else {
                        Toast.makeText(Login.this,"error",Toast.LENGTH_SHORT).show();


                    }
                }

            }
        });
        crea.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
    int location=position;
    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}