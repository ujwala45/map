package com.example.program13;

import android.Manifest;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    EditText location;

    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        location = findViewById(R.id.location);

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
    }

    // GIVEN LOCATION
    public void givenLocation(View v) {

        String loc = location.getText().toString();

        if(loc.isEmpty()) {
            Toast.makeText(this,
                    "Enter Location",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        Uri uri = Uri.parse("geo:0,0?q=" + loc);

        startActivity(new Intent(Intent.ACTION_VIEW, uri));

        Toast.makeText(this,
                "Opening Map",
                Toast.LENGTH_SHORT).show();
    }

    // CURRENT LOCATION
    public void currentLocation(View v) {

        try {

            LocationManager lm =
                    (LocationManager)getSystemService(LOCATION_SERVICE);

            Location loc =
                    lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            double lat = loc.getLatitude();
            double lon = loc.getLongitude();

            Uri uri = Uri.parse("geo:"+lat+","+lon);

            startActivity(new Intent(Intent.ACTION_VIEW, uri));

            Toast.makeText(this,
                    "Showing Current Location",
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e) {

            Toast.makeText(this,
                    "Turn ON Location",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
