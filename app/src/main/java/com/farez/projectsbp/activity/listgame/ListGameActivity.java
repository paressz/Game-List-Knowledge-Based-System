package com.farez.projectsbp.activity.listgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.farez.projectsbp.data.model.Game;
import com.farez.projectsbp.databinding.ActivityListGameBinding;
import com.farez.projectsbp.util.KeyUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListGameActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    RecyclerView rv;
    ListGameAdapter listGameAdapter;
    ActivityListGameBinding binding;
    List<Game> gameList, filteredList;
    ListGameViewModel viewModel;
    Map<String, String> keywordSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListGameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        boolean showAllGames = getIntent().getBooleanExtra("ALL", false);
        viewModel = new ViewModelProvider.AndroidViewModelFactory(
                this.getApplication())
                .create(ListGameViewModel.class
                );
        getGamesFromDatabase(showAllGames);
        setupRecyclerView();
        binding.switch1.setOnCheckedChangeListener(this);

    }

    void setupRecyclerView() {
        rv = binding.rv;
        listGameAdapter = new ListGameAdapter();
        rv.setAdapter(listGameAdapter);
        rv.setLayoutManager(new GridLayoutManager(this, 2));
        rv.setHasFixedSize(false);
    }

    void getGamesFromDatabase(boolean showAllGames) {
        viewModel.getGame().observe(this, games -> {
            if (!showAllGames) {
                if (games != null) {
                    gameList = games;
                    handleSearch();
                    filteredList = gameList.stream().filter(game -> !game.isGameDewasa()).collect(Collectors.toList());
                    listGameAdapter.setGameList(filteredList);
                    if (filteredList.isEmpty()) binding.tvNoGame.setVisibility(View.VISIBLE);
                    else binding.tvNoGame.setVisibility(View.GONE);
                }
                else {
                    binding.tvNoGame.setVisibility(View.VISIBLE);
                    Toast.makeText(this, "ERROR : list game bernilai null", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                gameList = games;
                listGameAdapter.setGameList(gameList);
            }
        });
    }
    //Fungsi buat handle kalo switch 18+ diganti
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean value) {
        if (compoundButton.getId() == binding.switch1.getId()) {
            if (value) {
                filteredList = gameList;
                listGameAdapter.setGameList(filteredList);
                checkIsListEmpty();
            } else {
                filteredList = gameList.stream().filter(game -> !game.isGameDewasa()).collect(Collectors.toList());
                listGameAdapter.setGameList(filteredList);
                checkIsListEmpty();
            }
        }
    }
// method buat handle search berdasarkan
// data cpu, ram, hdd, dan vga
// yang diinput dari spekInputActivity
    void handleSearch() {
        Serializable spekData = getIntent().getSerializableExtra(KeyUtil.KEY_INTENT_SPEK);
        if (spekData != null) {
            keywordSearch = (HashMap<String, String>) spekData;
        } else  {
            Toast.makeText(this, "DATA SPEK TIDAK ADA", Toast.LENGTH_SHORT).show();
        }
        gameList = gameList
                .stream()
                .filter(
                game ->
                        game.getCpu().toUpperCase().trim().contains(keywordSearch.get(KeyUtil.KEY_CPU).toUpperCase().trim())
                                &&
                        game.getRam() <= Integer.parseInt(keywordSearch.get(KeyUtil.KEY_RAM))
                                &&
                        game.getHdd() <= Integer.parseInt(keywordSearch.get(KeyUtil.KEY_HDD))
                                ||
                        game.getVga().toUpperCase().trim().contains(keywordSearch.get(KeyUtil.KEY_VGA).toUpperCase().trim())
                )
                .collect(Collectors.toList());
    }
    void checkIsListEmpty() {
        if (filteredList.isEmpty()) {
            binding.tvNoGame.setVisibility(View.VISIBLE);
        }
        else {
            binding.tvNoGame.setVisibility(View.GONE);
        }
    }
}