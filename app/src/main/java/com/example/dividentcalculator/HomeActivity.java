package com.example.dividentcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.topAppBar);
        setSupportActionBar(toolbar);

        Button btnCalculator = findViewById(R.id.btnCalculator);
        Button btnAbout = findViewById(R.id.btnAbout);

        btnCalculator.setOnClickListener(v ->
                startActivity(new Intent(this, MainActivity.class))
        );

        btnAbout.setOnClickListener(v ->
                startActivity(new Intent(this, AboutActivity.class))
        );
    }
}
