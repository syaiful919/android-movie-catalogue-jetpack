package com.syaiful.moviecataloguejetpack.ui.movies_section;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.syaiful.moviecataloguejetpack.data.MovieEntity;
import com.syaiful.moviecataloguejetpack.data.source.MovieCatalogueRepository;
import com.syaiful.moviecataloguejetpack.utils.DummyData;

import java.util.ArrayList;
import java.util.List;

public class MoviesViewModel extends ViewModel {
    private MovieCatalogueRepository repository;
    public MoviesViewModel(MovieCatalogueRepository repository){
        this.repository = repository;
    }

    public LiveData<ArrayList<MovieEntity>> getMovies() {
        return repository.getMovies();
    }
}
