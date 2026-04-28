package com.lms.logger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // කෙලින්ම Accessibility Settings පිටුවට රැගෙන යයි
        Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        
        Toast.makeText(this, "කරුණාකර Installed Apps තුළ ඇති Logger සේවාව On කරන්න", Toast.LENGTH_LONG).show();
        finish(); // පිටුව වසා දමයි
    }
}
