
package com.example.androidi;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editFirstNumber, editSecondNumber;
    private Button plusButton, minusButton, multiplyButton, divideButton;
    private TextView textSeeResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editFirstNumber = findViewById(R.id.editFirstNumber);
        EditText editSecondNumber = findViewById(R.id.editSecondNumber);
        Button plusButton = findViewById(R.id.plusButton);
        Button minusButton = findViewById(R.id.minusButton);
        Button multiplyButton = findViewById(R.id.multiplyButton);
        Button divideButton = findViewById(R.id.divideButton);
        TextView textSeeResult = findViewById(R.id.textSeeResult);

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+', editFirstNumber, editSecondNumber, textSeeResult);
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-', editFirstNumber, editSecondNumber, textSeeResult);
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*', editFirstNumber, editSecondNumber, textSeeResult);
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/', editFirstNumber, editSecondNumber, textSeeResult);
            }
        });
    }

    private void calculate(char operator, EditText firstNumberEditText, EditText secondNumberEditText, TextView resultTextView) {
        double firstNumber = Double.parseDouble(firstNumberEditText.getText().toString());
        double secondNumber = Double.parseDouble(secondNumberEditText.getText().toString());
        double result = 0;

        switch (operator) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                if (secondNumber != 0)
                    result = firstNumber / secondNumber;
                else
                    resultTextView.setText("Cannot divide by zero!");
                break;
        }

        resultTextView.setText("Result: " + result);
    }
}

