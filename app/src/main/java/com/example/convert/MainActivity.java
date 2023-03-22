package com.example.convert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText amnt;
Spinner from;
Spinner to;
Button convert;
TextView txt;
ArrayAdapter<String> model;
String[] currencies={"MAD","USD","EUR"};
String[] symbole={"DH","$","€"};
double [][] exchange={
        {1,0.96,0.90},
        {10.41,1,0.93},
        {11.15,1.07,1}
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        model= new ArrayAdapter<String>(this,R.layout.item_file,currencies);
        amnt=findViewById(R.id.amount);
        from=findViewById(R.id.from);
        to=findViewById(R.id.to);
        convert=findViewById(R.id.convert);
        txt=findViewById(R.id.txts);
        from.setAdapter(model);
        to.setAdapter(model);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rslt=Integer.parseInt(amnt.getText().toString());
                int f=Integer.parseInt(from.getSelectedItemId()+"");
                int t=Integer.parseInt(from.getSelectedItemId()+"");
                double cal=rslt*exchange[f][t];
                txt.setText(cal+""+symbole[t]);
            }
        });

    }
}