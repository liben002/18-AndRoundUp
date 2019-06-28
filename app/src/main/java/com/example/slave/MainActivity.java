package com.example.slave;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText billTotal;
    private EditText amountOfPeople;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button workButton;
        billTotal = findViewById(R.id.billTotal);
        amountOfPeople = findViewById(R.id.amountOfPeople);
        workButton = findViewById(R.id.workButton);
        workButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String billString = billTotal.getText().toString();
        float billFloat = Float.valueOf(billString);
        float tip = (float) 0.18;

        String amountOfPeopleString = amountOfPeople.getText().toString();
        int amountOfPeopleInt = Integer.parseInt(amountOfPeopleString);

        float billFloatWithTip = billFloat + billFloat*tip;
        int billInt = (int) Math.ceil(billFloatWithTip);

        boolean evenlyDivided = false;
        int amountOfEach = 0;

        do {
            if (billInt % amountOfPeopleInt == 0) {
                evenlyDivided = true;
                amountOfEach = billInt / amountOfPeopleInt;
            } else {
                billInt++;
            }
        } while (!evenlyDivided);

        float writeTip = billInt - billFloat;

        Intent i = new Intent(MainActivity.this, Result.class);
        i.putExtra("amountEach", String.valueOf(amountOfEach));
        i.putExtra("writeTip", String.format(Locale.US,"%.2f",writeTip));
        startActivity(i);

    }
}
