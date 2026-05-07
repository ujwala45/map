package com.example.program13;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText location;

    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        location = findViewById(R.id.location);
    }

    public void showMap(View v) {

        String loc = location.getText().toString();

        // Validation
        if(loc.isEmpty()) {
            Toast.makeText(this, "Enter Location", Toast.LENGTH_SHORT).show();
            return;
        }

        // Open Google Map
        Uri uri = Uri.parse("geo:0,0?q=" + loc);
        Intent i = new Intent(Intent.ACTION_VIEW, uri);

        startActivity(i);

        Toast.makeText(this, "Opening Map...", Toast.LENGTH_SHORT).show();
    }
}