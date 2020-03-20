package com.syaiful.moviecataloguejetpack.data.source;

import androidx.lifecycle.LiveData;

import com.syaiful.moviecataloguejetpack.data.MovieEntity;

import java.util.ArrayList;

public interface MovieCatalogueDataSource {
    LiveData<ArrayList<MovieEntity>> getMovies();
    LiveData<ArrayList<MovieEntity>> getTvShows();
    LiveData<MovieEntity> getMovie(String id);
    LiveData<MovieEntity> getTvShow(String id);
}
