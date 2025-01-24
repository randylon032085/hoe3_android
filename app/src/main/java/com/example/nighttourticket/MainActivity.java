package com.example.nighttourticket;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    final double weekdayPerPerson = 7.50;
    final double weekendPerPerson = 8.00;
    int index = 0;
    Spinner spinner;
    TextView tvTotal;
    EditText edtNumber;
    Button button;
    NumberFormat format = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        edtNumber = findViewById(R.id.edtNumber);
        button = findViewById(R.id.btnCompute);
        tvTotal = findViewById(R.id.tvTotal);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.tvGroup, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        index = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void TOTAl(View view){
        double total = 0;
        double sum = Double.parseDouble(String.valueOf(edtNumber.getText()));
        if(index == 0){


            Toast.makeText(this, "Please input number", Toast.LENGTH_SHORT).show();
        }

        if(index == 1){
           total = sum*weekdayPerPerson;
            Toast.makeText(this, "Your total is"+total, Toast.LENGTH_SHORT).show();
            String formated = format.format(total);
            tvTotal.setText(formated);
        }
        if(index == 2){
            total = sum*weekendPerPerson;

            String formated = format.format(total);
            tvTotal.setText(formated);
        }

    }

}