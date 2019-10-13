package com.example.taxcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText sal=(EditText)findViewById(R.id.editText);
        final EditText hra=(EditText)findViewById(R.id.editText2);
        final EditText alow1=(EditText)findViewById(R.id.editText3);
        final EditText alow2=(EditText)findViewById(R.id.editText4);
        final EditText stdded=(EditText)findViewById(R.id.editText5);
        final EditText gsal=(EditText)findViewById(R.id.editText6);
        final EditText tax=(EditText)findViewById(R.id.editText7);

        Button b1=(Button)findViewById(R.id.button);
        Button b2=(Button)findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=sal.getText().toString();
                String b=hra.getText().toString();
                String c=alow1.getText().toString();
                String d=alow2.getText().toString();
                String z=stdded.getText().toString();

                if(TextUtils.isEmpty(a))
                {
                    sal.setError("Enter basic salary");
                }
                if(TextUtils.isEmpty(b))
                {
                    sal.setError("Enter basic salary");
                }
                if(TextUtils.isEmpty(c))
                {
                    c="0";
                }
                if(TextUtils.isEmpty(d))
                {
                    d="0";
                }
                if(TextUtils.isEmpty(z))
                {
                    z="0";
                }

                Float bsal=Float.parseFloat(a);
                Float h=Float.parseFloat(b);
                Float sallow=Float.parseFloat(c);
                Float leaveallow=Float.parseFloat(d);
                Float std=Float.parseFloat(z);

                Float gross=bsal+h+sallow+leaveallow-std;
                Float t1=Float.parseFloat("0");
                Float t2=Float.parseFloat("0");
                Float t3=Float.parseFloat("0");
                Float total,cess;

                gsal.setText(gross.toString());
                if(gross>250000 && gross<=500000)
                {
                    float x=250000;
                    t1=(x*5)/100;
                }
                if(gross>500000 && gross<=1000000)
                {
                    float y=802000-500000;
                    t2=(y*20)/100;
                }
                if(gross>1000000)
                {
                    t1=Float.parseFloat("0");
                    t2 = Float.parseFloat("0");
                    t3=(gross*30)/100;
                }
                total=t1+t2+t3;
                cess=(total*30)/100;

                Float inctax=total+cess;
                tax.setText(inctax.toString());
            }
        });
     b2.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             sal.setText("");
             hra.setText("");
             alow1.setText("");
             alow2.setText("");
             stdded.setText("");
             tax.setText("");
             gsal.setText("");
         }
     });
    }
}
