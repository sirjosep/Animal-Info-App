package com.josepvictorr.animalinfoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getSupportActionBar().hide();

        ImageButton btnHomeProfile = findViewById(R.id.back_home_profile);
        btnHomeProfile.setOnClickListener(view -> {
            Intent homeProfileIntent = new Intent(ProfileActivity.this, MainActivity.class);
            homeProfileIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(homeProfileIntent);
            finish();
        });
    }
}