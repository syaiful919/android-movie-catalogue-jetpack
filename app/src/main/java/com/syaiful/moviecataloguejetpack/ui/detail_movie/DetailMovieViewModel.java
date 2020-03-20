package com.syaiful.moviecataloguejetpack.ui.detail_movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.syaiful.moviecataloguejetpack.data.MovieEntity;
import com.syaiful.moviecataloguejetpack.data.source.MovieCatalogueRepository;
import com.syaiful.moviecataloguejetpack.utils.DummyData;

public class DetailMovieViewModel extends ViewModel {
    private MovieCatalogueRepository repository;
    private String movieId;
    private String type;

    public DetailMovieViewModel(MovieCatalogueRepository repository){
        this.repository = repository;
    }

    public void setSelectedMovie(String type, String id) {
        this.type = type;
        this.movieId = id;
    }

    public LiveData<MovieEntity> getSelectedMovie() {
        LiveData<MovieEntity> selectedMovie = null;
        if (type.equals("movie")) {
            selectedMovie = repository.getMovie(movieId);
        } else if (type.equals("tv")) {
            selectedMovie = repository.getTvShow(movieId);
        }

        return selectedMovie;
    }

}
