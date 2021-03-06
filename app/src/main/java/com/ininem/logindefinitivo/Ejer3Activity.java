package com.ininem.logindefinitivo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Ejer3Activity extends AppCompatActivity implements View.OnClickListener {

    int job,i;
    EditText name,hours;
    TextView employe1,discount1,cash1,bono1,employe2,discount2,cash2,bono2,employe3,discount3,cash3,bono3,worst,best,Pmore300;
    Spinner cargo;
    Button btnResult;
    String [] puestos= new String[] {"Gerente","Asistente","Secretaria","Otro"};
    String [] names= new String[3];
    Double [] salary=new Double[3];
    Double [] totalsalary=new Double[3];
    Double [] bonos=new Double[3];
    Integer [] works= new Integer[3];
    Integer [] workhours= new Integer[3];
    Double [] ISSS=new Double[3];
    Double [] AFP=new Double[3];
    Double [] RENTA=new Double[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejer3);

        i=0;
        name=(EditText)findViewById(R.id.namefull);
        hours=(EditText)findViewById(R.id.hoursworked);

        employe1=(TextView)findViewById(R.id.employe1);
        discount1=(TextView)findViewById(R.id.discount1);
        cash1=(TextView)findViewById(R.id.cash1);
        bono1=(TextView)findViewById(R.id.bono1);
        employe2=(TextView)findViewById(R.id.employe2);
        discount2=(TextView)findViewById(R.id.discount2);
        cash2=(TextView)findViewById(R.id.cash2);
        bono2=(TextView)findViewById(R.id.bono2);
        employe3=(TextView)findViewById(R.id.employe3);
        discount3=(TextView)findViewById(R.id.discount3);
        cash3=(TextView)findViewById(R.id.cash3);
        bono3=(TextView)findViewById(R.id.bono3);
        best=(TextView)findViewById(R.id.best);
        worst=(TextView)findViewById(R.id.worst);
        Pmore300=(TextView)findViewById(R.id.more300);

        btnResult=(Button)findViewById(R.id.btnResult);
        btnResult.setOnClickListener(this);

        cargo=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,puestos);
        cargo.setAdapter(adapter);

        cargo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0: job=1; break;
                    case 1: job=2;break;
                    case 2: job=3;break;
                    default: job=4;break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                job=1;
            }
        });


    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        String nombre=name.getText().toString();
        double bono;
        works[i]=job;
        int horas=Integer.parseInt(hours.getText().toString());
        while(horas<=0){
            Toast to= Toast.makeText(getApplicationContext(),"Las horas de trabajo deben ser mayores a 0",Toast.LENGTH_LONG);
            to.show();
            horas=Integer.parseInt(hours.getText().toString());
        }

        names[i]=nombre;
        workhours[i]=horas;
        if(workhours[i]<=160){
            salary[i]=workhours[i]*9.75;
        }
        else{
            salary[i]=(160*9.75)+((workhours[i]-160)*11.5);
        }

        ISSS[i]=salary[i]*0.0525;
        AFP[i]=salary[i]*0.0688;
        RENTA[i]=salary[i]*0.1;

        totalsalary[i]=salary[i]-(ISSS[i]+AFP[i]+RENTA[i]);


        if(i==2){            if(works[0]==0&&works[1]==1&&works[2]==2){
            Toast to= Toast.makeText(getApplicationContext(),"No hay BONO",Toast.LENGTH_LONG);
            to.show();
            bono1.setText(0);

            bono2.setText(0);

            bono3.setText(0);

        }
        }
        else {
            switch (works[i]){
                case 1:
                    totalsalary[i]=totalsalary[i]*1.1;
                    bono=totalsalary[i]*0.1;
                    break;
                case 2:
                    totalsalary[i]=totalsalary[i]*1.05;
                    bono=totalsalary[i]*0.05;
                    break;
                case 3:
                    totalsalary[i]=totalsalary[i]*1.03;
                    bono=totalsalary[i]*0.03;
                    break;
                default:
                    totalsalary[i]=totalsalary[i]*1.02;
                    bono=totalsalary[i]*0.02;
                    break;
            }
            bonos[i]=bono;
        }

        String bestpay="",worstpay="",printmore300="";
        double bestpayemploye,worstpayemploye;
        List<String> more300=new ArrayList<String>();

        switch (i){
            case 0:
                employe1.setText("Nombre\n"+names[0]);
                discount1.setText("ISSS: "+ISSS[0]+"\nAFP:"+AFP[0]+"\nRENTA:"+RENTA[0]);
                cash1.setText("Sueldo Liquido: "+totalsalary[0]);
                bono1.setText("Bono: "+bonos[0]);
                break;
            case 1:
                employe2.setText("Nombre\n"+names[1]);
                discount2.setText("ISSS: "+ISSS[1]+"\nAFP:"+AFP[1]+"\nRENTA:"+RENTA[1]);
                cash2.setText("Sueldo Liquido: "+totalsalary[1]);
                bono2.setText("Bono: "+bonos[1]);
                break;
            case 2:
                employe3.setText("Nombre\n"+names[2]);
                discount3.setText("ISSS: "+ISSS[2]+"\nAFP:"+AFP[2]+"\nRENTA:"+RENTA[2]);
                cash3.setText("Sueldo Liquido: "+totalsalary[2]);
                bono3.setText("Bono: "+bonos[2]);

                bestpayemploye=worstpayemploye=totalsalary[0];
                for(int j=0 ; j < totalsalary.length ; j++ ){
                    if(totalsalary[j]>bestpayemploye){
                        bestpayemploye=totalsalary[j];
                    }
                    if(totalsalary[j]<worstpayemploye){
                        worstpayemploye=totalsalary[j];
                    }
                    if(totalsalary[j]>300){
                        more300.add(names[j]);
                    }
                }//fin for
                for (int k = 0; k < more300.size(); k++){
                    if(k + 1 < more300.size())
                        printmore300 += more300.get(k) + " | ";
                    else{
                        printmore300 += more300.get(k);
                    }
                }//fin for
                for (int p=0 ; p < totalsalary.length ; p++){
                    if(bestpayemploye==totalsalary[p]){
                        bestpay=names[p];
                    }
                    if(worstpayemploye==totalsalary[p]){
                        worstpay=names[p];
                    }
                }
                Pmore300.setText("Los que ganan mas de 300 son"+printmore300);
                best.setText("El mejor pagado es "+bestpay);
                worst.setText("El peor pagado es "+worstpay);
                break;
        }//fin switch
        job=0;
        nombre="";
        horas=0;
        i++;

    }
}