package com.example.tempconvt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner1,spinner2;
    private EditText Ed1;
    private  TextView ans;
    Button b1;
    String[]  tempc1= {"Celsius","Fahrenheit","Kelvin"};
    String[]  tempc2= {"Celsius","Fahrenheit","Kelvin"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.button);
        ans = (TextView)findViewById(R.id.textView);
        Ed1 = findViewById(R.id.plaintxt1);
        spinner1 = findViewById(R.id.temp1);
        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,tempc1);
        spinner1.setAdapter(adapter1);


        spinner2 = findViewById(R.id.temp2);
        ArrayAdapter adapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,tempc2);
        spinner2.setAdapter(adapter2);



    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Double res = null;
            Double mid = Double.parseDouble(Ed1.getText().toString());


            if((spinner1.getSelectedItem().toString() == "Celsius") && (spinner2.getSelectedItem().toString() =="Celsius") || (spinner1.getSelectedItem().toString() == "Fahrenheit") && (spinner2.getSelectedItem().toString() =="Fahrenheit") || (spinner1.getSelectedItem().toString() == "Kelvin") && (spinner2.getSelectedItem().toString() =="Kelvin")){
                res = mid;
            }
            else if((spinner1.getSelectedItem().toString()== "Celsius") && (spinner2.getSelectedItem().toString() =="Fahrenheit")){
                res = (9.0 / 5.0) * mid + 32;
            }
            else if((spinner1.getSelectedItem().toString()== "Fahrenheit") && (spinner2.getSelectedItem().toString() =="Celsius")){
                res  = ((mid-32)*5.0)/9.0;
            }
            else if((spinner1.getSelectedItem().toString()== "Celsius") && (spinner2.getSelectedItem().toString() =="Kelvin")){
                res = (mid) + 273.15;
            }
            else if((spinner1.getSelectedItem().toString()== "Kelvin") && (spinner2.getSelectedItem().toString() =="Celsius")){
                res = (mid) - 273.15;
            }
            else if((spinner1.getSelectedItem().toString() == "Fahrenheit") && (spinner2.getSelectedItem().toString() =="Kelvin")){
                res = 273.5f + (mid - 32.0f) * (5.0f/9.0f);
            }
            else if((spinner1.getSelectedItem().toString() == "Kelvin") && (spinner2.getSelectedItem().toString() =="Fahrenheit")){
                res = ((mid - 273.15) * 1.8) + 32.0;

            }
            String deg;
            if(spinner2.getSelectedItem().toString() =="Celsius"){deg ="°C"; }
            else if(spinner2.getSelectedItem().toString() =="Kelvin"){deg ="K"; }
            else{deg = "°F";}

            ans.setText(res.toString()+" "+deg);



        }
    });






    }
}