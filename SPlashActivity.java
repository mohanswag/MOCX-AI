package com.example.myapplication; // Replace with your actual package name

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
//noinspection CustomSplashScreen
import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("CustomSplashScreen") // This is fine if you're aware you're not using the Android 12+ Splash Screen API
public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DELAY_MS = 3000; // 3 seconds delay

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // It's good practice to hide the action bar *before* setting the content view
        // if you are using a theme that shows an action bar by default.
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        // Alternatively, use a NoActionBar theme for this activity in AndroidManifest.xml
        // e.g., android:theme="@style/Theme.AppCompat.Light.NoActionBar"

        setContentView(R.layout.activity_splash);

        // Using a Handler to delay the transition to the next activity.
        // FIX: Replaced anonymous Runnable with a lambda expression for conciseness.
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            // Create an Intent to start the LoginActivity
            // Make sure LoginActivity is created and declared in your AndroidManifest.xml
            // Inside the postDelayed Runnable:
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(intent);
            finish(); // Important: Prevents going back to splash
        }, SPLASH_DELAY_MS);
    }
}
