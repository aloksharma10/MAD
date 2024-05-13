package com.example.checkbox;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private LinearLayout checkBoxContainer;
    private TextView selectedItemsTextView;
    private ArrayList<String> selectedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBoxContainer = findViewById(R.id.checkBoxContainer);
        selectedItemsTextView = findViewById(R.id.selectedItemsTextView);
        selectedItems = new ArrayList<>();
        addCheckBox("Milk");
        addCheckBox("Bread");
        addCheckBox("Eggs");
        addCheckBox("Butter");
    }

    private void addCheckBox(final String item) {
        CheckBox checkBox = new CheckBox(this);
        checkBox.setText(item);
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                selectedItems.add(item);
            } else {
                selectedItems.remove(item);
            }
            updateSelectedItemsTextView();
        });
        checkBoxContainer.addView(checkBox);
    }

    private void updateSelectedItemsTextView() {
        StringBuilder stringBuilder = new StringBuilder("Selected Items:\n");
        for (String item : selectedItems) {
            stringBuilder.append("- ").append(item).append("\n");
        }
        selectedItemsTextView.setText(stringBuilder.toString());
    }
}