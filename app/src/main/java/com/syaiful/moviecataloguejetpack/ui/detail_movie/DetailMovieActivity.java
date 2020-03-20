package com.syaiful.moviecataloguejetpack.ui.detail_movie;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.syaiful.moviecataloguejetpack.R;
import com.syaiful.moviecataloguejetpack.data.MovieEntity;
import com.syaiful.moviecataloguejetpack.viewmodel.ViewModelFactory;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    private TextView tvTitle;
    private TextView tvDescription;
    private TextView tvOverview;
    private ImageView imgPoster;
    private MovieEntity movie;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        String actionBarTitle = getString(R.string.catalogue_title);

        tvTitle = findViewById(R.id.txt_name_detail);
        tvDescription = findViewById(R.id.txt_description_detail);
        imgPoster = findViewById(R.id.img_poster_detail);
        progressBar = findViewById(R.id.progressBar);
        tvOverview = findViewById(R.id.overview);

        viewGone();


        movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        DetailMovieViewModel viewModel = new ViewModelProvider(this, factory).get(DetailMovieViewModel.class);
        viewModel.setSelectedMovie(movie.getType(), movie.getId());

        if (movie.getType().equals("movie")) {
            actionBarTitle = getString(R.string.movie_detail);
        } else if (movie.getType().equals("tv")) {
            actionBarTitle = getString(R.string.tv_show_detail);
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(actionBarTitle);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        progressBar.setVisibility(View.VISIBLE);
        viewModel.getSelectedMovie().observe(this, movie -> {
            viewVisible();
            progressBar.setVisibility(View.GONE);
            populateDetail(movie);
        });

    }

    private void viewGone(){
        tvTitle.setVisibility(View.GONE);
        tvDescription.setVisibility(View.GONE);
        imgPoster.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        tvOverview.setVisibility(View.GONE);
    }

    private void viewVisible(){
        tvTitle.setVisibility(View.VISIBLE);
        tvDescription.setVisibility(View.VISIBLE);
        imgPoster.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        tvOverview.setVisibility(View.VISIBLE);
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
