package com.farez.projectsbp.data.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.farez.projectsbp.data.model.Game;

import java.util.List;

@Dao
public interface GameDao {
    @Query("SELECT * FROM game ORDER BY nama")
    LiveData<List<Game>> getAllGame();

    @Insert
    void insert(Game game);

}
