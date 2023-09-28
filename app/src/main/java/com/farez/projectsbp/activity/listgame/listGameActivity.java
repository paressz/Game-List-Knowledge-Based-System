package com.farez.projectsbp.activity.listgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.farez.projectsbp.R;

public class listGameActivity extends AppCompatActivity {
    RecyclerView rv;
    listGameAdapter listGameAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_game);

        rv = findViewById(R.id.rv);
        listGameAdapter = new listGameAdapter();

    }
}