package com.example.calculater;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.plus).setOnClickListener(this);
        findViewById(R.id.minus).setOnClickListener(this);
        findViewById(R.id.div).setOnClickListener(this);
        findViewById(R.id.mult).setOnClickListener(this);

        findViewById(R.id.plus).setOnLongClickListener(this);
        findViewById(R.id.minus).setOnLongClickListener(this);
        findViewById(R.id.div).setOnLongClickListener(this);
        findViewById(R.id.mult).setOnLongClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        TextView textResult = findViewById(R.id.result);
        EditText editNum1 = findViewById(R.id.editTextNumberDecimal);
        EditText editNum2 = findViewById(R.id.editTextNumberDecimal2);
        try {
            double num1 = Double.parseDouble(editNum1.getText().toString());
            double num2 = Double.parseDouble(editNum2.getText().toString());
            switch (v.getId()) {
                case R.id.plus:
                    textResult.setText(String.valueOf(num1 + num2));
                    break;
                case R.id.minus:
                    textResult.setText(String.valueOf(num1 - num2));
                    break;
                case R.id.div:
                    textResult.setText(String.valueOf(num1 / num2));
                    break;
                case R.id.mult:
                    textResult.setText(String.valueOf(num1 * num2));
                    break;
            }
        }catch (NumberFormatException e){
            Toast.makeText(this, "OOPS: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onLongClick(View view) {
        Toast.makeText(this, "Stop clicking me!!!", Toast.LENGTH_SHORT).show();
        return true; // if true DO NOT run click event too!
    }

}