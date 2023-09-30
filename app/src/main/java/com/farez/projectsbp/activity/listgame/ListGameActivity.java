package com.farez.projectsbp.activity.listgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.farez.projectsbp.activity.loginactivity.MainActivity;
import com.farez.projectsbp.data.model.Game;
import com.farez.projectsbp.databinding.ActivityListGameBinding;

import java.util.List;
import java.util.stream.Collectors;

public class ListGameActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    RecyclerView rv;
    ListGameAdapter listGameAdapter;
    ActivityListGameBinding binding;
    List<Game> gameList, filteredList;
    ListGameViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListGameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider.AndroidViewModelFactory(
                this.getApplication())
                .create(ListGameViewModel.class
                );
        rv = binding.rv;
        getGames();
        listGameAdapter = new ListGameAdapter();
        rv.setAdapter(listGameAdapter);
        rv.setLayoutManager(new GridLayoutManager(this, 2));
        rv.setHasFixedSize(false);

        binding.switch1.setOnCheckedChangeListener(this);

    }

    void getGames() {
        viewModel.getGame().observe(this, games -> {
            if (games != null) {
                gameList = games;
                listGameAdapter.setGameList(gameList);
            }
            else {
                Toast.makeText(this, "ERROR : list game null", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean value) {
        if (compoundButton.getId() == binding.switch1.getId()) {
            if (value) {
                filteredList = gameList.stream().filter(game -> game.isGameDewasa() || !game.isGameDewasa()).collect(Collectors.toList());
                listGameAdapter.setGameList(filteredList);
            } else {
                filteredList = gameList.stream().filter(game -> !game.isGameDewasa()).collect(Collectors.toList());
                listGameAdapter.setGameList(filteredList);
            }
        }
    }
}