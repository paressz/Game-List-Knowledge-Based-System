package com.farez.projectsbp.activity.listgame;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.farez.projectsbp.activity.detailgameactivity.DetailGameActivity;
import com.farez.projectsbp.data.model.Game;
import com.farez.projectsbp.databinding.RvItemGameBinding;

import java.util.List;

public class listGameAdapter extends RecyclerView.Adapter<listGameAdapter.GameViewHolder> {
    List<Game> gameList;

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RvItemGameBinding binding = RvItemGameBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        GameViewHolder gameViewHolder = new GameViewHolder(binding);
        return gameViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
        Game game = gameList.get(position);
        RvItemGameBinding binding = holder.binding;
        Glide.with(holder.itemView.getContext())
                .load(game.imageUrl)
                .into(binding.imageView);
        binding.textView.setText(game.nama);
        holder.itemView.setOnClickListener(it -> {
            Intent intent = new Intent(it.getContext(), DetailGameActivity.class);
            intent.putExtra("GAME", game);
            it.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }

    class GameViewHolder extends RecyclerView.ViewHolder {
        RvItemGameBinding binding;
        public GameViewHolder(RvItemGameBinding binding) {
            super(binding.getRoot());
        }
    }

    public void setGameList(List<Game> gameList) {
        this.gameList.clear();
        this.gameList.addAll(gameList);
        notifyDataSetChanged();
    }
}
