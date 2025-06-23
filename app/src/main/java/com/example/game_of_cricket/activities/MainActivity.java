package com.example.game_of_cricket.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.game_of_cricket.R;
import com.google.android.material.button.MaterialButton;

import android.widget.ImageView;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {// MainActivity.java
    private MaterialButton startMatchButton;
    private MaterialButton manageTeamsButton;
    private ImageView titleImage;
    private TextView taglineText;
    private TextView peakyTagline;
    private TextView bottomQuote;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        initializeViews();

        //addAnimations();

        setupClickListeners();
    }

    private void initializeViews() {
        startMatchButton = findViewById(R.id.startMatchButton);
        manageTeamsButton = findViewById(R.id.manageTeamsButton);
        titleImage = findViewById(R.id.titleImage);
        taglineText = findViewById(R.id.taglineText);
        peakyTagline = findViewById(R.id.peakyTagline);
        bottomQuote = findViewById(R.id.bottomQuote);
    }

    /*
    private void addAnimations() {
        Animation fadeIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        fadeIn.setDuration(1000);

        Animation glowAnim = AnimationUtils.loadAnimation(this, R.anim.golden_glow);
        titleImage.startAnimation(glowAnim);

        taglineText.startAnimation(fadeIn);
        peakyTagline.startAnimation(fadeIn);
        startMatchButton.startAnimation(fadeIn);
        manageTeamsButton.startAnimation(fadeIn);
        bottomQuote.startAnimation(fadeIn);
    }

     */

    private void setupClickListeners() {
        startMatchButton.setOnClickListener(v -> {
            // Handle start match button click
            Intent intent = new Intent(MainActivity.this, TeamPickerActivity.class);
            startActivity(intent);
        });

        manageTeamsButton.setOnClickListener(v -> {
            // Handle manage teams button click
            Intent intent = new Intent(MainActivity.this, TeamActivity.class);
            startActivity(intent);
        });
    }
}
