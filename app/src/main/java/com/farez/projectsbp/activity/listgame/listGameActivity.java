package com.farez.projectsbp.activity.listgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.CompoundButton;

import com.farez.projectsbp.R;
import com.farez.projectsbp.data.model.Game;
import com.farez.projectsbp.databinding.ActivityListGameBinding;

import java.util.List;
import java.util.stream.Collectors;

public class listGameActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    RecyclerView rv;
    listGameAdapter listGameAdapter;
    ActivityListGameBinding binding;
    List<Game> gameList, filteredList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListGameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        rv = binding.rv;
        gameList = Game.sampleGameList().stream().filter(game-> !game.isGameDewasa()).collect(Collectors.toList());
        listGameAdapter = new listGameAdapter();
        listGameAdapter.setGameList(gameList);
        rv.setAdapter(listGameAdapter);
        rv.setLayoutManager(new GridLayoutManager(this, 2));
        rv.setHasFixedSize(false);

        binding.switch1.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean value) {
        if (compoundButton.getId() == binding.switch1.getId()) {
            if (value) {
                filteredList = Game.sampleGameList().stream().filter(game -> game.isGameDewasa() || !game.isGameDewasa()).collect(Collectors.toList());
                listGameAdapter.setGameList(filteredList);
            } else {
                filteredList = Game.sampleGameList().stream().filter(game -> !game.isGameDewasa()).collect(Collectors.toList());
                listGameAdapter.setGameList(filteredList);
            }
        }
    }
}