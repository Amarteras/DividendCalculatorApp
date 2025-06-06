package com.example.dividentcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editFund, editRate, editMonths;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.topAppBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        editFund = findViewById(R.id.editFund);
        editRate = findViewById(R.id.editRate);
        editMonths = findViewById(R.id.editMonths);
        textResult = findViewById(R.id.textResult);

        Button btnCalculate = findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(v -> calculateDividend());
    }

    public void calculateDividend() {
        try {
            double fund = Double.parseDouble(editFund.getText().toString());
            double rate = Double.parseDouble(editRate.getText().toString());
            int months = Integer.parseInt(editMonths.getText().toString());

            if (months < 1 || months > 12) {
                Toast.makeText(this, "Months must be between 1 and 12", Toast.LENGTH_SHORT).show();
                return;
            }

            double monthly = (rate / 100 / 12) * fund;
            double total = monthly * months;

            String result = String.format("Monthly Dividend: RM %.2f\nTotal Dividend: RM %.2f", monthly, total);
            textResult.setText(result);
        } catch (Exception e) {
            Toast.makeText(this, "Please enter valid values", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        return true;
    }
}