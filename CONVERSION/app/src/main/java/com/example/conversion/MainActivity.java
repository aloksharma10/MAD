package com.example.conversion;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText from, to;
        Button convert, cls;
        TextView result;

        from = (EditText) findViewById(R.id.from);
        to = (EditText) findViewById(R.id.to);

        convert = (Button) findViewById(R.id.conv);
        cls = (Button) findViewById(R.id.clr);




        cls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                from.setText("");
                to.setText("");
            }
        });

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the value from the 'From' field
                double kmValue = Double.parseDouble(from.getText().toString());

                // Convert km to miles (1 mile = 1.60934 km)
                double mileValue = kmValue / 1.60934;

                // Display the result in the 'To' field
                to.setText(String.format("%.2f", mileValue));
            }
        });

    }
}
