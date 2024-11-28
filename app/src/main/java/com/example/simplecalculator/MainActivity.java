package com.example.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText num1, num2;
    private Button add, subtract;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the views
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        add = findViewById(R.id.add);
        subtract = findViewById(R.id.subtract);
        result = findViewById(R.id.result);

        // Set up click listeners for the buttons
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("+");
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("-");
            }
        });
    }

    private void performOperation(String operator) {
        String number1 = num1.getText().toString();
        String number2 = num2.getText().toString();

        if (number1.isEmpty() || number2.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double value1 = Double.parseDouble(number1);
            double value2 = Double.parseDouble(number2);
            double calcResult = 0;

            switch (operator) {
                case "+":
                    calcResult = value1 + value2;
                    break;
                case "-":
                    calcResult = value1 - value2;
                    break;
            }

            result.setText("Result: " + calcResult);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
        }
    }
}
