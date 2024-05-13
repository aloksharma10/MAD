package com.example.converter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText rupeesInput;
    TextView resultText;
    Button convertToRublesButton, convertToEurosButton, convertToDollarsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rupeesInput = findViewById(R.id.rupeesInput);
        resultText = findViewById(R.id.resultText);
        convertToRublesButton = findViewById(R.id.convertToRublesButton);
        convertToEurosButton = findViewById(R.id.convertToEurosButton);
        convertToDollarsButton = findViewById(R.id.convertToDollarsButton);

        convertToRublesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCurrency(1.10, "Rubles"); // Conversion rate: 1 Rupee = 0.013 Rubles (example rate)
            }
        });

        convertToEurosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCurrency(0.011, "Euros"); // Conversion rate: 1 Rupee = 0.011 Euros (example rate)
            }
        });

        convertToDollarsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCurrency(0.012, "Dollars"); // Conversion rate: 1 Rupee = 0.014 Dollars (example rate)
            }
        });
    }

    private void convertCurrency(double conversionRate, String currencyName) {
        // Get the amount in Rupees entered by the user
        double rupees = Double.parseDouble(rupeesInput.getText().toString());

        // Convert Rupees to selected currency
        double convertedAmount = rupees * conversionRate;

        // Display the result
        resultText.setText(String.format("%.2f Rupees = %.2f %s", rupees, convertedAmount, currencyName));
    }
}
