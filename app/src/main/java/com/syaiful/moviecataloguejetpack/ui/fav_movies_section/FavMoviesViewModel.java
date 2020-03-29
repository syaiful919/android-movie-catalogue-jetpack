package com.syaiful.moviecataloguejetpack.ui.fav_movies_section;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.syaiful.moviecataloguejetpack.data.source.MovieCatalogueRepository;
import com.syaiful.moviecataloguejetpack.data.source.local.entity.MovieEntity;

import java.util.List;

public class FavMoviesViewModel extends ViewModel {
    private MovieCatalogueRepository repository;
    public FavMoviesViewModel(MovieCatalogueRepository repository){
        this.repository = repository;
    }

    public LiveData<List<MovieEntity>> getFavMovies(){
        return repository.getFavMovies();
    }
}
