package com.syaiful.moviecataloguejetpack.ui.fav_tv_shows_section;

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
import com.syaiful.moviecataloguejetpack.data.source.local.entity.TvEntity;
import com.syaiful.moviecataloguejetpack.ui.detail_movie.DetailMovieActivity;

public class FavTvShowsAdapter extends PagedListAdapter<TvEntity, FavTvShowsAdapter.FavTvShowsViewHolder> {

    FavTvShowsAdapter() {
        super(DIFF_CALLBACK);
    }

    private static DiffUtil.ItemCallback<TvEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<TvEntity>() {
                @Override
                public boolean areItemsTheSame(@NonNull TvEntity oldItem, @NonNull TvEntity newItem) {
                    return oldItem.getTvId().equals(newItem.getTvId());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull TvEntity oldItem, @NonNull TvEntity newItem) {
                    return oldItem.equals(newItem);
                }
            };


    @NonNull
    @Override
    public FavTvShowsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_movie, parent, false);
        return new FavTvShowsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavTvShowsViewHolder holder, int position) {
        TvEntity tv = getItem(position);
        if (tv != null) {
            holder.bind(tv);
        }
    }

    public class FavTvShowsViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle;
        final TextView tvDescription;
        final ImageView imgPoster;

        public FavTvShowsViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            imgPoster = itemView.findViewById(R.id.img_poster);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
        }

        void bind(final TvEntity tv) {
            tvTitle.setText(tv.getTitle());
            tvDescription.setText(tv.getDescription());
            Glide.with(itemView.getContext())
                    .load(tv.getPosterPath())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(imgPoster);
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailMovieActivity.class);
                intent.putExtra(DetailMovieActivity.EXTRA_TYPE, "tv");
                intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, tv);
                itemView.getContext().startActivity(intent);
            });

        }
    }
}
