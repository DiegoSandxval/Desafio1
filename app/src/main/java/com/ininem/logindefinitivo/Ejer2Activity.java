package com.ininem.logindefinitivo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Ejer2Activity extends AppCompatActivity implements View.OnClickListener {

    EditText votes;
    TextView result;
    Button calculate;
    int a=0,b=0,c=0,d=0,i=0;
    List<Integer> allvotes= new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejer2);

        votes=(EditText)findViewById(R.id.election);
        result=(TextView)findViewById(R.id.Result);
        calculate=(Button)findViewById(R.id.calculate);
        calculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int dato=Integer.parseInt(votes.getText().toString());
        allvotes.add(dato);
        switch (allvotes.get(i)){
            case 1:
                a++;
                break;
            case 2:
                b++;
                break;
            case 3:
                c++;
                break;
            case 4:
                d++;
                break;
            default:
                String votoN="Voto Nulo";
                break;
        }//fin switch
        i++;
        double ProA=(a*100)/allvotes.size();
        double ProB=(b*100)/allvotes.size();
        double ProC=(c*100)/allvotes.size();
        double ProD=(d*100)/allvotes.size();
        result.setText("votes"+"\n"+allvotes+"\n"+"Result"+"\n"+"Votes for candidate 1= "+a+"\n"+"Votes for candidate 2= "+b+"\n"+"Votes for candidate 3= "+c+"\n"+"Votes for candidate 4= "+d+"\n\n"
                +" percentage calculation "+"\n"+"% candidate 1= "+ProA+"%\n"+"% candidate 2= "+ProB+"%\n"+"% candidate 3= "+ProC+"%\n"+"% candidate 4= "+ProD+"%");
        dato=0;
    }
}