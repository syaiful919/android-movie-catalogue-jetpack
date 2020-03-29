package com.syaiful.moviecataloguejetpack.ui.detail_movie;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.syaiful.moviecataloguejetpack.R;
import com.syaiful.moviecataloguejetpack.data.source.local.entity.MovieEntity;
import com.syaiful.moviecataloguejetpack.data.source.local.entity.TvEntity;
import com.syaiful.moviecataloguejetpack.viewmodel.ViewModelFactory;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    public static final String EXTRA_TYPE = "extra_type";
    private TextView tvTitle;
    private TextView tvDescription;
    private TextView tvOverview;
    private ImageView imgPoster;
    private String type;
    private MovieEntity movie;
    private TvEntity tv;
    private ProgressBar progressBar;
    private Menu menu;
    private DetailMovieViewModel viewModel;
    boolean state;

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


        type = getIntent().getStringExtra(EXTRA_TYPE);

        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        viewModel = new ViewModelProvider(this, factory).get(DetailMovieViewModel.class);

        if (type.equals("movie")) {
            actionBarTitle = getString(R.string.movie_detail);
            movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
            viewModel.setId(movie.getMovieId());
        } else if (type.equals("tv")) {
            actionBarTitle = getString(R.string.tv_show_detail);
            tv = getIntent().getParcelableExtra(EXTRA_MOVIE);
            viewModel.setId(tv.getTvId());
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(actionBarTitle);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        progressBar.setVisibility(View.VISIBLE);
        if(type.equals("movie")){
            viewModel.selectedMovie.observe(this, movie -> {
                populateDetailMovie(movie);
                viewVisible();
            });
        } else if(type.equals("tv")){
            viewModel.selectedTv.observe(this, tv -> {
                populateDetailTV(tv);
                viewVisible();
            });
        }
        progressBar.setVisibility(View.GONE);

    }

    private void viewGone(){
        tvTitle.setVisibility(View.GONE);
        tvDescription.setVisibility(View.GONE);
        imgPoster.setVisibility(View.GONE);
        tvOverview.setVisibility(View.GONE);
    }

    private void viewVisible(){
        tvTitle.setVisibility(View.VISIBLE);
        tvDescription.setVisibility(View.VISIBLE);
        imgPoster.setVisibility(View.VISIBLE);
        tvOverview.setVisibility(View.VISIBLE);
    }

    private void populateDetailMovie(MovieEntity movie) {
        tvTitle.setText(movie.getTitle());
        tvDescription.setText(movie.getDescription());
        Glide.with(this)
                .load(movie.getPosterPath())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(imgPoster);
    }

    private void populateDetailTV(TvEntity movie) {
        tvTitle.setText(movie.getTitle());
        tvDescription.setText(movie.getDescription());
        Glide.with(this)
                .load(movie.getPosterPath())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(imgPoster);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        this.menu = menu;
        progressBar.setVisibility(View.VISIBLE);
        if(type.equals("movie")){
            state = movie.isFavorited();
            setFavState(state);
        } else if(type.equals("tv")){
            state = tv.isFavorited();
            setFavState(state);
        }
        progressBar.setVisibility(View.GONE);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else if(item.getItemId() == R.id.action_fav){
            if(type.equals("movie")){
                viewModel.setFavMovie();
            } else if(type.equals("tv")){
                viewModel.setFavTvShow();
            }

            state = !state;
            setFavState(state);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setFavState(boolean state){
        if(menu == null) return;
        MenuItem menuItem = menu.findItem(R.id.action_fav);
        if(state){
            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_favorite));
        } else {
            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_favorite_border));
        }
    }
}
