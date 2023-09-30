package com.farez.projectsbp.activity.spekinputactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.farez.projectsbp.activity.listgame.ListGameActivity;
import com.farez.projectsbp.databinding.ActivitySpekInputBinding;
import com.farez.projectsbp.util.KeyUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SpekInputActivity extends AppCompatActivity {
    Map<String, String> spekData = new HashMap<>();
    ActivitySpekInputBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleBinding();
    }
    void handleBinding() {
        binding = ActivitySpekInputBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnCariGame.setOnClickListener(this::onClick);
    }

    public void onClick(View view) {
        if(view.getId() == binding.btnCariGame.getId()) {
            String cpu = binding.edCpu.getText().toString();
            // TODO : LANJUTIN BUAT INPUT YANG LAIN...
            spekData.put(KeyUtil.KEY_CPU, cpu);
            // TODO : LANJUTIN...

            //TODO LANJUT TAMBAHIN FUNGSI BUAT PINDAH KE ACTIVITY LIST GAME
            checkIsNullOrEmpty(cpu, cpu, cpu, cpu);
            Log.d("TAG", "onClick: " + cpu);
        }
    }

    void checkIsNullOrEmpty(String cpu, String ram, String hdd, String vga) {
        if (cpu.isEmpty() ) {
            Toast.makeText(this, "Semua bagian harus diisi", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, ListGameActivity.class);
            intent.putExtra(KeyUtil.KEY_INTENT_SPEK, (Serializable) spekData);
            startActivity(intent);
        }
    }
}