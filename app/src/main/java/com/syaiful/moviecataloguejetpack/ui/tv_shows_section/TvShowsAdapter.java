package com.syaiful.moviecataloguejetpack.ui.tv_shows_section;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.syaiful.moviecataloguejetpack.R;
import com.syaiful.moviecataloguejetpack.data.MovieEntity;
import com.syaiful.moviecataloguejetpack.ui.detail_movie.DetailMovieActivity;

import java.util.ArrayList;
import java.util.List;

public class TvShowsAdapter extends RecyclerView.Adapter<TvShowsAdapter.TvShowsAdapterViewHolder> {
    private List<MovieEntity> listTvShows = new ArrayList<>();

    void setTvShows(List<MovieEntity> listTvShows) {
        if (listTvShows == null) return;
        this.listTvShows.clear();
        this.listTvShows.addAll(listTvShows);
    }

    @NonNull
    @Override
    public TvShowsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_movie, parent, false);
        return new TvShowsAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowsAdapterViewHolder holder, int position) {
        MovieEntity tvShow = listTvShows.get(position);
        holder.bind(tvShow);
    }

    @Override
    public int getItemCount() {
        return listTvShows.size();
    }

    public class TvShowsAdapterViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle;
        final TextView tvDescription;
        final ImageView imgPoster;

        public TvShowsAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            imgPoster = itemView.findViewById(R.id.img_poster);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
        }

        public void bind(MovieEntity tvShow) {
            tvTitle.setText(tvShow.getTitle());
            tvDescription.setText(tvShow.getDescription());
            Glide.with(itemView.getContext())
                    .load(tvShow.getPosterPath())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(imgPoster);
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailMovieActivity.class);
                intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, tvShow);
                itemView.getContext().startActivity(intent);
            });
        }
    }
}
