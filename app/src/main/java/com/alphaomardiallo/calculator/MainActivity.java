package com.alphaomardiallo.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mETResult;
    private EditText mETNewNumber;
    private TextView mTVOperation;

    private Button mBtn0;
    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;
    private Button mBtn4;
    private Button mBtn5;
    private Button mBtn6;
    private Button mBtn7;
    private Button mBtn8;
    private Button mBtn9;
    private Button mBtnDot;

    private Button mBtnDivide;
    private Button mBtnMultiply;
    private Button mBtnPlus;
    private Button mBtnMinus;
    private Button mBtnEqual;

    // Private variable to hold operand and calculation type
    private Double operand1 = null;
    private Double operand2 = null;
    private String pendingOperation = "=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mETResult = findViewById(R.id.editTextNumberSignedResult);
        mETNewNumber = findViewById(R.id.editTextNumberSignedNewNumber);
        mTVOperation = findViewById(R.id.textViewOperation);
        mBtn0 = findViewById(R.id.button0);
        mBtn1 = findViewById(R.id.button1);
        mBtn2 = findViewById(R.id.button2);
        mBtn3 = findViewById(R.id.button3);
        mBtn4 = findViewById(R.id.button4);
        mBtn5 = findViewById(R.id.button5);
        mBtn6 = findViewById(R.id.button6);
        mBtn7 = findViewById(R.id.button7);
        mBtn8 = findViewById(R.id.button8);
        mBtn9 = findViewById(R.id.button9);
        mBtnDivide = findViewById(R.id.buttonDivide);
        mBtnMultiply = findViewById(R.id.buttonMultiply);
        mBtnPlus = findViewById(R.id.buttonAddition);
        mBtnMinus = findViewById(R.id.buttonSubtract);
        mBtnDot = findViewById(R.id.buttonDot);
        mBtnEqual = findViewById(R.id.buttonEquals);

// Setting up listener for digits
        View.OnClickListener listenerDigits = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                mETNewNumber.append(b.getText().toString());
            }
        };

        mBtn0.setOnClickListener(listenerDigits);
        mBtn1.setOnClickListener(listenerDigits);
        mBtn2.setOnClickListener(listenerDigits);
        mBtn3.setOnClickListener(listenerDigits);
        mBtn4.setOnClickListener(listenerDigits);
        mBtn5.setOnClickListener(listenerDigits);
        mBtn6.setOnClickListener(listenerDigits);
        mBtn7.setOnClickListener(listenerDigits);
        mBtn8.setOnClickListener(listenerDigits);
        mBtn9.setOnClickListener(listenerDigits);
        mBtnDot.setOnClickListener(listenerDigits);

// Setting up listeners for operations
        View.OnClickListener listenerOperation = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                String op = b.getText().toString();
                String value = mETNewNumber.getText().toString();
                if (value.length() != 0) {
                    performOperation(value, op);
                }
                pendingOperation = op;
                mTVOperation.setText(pendingOperation);
            }
        };
        mBtnDivide.setOnClickListener(listenerOperation);
        mBtnMultiply.setOnClickListener(listenerOperation);
        mBtnMinus.setOnClickListener(listenerOperation);
        mBtnPlus.setOnClickListener(listenerOperation);
        mBtnEqual.setOnClickListener(listenerOperation);
    }
    private void performOperation (String value, String operation) {
        mTVOperation.setText(operation);
    }
}