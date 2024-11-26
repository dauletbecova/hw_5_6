package com.example.hw_7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    TextView result;
    Integer firstNumber, secondNumber;
    boolean isOperation;
    String currentOperation;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
        btnNext = findViewById(R.id.btnNext);
    }

    public void numberClick(View view) {
        if (view instanceof MaterialButton) {
            String text = ((MaterialButton) view).getText().toString();
            if (isOperation) {
                result.setText("");
            }
            result.append(text);
        }
        isOperation = false;
    }

    public void operationClick(View view) {
        if (view.getId() == R.id.clearBtn) {
            result.setText("");
        } else {
            if (view.getId() == R.id.plusBtn) {
                firstNumber = Integer.valueOf(result.getText().toString());
                currentOperation = "+";
            } else if (view.getId() == R.id.minusBtn) {
                firstNumber = Integer.valueOf(result.getText().toString());
                currentOperation = "-";
            } else if (view.getId() == R.id.multiplyBtn) {
                firstNumber = Integer.valueOf(result.getText().toString());
                currentOperation = "*";
            } else if (view.getId() == R.id.divideBtn) {
                firstNumber = Integer.valueOf(result.getText().toString());
                currentOperation = "/";
            }
            else if (view.getId() == R.id.equalBtn) {
                secondNumber = Integer.valueOf(result.getText().toString());
                btnNext.setVisibility(View.VISIBLE);
                result.setText(String.valueOf(result(firstNumber, secondNumber, currentOperation)));
                int sum = result(firstNumber, secondNumber, currentOperation);
                btnNext.setOnClickListener(v -> {
                    Intent intent = new Intent(MainActivity.this, Activity2.class);
                    intent.putExtra("result", sum);
                    startActivity(intent);
                });
        }
            isOperation = true;

        }
    }


    private int result(int firstNumber, int secondNumber, String currentOperation) {
        switch (currentOperation) {
            case "+":
                return firstNumber + secondNumber;
            case "-":
                return firstNumber - secondNumber;
            case "*":
                return firstNumber * secondNumber;
            case "/":
                return firstNumber / secondNumber;
            default:
                return 0;
        }
    }
}
