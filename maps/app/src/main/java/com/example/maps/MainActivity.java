package com.example.maps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    String loc = "Delhi";
    EditText edtLoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.edtLocation), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtLoc = (EditText) findViewById(R.id.edtLocation);
        Toast.makeText(peekAvailableContext().getApplicationContext(), "Select Location", Toast.LENGTH_SHORT).show();
    }
    public void openMap(View v){
        loc = edtLoc.getText().toString();
        Uri u = Uri.parse("https://maps.google.com/maps?&q=" + loc.toString());
        Intent i = new Intent(Intent.ACTION_VIEW,u);
        v.getContext().startActivity(i);
    }
    public void TravelPath(View v){
        loc = edtLoc.getText().toString();
        Uri u = Uri.parse("https://maps.google.com/maps?&q=" + loc.toString());
        Intent i = new Intent(Intent.ACTION_VIEW,u);
        v.getContext().startActivity(i);
    }
}