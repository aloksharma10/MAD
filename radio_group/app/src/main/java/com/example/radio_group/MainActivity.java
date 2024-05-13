package com.example.radio_group;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    private EditText billAmountEditText;
    private RadioGroup discountRadioGroup;
    private Button calculateButton;
    private TextView discountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billAmountEditText = findViewById(R.id.billAmountEditText);
        discountRadioGroup = findViewById(R.id.discountRadioGroup);
        calculateButton = findViewById(R.id.calculateButton);
        discountTextView = findViewById(R.id.discountTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateDiscount();
            }
        });
    }

    private void calculateDiscount() {
        double billAmount = Double.parseDouble(billAmountEditText.getText().toString());
        int selectedDiscountId = discountRadioGroup.getCheckedRadioButtonId();

        double discountPercentage = 0;
        switch (selectedDiscountId) {
            case R.id.discount10RadioButton:
                discountPercentage = 10;
                break;
            case R.id.discount15RadioButton:
                discountPercentage = 15;
                break;
            case R.id.discount20RadioButton:
                discountPercentage = 20;
                break;
        }

        double discountAmount = (billAmount * discountPercentage) / 100;
        String discountText = String.format("Discount: %.2f", discountAmount);
        discountTextView.setText(discountText);
    }
}