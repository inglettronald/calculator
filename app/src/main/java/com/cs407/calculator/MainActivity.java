package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void add(View view) {
        Pair<Integer, Integer> inputs = getInputs();
        if (inputs == null) {
            Toast.makeText(this, "Please input numbers for both fields!", Toast.LENGTH_LONG).show();
            return;
        }
        gotoActivity("Result: " + (inputs.first + inputs.second));
    }

    public void subtract(View view) {
        Pair<Integer, Integer> inputs = getInputs();
        if (inputs == null) {
            Toast.makeText(this, "Please input numbers for both fields!", Toast.LENGTH_LONG).show();
            return;
        }
        gotoActivity("Result: " + (inputs.first - inputs.second));
    }

    public void multiply(View view) {
        Pair<Integer, Integer> inputs = getInputs();
        if (inputs == null) {
            Toast.makeText(this, "Please input numbers for both fields!", Toast.LENGTH_LONG).show();
            return;
        }
        gotoActivity("Result: " + (inputs.first * inputs.second));
    }

    public void divide(View view) {
        Pair<Integer, Integer> inputs = getInputs();
        if (inputs == null) {
            Toast.makeText(this, "Please input numbers for both fields!", Toast.LENGTH_LONG).show();
            return;
        }
        String result;
        if (inputs.second == 0) {
            result = "Error: division by zero";
        } else {
            result = "Result: " + (inputs.first / inputs.second);
        }
        gotoActivity(result);
    }

    private Pair<Integer, Integer> getInputs() {
        EditText number1 = findViewById(R.id.number1);
        EditText number2 = findViewById(R.id.number2);
        String numStr1 = number1.getText().toString();
        String numStr2 = number2.getText().toString();
        if (numStr1.isEmpty() || numStr2.isEmpty()) {
            return null;
        }
        return new Pair<>(
                Integer.parseInt(numStr1),
                Integer.parseInt(numStr2)
        );
    }

    private void gotoActivity(String s) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("message", s);
        startActivity(intent);
    }
}