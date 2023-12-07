package com.farez.projectsbp.activity.listgame;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.farez.projectsbp.R;
import com.farez.projectsbp.activity.detailgameactivity.DetailGameActivity;
import com.farez.projectsbp.data.model.Game;
import com.farez.projectsbp.databinding.RvItemGameBinding;
import com.farez.projectsbp.util.KeyUtil;

import java.util.ArrayList;
import java.util.List;

public class ListGameAdapter extends RecyclerView.Adapter<ListGameAdapter.GameViewHolder> {
    List<Game> gameList = new ArrayList<>();

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RvItemGameBinding binding = RvItemGameBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new GameViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
        Game game = gameList.get(position);
        RvItemGameBinding binding = holder.binding;
        Glide.with(holder.itemView.getContext())
                .load(game.getImageUrl())
                .placeholder(R.drawable.no_image)
                .transform(new RoundedCorners(12))
                .into(binding.ivGameImage);
        binding.tvGameName.setText(game.getNama());
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), DetailGameActivity.class);
            intent.putExtra(KeyUtil.KEY_GAME_INTENT, game);
            view.getContext().startActivity(intent);
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
            this.binding = binding;
        }
    }

    public void setGameList(List<Game> gameList) {
        this.gameList.clear();
        this.gameList.addAll(gameList);
        notifyDataSetChanged();
    }
}
