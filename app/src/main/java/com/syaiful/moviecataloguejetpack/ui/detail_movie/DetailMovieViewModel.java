package com.syaiful.moviecataloguejetpack.ui.detail_movie;

import androidx.lifecycle.ViewModel;

import com.syaiful.moviecataloguejetpack.data.MovieEntity;
import com.syaiful.moviecataloguejetpack.utils.DummyData;

public class DetailMovieViewModel extends ViewModel {
    private String movieId;
    private String type;

    public void setSelectedMovie(String type, String id) {
        this.type = type;
        this.movieId = id;
    }

    public MovieEntity getSelectedMovie() {
        MovieEntity selectedMovie = null;
        if (type.equals("movie")) {
            selectedMovie = DummyData.getSelectedMovie(movieId);
        } else if (type.equals("tv")) {
            selectedMovie = DummyData.getSelectedTvShows(movieId);
        }

        return selectedMovie;
    }

}
