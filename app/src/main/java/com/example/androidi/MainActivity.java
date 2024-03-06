package com.example.androidi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

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

        plusButton.setOnClickListener(v -> calculate('+', editFirstNumber, editSecondNumber, textSeeResult));
        minusButton.setOnClickListener(v -> calculate('-', editFirstNumber, editSecondNumber, textSeeResult));
        multiplyButton.setOnClickListener(v -> calculate('*', editFirstNumber, editSecondNumber, textSeeResult));
        divideButton.setOnClickListener(v -> calculate('/', editFirstNumber, editSecondNumber, textSeeResult));
    }


    private void calculate(char operator, EditText firstNumberEditText, EditText secondNumberEditText, TextView resultTextView) {
        try {
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
                        throw new ArithmeticException("Cannot divide by zero!");
                    break;
            }


            resultTextView.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            resultTextView.setText("Invalid input");
        } catch (ArithmeticException e) {
            resultTextView.setText(e.getMessage());
        }
    }
}



