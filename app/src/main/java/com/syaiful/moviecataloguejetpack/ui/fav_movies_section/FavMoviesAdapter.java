package com.syaiful.moviecataloguejetpack.ui.fav_movies_section;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.syaiful.moviecataloguejetpack.R;
import com.syaiful.moviecataloguejetpack.data.source.local.entity.MovieEntity;
import com.syaiful.moviecataloguejetpack.ui.detail_movie.DetailMovieActivity;

public class FavMoviesAdapter extends PagedListAdapter<MovieEntity, FavMoviesAdapter.FavMoviesViewHolder> {

    FavMoviesAdapter() {
        super(DIFF_CALLBACK);
    }

    private static DiffUtil.ItemCallback<MovieEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<MovieEntity>() {
                @Override
                public boolean areItemsTheSame(@NonNull MovieEntity oldItem, @NonNull MovieEntity newItem) {
                    return oldItem.getMovieId().equals(newItem.getMovieId());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull MovieEntity oldItem, @NonNull MovieEntity newItem) {
                    return oldItem.equals(newItem);
                }
            };

    @NonNull
    @Override
    public FavMoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_movie, parent, false);
        return new FavMoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavMoviesViewHolder holder, int position) {
        MovieEntity movie = getItem(position);
        if (movie != null) {
            holder.bind(movie);
        }
    }

    public class FavMoviesViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle;
        final TextView tvDescription;
        final ImageView imgPoster;

        public FavMoviesViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            imgPoster = itemView.findViewById(R.id.img_poster);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
        }

        void bind(final MovieEntity movie) {
            tvTitle.setText(movie.getTitle());
            tvDescription.setText(movie.getDescription());
            Glide.with(itemView.getContext())
                    .load(movie.getPosterPath())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(imgPoster);
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailMovieActivity.class);
                intent.putExtra(DetailMovieActivity.EXTRA_TYPE, "movie");
                intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie);
                itemView.getContext().startActivity(intent);
            });

        }
    }
}