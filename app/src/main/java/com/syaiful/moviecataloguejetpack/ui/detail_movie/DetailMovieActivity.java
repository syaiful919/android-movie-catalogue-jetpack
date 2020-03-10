package com.syaiful.moviecataloguejetpack.ui.detail_movie;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.syaiful.moviecataloguejetpack.R;
import com.syaiful.moviecataloguejetpack.data.MovieEntity;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    private TextView tvTitle;
    private TextView tvDescription;
    private ImageView imgPoster;
    private MovieEntity movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        String actionBarTitle = "Catalogue Title";

        tvTitle = findViewById(R.id.txt_name_detail);
        tvDescription = findViewById(R.id.txt_description_detail);
        imgPoster = findViewById(R.id.img_poster_detail);

        movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        DetailMovieViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DetailMovieViewModel.class);
        viewModel.setSelectedMovie(movie.getType(), movie.getId());
        if (movie.getType().equals("movie")) {
            actionBarTitle = "Movie Detail";
        } else if (movie.getType().equals("tv")) {
            actionBarTitle = "TV Show Detail";
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(actionBarTitle);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        populateDetail(viewModel.getSelectedMovie());
    }

    private void populateDetail(MovieEntity movie) {
        tvTitle.setText(movie.getTitle());
        tvDescription.setText(movie.getDescription());
        Glide.with(this)
                .load(movie.getPosterPath())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(imgPoster);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
