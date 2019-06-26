package com.example.slave;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        TextView result = findViewById(R.id.result);
        TextView Tip = findViewById(R.id.tip);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String amountOfEach = extras.getString("amountEach");

            amountOfEach = "$" + amountOfEach + ".00";
            result.setText(amountOfEach);

            String writeTip = extras.getString("writeTip");
            writeTip = "$" + writeTip;
            Tip.setText(writeTip);
        }


    }
}
