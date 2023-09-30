package com.farez.projectsbp.activity.detailgameactivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.farez.projectsbp.R;
import com.farez.projectsbp.data.model.Game;
import com.farez.projectsbp.databinding.ActivityDetailGameBinding;
import com.farez.projectsbp.util.KeyUtil;

public class DetailGameActivity extends AppCompatActivity {
    Game game;
    ActivityDetailGameBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupBinding();
    }

    private void setupBinding() {
        binding = ActivityDetailGameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getDataFromListGameActivity();
    }

    private void getDataFromListGameActivity() {
        //BUAT TERIMA DATA YANG KEY-NYA DARI KeyUtil.KEY_GAME_INTENT
        game = (Game) getIntent().getSerializableExtra(KeyUtil.KEY_GAME_INTENT);

        /*
        TODO : LANJUT TAMPILIN SISA DATA YANG BELOM DITAMPILIN
        LIAT ID VIEW/KOMPONEN DI SRC/MAIN/RES/LAYOUT/[Activity Ini]
         */
        binding.tvNamaGame.setText(game.getNama());
        //...
        //...
        //...

        //INI BUAT LOAD IMAGE DARI URL KE IMAGEVIEW
        Glide.with(this)
                .load(game.getImageUrl())
                .fitCenter()
                .transform(new RoundedCorners(12))
                .into(binding.ivGambarGame);
    }
}