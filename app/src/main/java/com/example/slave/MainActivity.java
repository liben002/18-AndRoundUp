package com.example.slave;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button workButton;
    private EditText billTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        workButton = findViewById(R.id.workButton);
        billTotal = findViewById(R.id.billTotal);

        workButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
