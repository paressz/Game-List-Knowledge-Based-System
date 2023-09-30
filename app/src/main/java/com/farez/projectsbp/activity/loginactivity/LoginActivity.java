package com.farez.projectsbp.activity.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.farez.projectsbp.R;
import com.farez.projectsbp.activity.spekinputactivity.SpekInputActivity;

public class LoginActivity extends AppCompatActivity {
    Button btnCariGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnCariGame = findViewById(R.id.button);
        btnCariGame.setOnClickListener( view -> {
            Intent intent = new Intent(this, SpekInputActivity.class);
            startActivity(intent);
        });

    }
}