package com.example.extstudent.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView resultTextView = null;
    private EditText minimum = null;
    private EditText maximum = null;
    private Button generateButton = null;
    private int minNum = 1;
    private int maxNum = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.resultTextView = (TextView) findViewById(R.id.textViewResult);
        this.minimum = (EditText) findViewById(R.id.editTextMinimum);
        this.maximum = (EditText) findViewById(R.id.editTextMaximum);
        setDefaultMinMax();
        this.generateButton = (Button) findViewById(R.id.generateButton);
        this.generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchValus();

                generateRand();
                Log.d("My Generate Button", "OnClick press");
                Log.isLoggable("Max", maxNum);
                Log.isLoggable("Min", minNum);

            }
        });
    }

    private void setDefaultMinMax() {
        minimum.setText(Integer.toString(minNum));
        maximum.setText(Integer.toString(maxNum));
    }

    private void fetchValus() {
        this.minNum =  Integer.parseInt(this.minimum.getText().toString());
        this.maxNum =  Integer.parseInt(this.maximum.getText().toString());
    }

    private void generateRand() {
        int randomNum = getRandomInt(minNum, maxNum);
        String randomNumStr = Integer.toString(randomNum);
        resultTextView.setText(randomNumStr);
        Log.d("Random Number", randomNumStr);
    }

    private int getRandomInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max) + min;
    }
}