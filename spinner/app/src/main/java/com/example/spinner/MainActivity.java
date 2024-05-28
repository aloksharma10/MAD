package com.example.spinner;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

//public class MainActivity extends AppCompatActivity {
//String strp[]={"https://www.bciit.ac.in","venus","venus", "earth", "mars"};
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        Spinner spinner = findViewById(R.id.spinner);
//
//        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
//
//
//
////        spinner.setAder = findViewById(R.id.spinner);
////
////        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
////                this,
////                R.array.planets_array,
////                android.R.layout.simple_spinner_item
////        );
////
////        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
////
////        spinner.setAdapter(adapter);
//    }
//}
//
//
public class MainActivity extends AppCompatActivity {
    final String urls[]={"https://www.bciit.ac.in/",
            "https://www.facebook.com/",
            "https://www.youtube.com/",
            "https://www.instagram.com/accounts/login/?hl=en",
            "https://accounts.snapchat.com/accounts/v2/login",
            "https://web.whatsapp.com/"};
    TextView selectedItemTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectedItemTextView=(TextView)findViewById(R.id.textView);

        Spinner spin=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, urls
        );
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,
                        "Selected Url: " + urls[i],
                        Toast.LENGTH_SHORT).show();
                selectedItemTextView.setText(urls[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "No Selected User",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void Go_URL(View view){
        String url=selectedItemTextView.getText().toString();
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
