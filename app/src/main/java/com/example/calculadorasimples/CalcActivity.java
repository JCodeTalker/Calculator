package com.example.calculadorasimples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class CalcActivity extends AppCompatActivity {

    EditText editTextNumber, editTextNumber2;
    Button somar;
    TextView result;
    int values[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        editTextNumber = findViewById(R.id.editTextNumber);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        result = findViewById(R.id.result);

        somar = findViewById(R.id.somar2);
        somar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isFilled()) {
                    values = getEditValues();
                    result.setText("Total: " + Integer.toString(values[0] + values[1]));
                }
            }
        });
    }


    public int[] getEditValues() {
        int num = Integer.parseInt(editTextNumber.getText().toString());
        int num2 = Integer.parseInt(editTextNumber2.getText().toString());

        int values[] = {num, num2};

        return values;
    }


    public Boolean isFilled() {
        if (editTextNumber.getText().toString().equals("") || editTextNumber2.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "You must fill all fields.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


    public void subtrair(View v) {
        if (isFilled()) {
            values = getEditValues();
            result.setText("Diferença: " + Integer.toString(values[0] - values[1]));
        }
    }


    public void multiplicar(View v) {
        if(isFilled()) {
        values = getEditValues();
        result.setText("Produto: " + Integer.toString(values[0] * values[1]));
        }
    }


    public void dividir(View v) {
        if (isFilled()) {
            values = getEditValues();
            result.setText("Quociente: " + Integer.toString(values[0] / values[1]));
        }
    }
}