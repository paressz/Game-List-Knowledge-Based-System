package com.farez.projectsbp.activity.listgame;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.farez.projectsbp.data.database.GameDao;
import com.farez.projectsbp.data.database.GameDatabase;
import com.farez.projectsbp.data.model.Game;

import java.util.List;
import java.util.concurrent.Executors;

public class ListGameViewModel extends AndroidViewModel {

    GameDao gameDao;
    public ListGameViewModel(@NonNull Application application) {
        super(application);
        GameDatabase gameDatabase = GameDatabase.getInstance(application.getApplicationContext());
        gameDao = gameDatabase.gameDao();
    }


    LiveData<List<Game>> getGame() {
        return gameDao.getAllGame();
    }
}
